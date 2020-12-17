import React, { useState } from 'react';
import PartnerSectionOne from './children/PartnerSectionOne';
import PartnerSectionTwo from './children/PartnerSectionTwo';
import PartnerSectionThree from './children/PartnerSectionThree';
import Axios from 'axios';



const REGISTER_PARTNER_API_URL = "http://localhost:8080/AlterHabits/insertPartner";



export default function PartnerForm(props) {

    const [panelNumber, setPanelNumber] = useState(0);

    const [files, setFiles] = useState([]);
    const [shopName, setShopName] = useState('');
    const [shopEmail, setShopEmail] = useState('');
    const [selectedActivities, setSelectedActivities] = useState([]);
    const [latitude, setLatitude] = useState('');
    const [longitude, setLongitude] = useState('');

    function onClickForm(e) {
        e.stopPropagation();
    }

    function handleButtonClick(direction, e) {
        if (direction === 'back') {
            setPanelNumber(panelNumber - 1);
        } else if (direction === 'forward') {
            setPanelNumber(panelNumber + 1);
        } else if (direction === 'submit') {
            console.log("inside submit")
            let reader = new FileReader();
            reader.readAsDataURL(files[0])

            reader.onload = () => {
                console.log("inside reader")
                console.log({
                    shopName,
                    shopEmail,
                    latitude,
                    longitude,
                    selectedActivities,
                    file: reader.result.split(',')[1]
                })
                Axios.post(REGISTER_PARTNER_API_URL, {
                    shopName: shopName,
                    shopEmail: shopEmail,
                    shopLatitude: latitude,
                    shopLongitude: longitude,
                    shopImage: reader.result.split(',')[1],
                    shopActivities: selectedActivities
                }).then(response => {
                    console.log(response)
                    props.setDisplayedModal('')
                    props.setShopsUpdated(true)
                })
            }


        }
    }

    return (
        <div className={props.customPartnerFormStyle} onClick={onClickForm}>
            {
                panelNumber === 0 &&
                <PartnerSectionOne
                    shopName={shopName}
                    setShopName={setShopName}
                    selectedActivities={selectedActivities}
                    setSelectedActivities={setSelectedActivities}
                    shopEmail={shopEmail}
                    setShopEmail={setShopEmail}
                />
            }
            {
                panelNumber === 1 &&
                <PartnerSectionTwo
                    files={files}
                    setFiles={setFiles} />
            }
            {
                panelNumber === 2 &&
                <PartnerSectionThree
                    setLatitude={setLatitude}
                    setLongitude={setLongitude} />
            }
            <div className="buttons-container">
                <button className="back-button" disabled={panelNumber < 1 && true} onClick={e => handleButtonClick('back', e)}>Previous</button>
                <button className="forward-button" onClick={e => { panelNumber === 2 ? handleButtonClick('submit', e) : handleButtonClick('forward', e) }}>{panelNumber === 2 ? "Submit" : "Next"}</button>
            </div>
        </div>
    )
}