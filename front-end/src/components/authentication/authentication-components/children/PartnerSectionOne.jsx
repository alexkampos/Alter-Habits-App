import React from 'react';
import MultiSelect from "react-multi-select-component";
import activitiesInfo from '../../../../activities-data/activities v1.2.json';

export default function PartnerSectionOne(props) {

    function handleNameChange(e) {
        props.setShopName(e.target.value)
    }

    function handleEmailChange(e) {
        props.setShopEmail(e.target.value)
    }

    const options = activitiesInfo.map(activity => (
        {
            label: activity.name.toUpperCase(),
            value: activity.name
        }
    ))

    return (
        <div>
            <div>
            <input type="text" placeholder="Shop's name..." className="text-inputs" onChange={handleNameChange} value={props.shopName} />
            </div>
            <div>
            <input type="email" placeholder="Email..." className="text-inputs" onChange={handleEmailChange} value={props.shopEmail} />
            </div>
            <MultiSelect
                options={options}
                value={props.selectedActivities}
                onChange={props.setSelectedActivities}
                labelledBy={"Select activities..."} />
        </div>
    )
}