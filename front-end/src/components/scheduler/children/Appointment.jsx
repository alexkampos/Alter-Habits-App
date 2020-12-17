import React, { useState } from 'react';
import Geocode from "react-geocode";

export default function Appointment(props){

    const colors = ["chocolate", "darkcyan", "darkmagenta", "deeppink", "midnightblue"];
    const randomColor = colors[Math.floor(Math.random() * 5)];
    
    const [shopAddress, setShopAddress] = useState('');

    Geocode.setApiKey("AIzaSyB5XTbFRTisGusNhEF_n34_UCqG1F5P8yA");

            Geocode.fromLatLng(props.reservationInfo.latitude, props.reservationInfo.longitude).then(
                response => {
                    setShopAddress(response.results[0].formatted_address);
                });

    return (
        <div className="reservation-container" style={{backgroundColor: randomColor}}>
            <span className="shops-name">{props.reservationInfo.shopName}</span>
            <span className="activity-picked">{props.reservationInfo.activityName}</span>
            <span className="appointment-time">{props.reservationInfo.reservationDate.toLocaleTimeString([], {hour: '2-digit', minute:'2-digit'})}</span>
            <span className="shops-address">{shopAddress}</span>
        </div>
    )
}