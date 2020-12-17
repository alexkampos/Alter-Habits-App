import React from 'react';
import "./header.css";
import NavBar from './children/NavBar.js';

export default function Header(props){
    return (
        <header id="header" className="fixed-top header-transparent">
            <div className="container-fluid">
                <NavBar 
                setDisplayedModal={props.setDisplayedModal}
                currentUser={props.currentUser}
                logOut={props.logOut}
                numberOfActivityReservationLeft={props.numberOfActivityReservationLeft}/>
            </div>
        </header>
    )
}