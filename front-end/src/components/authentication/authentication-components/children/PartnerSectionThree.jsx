import React, { useCallback, useRef, useState } from 'react';
import {
    GoogleMap,
    useLoadScript,
    Marker,
    InfoWindow
} from '@react-google-maps/api';
import '@reach/combobox/styles.css';
import mapStyles from '../../../../map-styles/mapStyles.js';
import Geocode from "react-geocode";
import usePlacesAutoComplete, {
    getGeocode,
    getLatLng
} from 'use-places-autocomplete';
import {
    Combobox,
    ComboboxInput,
    ComboboxPopover,
    ComboboxList,
    ComboboxOption
} from '@reach/combobox';
import '@reach/combobox/styles.css';

const libraries = ["places"];

const center = {
    lat: 37.983810,
    lng: 23.727539
};

const options = {
    styles: mapStyles,
    disableDefaultUI: true,
    zoomControl: true
};

export default function PartnerSectionThree(props){

    const [marker, setMarker] = useState(null);
    const [selected, setSelected] = useState(null);

    const onMapClick = useCallback((event) => {
        Geocode.fromLatLng(event.latLng.lat(), event.latLng.lng()).then(
            response => {
                setMarker({
                    address: response.results[0].formatted_address,
                    lat: event.latLng.lat(),
                    lng: event.latLng.lng()
                });
                props.setLatitude(`${event.latLng.lat()}`);
                props.setLongitude(`${event.latLng.lng()}`);
            });
        
    });

    const mapRef = useRef;
    const onMapLoad = useCallback((map) => {
        mapRef.current = map;
    }, []);

    const panTo = useCallback(({lat, lng}) => {
        mapRef.current.panTo({lat, lng});
        mapRef.current.setZoom(14);
    }, [])

    const {isLoaded, loadError} = useLoadScript({
        googleMapsApiKey: process.env.REACT_APP_GOOGLE_MAPS_API_KEY,
        libraries,
    });

    if(loadError) return "Error loading maps";
    if(!isLoaded) return "Loading maps";

    Geocode.setApiKey(process.env.REACT_APP_GOOGLE_MAPS_API_KEY);

    return (
        <div className="point-address-container">
            <div className="instruction-text">Pin location</div>

            <Search panTo={panTo}/>

            <GoogleMap
                mapContainerClassName="map-container"
                zoom={10}
                center={center}
                options={options}
                onClick={onMapClick}
                onLoad={onMapLoad}>
                    {console.log(marker)}
                    { 
                    marker && <Marker 
                    position={{ lat: marker.lat, lng: marker.lng }}
                    onClick={() => {
                        setSelected(marker)
                    }} 
                    /> }
                    {
                        selected && <InfoWindow position={{lat: selected.lat, lng: selected.lng}} 
                        onCloseClick={() => {
                            setSelected(null);
                        }}>
                              <span> {marker.address} </span> 
                            </InfoWindow>
                    }
            </GoogleMap>
        </div>
    )
}

function Search({ panTo }) {
    const {ready, value, suggestions: {status, data}, setValue, clearSuggestions } = usePlacesAutoComplete( {
        requestOptions: {
            location: {lat: () => 37.983810, lng: () => 23.727539},
            radius: 200 * 1000,
        }
    } );

    return (
    <div className="address-search">
    <Combobox onSelect={async (address) => {
        setValue(address, false);
        clearSuggestions();
        try {
            const results = await getGeocode({address});
            const { lat, lng } = await getLatLng(results[0]);
            panTo({ lat, lng });
        } catch (error) {
            console.log(error)
        }
        }}>
        <ComboboxInput value={value} onChange={(e) => {
            setValue(e.target.value)
        }}
        disable={!ready}
        placeholder="Search address..." />
        <ComboboxPopover className='search-pop'>
            <ComboboxList>
            {status === "OK" && data.map(({id,description}) => (
                <ComboboxOption key={id} value={description} />
            ))}
            </ComboboxList>
        </ComboboxPopover>
    </Combobox>
    </div>
    )
}