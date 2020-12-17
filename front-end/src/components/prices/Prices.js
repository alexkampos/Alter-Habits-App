import React from 'react';
import './prices.css';
import Card from './children/Card.js';

export default function Prices(props) {
    return (
        <div className="title-prices-container" id="mapPrices">
            <span>PLANS</span>
            <div className="prices-container">
                <Card
                    size="Medium"
                    color="card_red"
                    price="29.99"
                    activitiesNumber="4"
                    image="fa fa-paper-plane"
                    setDisplayedModal={props.setDisplayedModal} />
                <Card
                    size="Large"
                    color="card_three"
                    price="46.99"
                    activitiesNumber="8"
                    image="fa fa-plane"
                    setDisplayedModal={props.setDisplayedModal} />
                <Card
                    size="XLarge"
                    color="card_four"
                    price="55.99"
                    activitiesNumber="12"
                    image="fa fa-rocket"
                    setDisplayedModal={props.setDisplayedModal} />
            </div>
        </div>
    )
}