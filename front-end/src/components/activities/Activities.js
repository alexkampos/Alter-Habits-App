import React, { useState, useEffect } from 'react'
import "./activities.css"
import ShopMap from './children/ShopMap.js'
import MapSearch from './children/MapSearch'
import axios from 'axios'

const SHOPS_API_URL = "http://localhost:8080/AlterHabits/shops";

function Activities(props) {
    const [shops, setShops] = useState([])
    const [activityId, setActivityId] = useState(0)
    useEffect(() => {
        axios.get(SHOPS_API_URL)
        .then(response => {
            setShops(response.data);
            
        });
    }, [props.shopsUpdated])

    useEffect(() => {
        props.setShopsUpdated(false);
    }, [props.shops])

    return (
        <div className="activities-container" id="mapActivities">
            <div className="activities-container-span">ACTIVITIES</div>
            <div className="bottom-section">
                <MapSearch
                    setActivityId={setActivityId}
                    activityId = {activityId} />
                <ShopMap
                    shops={shops}
                    activityId={activityId}
                    setActivityId={setActivityId} 
                    setDisplayedModal={props.setDisplayedModal}
                    selectedShop={props.selectedShop}
                    setSelectedShop={props.setSelectedShop}
                    displayedEnrollButtonStyle={props.displayedEnrollButtonStyle}
                    numberOfActivityReservationLeft={props.numberOfActivityReservationLeft}/>
            </div>
        </div>
    )
}

export default Activities