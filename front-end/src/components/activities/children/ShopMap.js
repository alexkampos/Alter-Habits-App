import React, { useState, useEffect } from 'react';
import {
    GoogleMap,
    useLoadScript,
    Marker,
    InfoWindow
} from '@react-google-maps/api';
import '@reach/combobox/styles.css';
import mapStyles from '../../../map-styles/mapStyles.js';
import Geocode from "react-geocode";

const libraries = ['places'];

export default function ShopMap(props) {

    
    const [markers, setMarkers] = useState([]);
    const [scrollTop, setScrollTop] = useState('');
    const [shopAddress, setShopAddress] = useState('');
    const [enrollDisable, setEnrollDisable] = useState(false);
    const [displayedEnrollButtonText, setDisplayedEnrollButtonText] = useState('');

    const center = {
        lat: 37.983810,
        lng: 23.727539
    };

    const options = {
        styles: mapStyles,
        disableDefaultUI: true,
        zoomControl: true
    }

    const { isLoaded, loadError } = useLoadScript({
        googleMapsApiKey: "AIzaSyB5XTbFRTisGusNhEF_n34_UCqG1F5P8yA",
        libraries
    });

    Geocode.setApiKey("AIzaSyB5XTbFRTisGusNhEF_n34_UCqG1F5P8yA");

    useEffect(() => {
        if (props.selectedShop) {
            Geocode.fromLatLng(props.selectedShop.latitude, props.selectedShop.longitude).then(
                response => {
                    setShopAddress(response.results[0].formatted_address)
                });
        }
    }, [props.selectedShop])

    useEffect(() => {
        if (props.numberOfActivityReservationLeft < 1) {
            setEnrollDisable(true);
            setDisplayedEnrollButtonText("0 left");
        } else {
            setEnrollDisable(false);
            setDisplayedEnrollButtonText("Enroll");
        }
    }, [props.numberOfActivityReservationLeft])

    useEffect(() => {
        const intActivityId = parseInt(props.activityId);
        if(window.google){
        const filteredMarkers = props.shops.filter(shop => {
            if (intActivityId === 0) {
                return true;
            }
            for (let i = 0; i < shop.activities.length; i++) {
                if (shop.activities[i].activityId === intActivityId) {
                    return true;
                }
            }
        }).map(shop => <Marker
            key={shop.shopId}
            position={{
                lat: parseFloat(shop.latitude),
                lng: parseFloat(shop.longitude)
            }}
            icon={{
                url: "https://image.flaticon.com/icons/svg/2387/2387970.svg",
                scaledSize: new window.google.maps.Size(30, 30),
                origin: new window.google.maps.Point(0, 0),
                anchor: new window.google.maps.Point(15, 15)
            }}
            onClick={() => {
                props.setSelectedShop(shop);
                setScrollTop(window.pageYOffset)
            }}

        />)
        setMarkers(filteredMarkers)
        }
    }, [props.activityId, props.shops, window.google])

    const mapRef = React.useRef();
    const onMapLoad = React.useCallback((map) => {
        mapRef.current = map;
    }, []);

    if (loadError) return "Error loading maps"
    if (!isLoaded) return "Loading Maps";

    return (
        <div className="map-show-all-container">
            <button className={parseInt(props.activityId) === 0 ? "show-all activity-selected" : "show-all"} onClick={() => props.setActivityId(0)}>All activities</button>
            <GoogleMap
                mapContainerClassName="google-map-style"
                zoom={10}
                center={center}
                options={options}
                onLoad={onMapLoad}
            >
                {markers}
                {
                    props.selectedShop ? (
                        <InfoWindow
                            position={{ lat: parseFloat(props.selectedShop.latitude), lng: parseFloat(props.selectedShop.longitude) }}
                            onCloseClick={() => {
                                props.setSelectedShop(null);
                                window.scrollTo(0, scrollTop);
                            }}>
                            <div className="shop-info-window">
                                <img src={"http://localhost:8080/AlterHabits/img/" + props.selectedShop.shopId + ".jpg"} />
                                <div>
                                    <span className="shop-name">{props.selectedShop.shopName}</span>
                                    <span className="shop-address">{shopAddress}</span>
                                    {
                                        props.selectedShop.potentialPartner === "POTENTIAL PARTNER" ?
                                        <span style={{marginTop: "10px", color: "red"}}>Potential future partner.</span> :
                                        <button onClick={() => props.setDisplayedModal("bookActivity")} disabled={enrollDisable} className={props.displayedEnrollButtonStyle}>{displayedEnrollButtonText}</button>
                                    }
                                </div>
                            </div>
                        </InfoWindow>
                    ) : null
                }
            </GoogleMap>
        </div>
    )
}