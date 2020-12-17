import React from 'react';
import "./details.css";
import Step from './children/Step.js';

export default function Details(){
    return (
        <div className="details-container" id="mapDetails">
            <span className="details-container-span" data-aos="zoom-in-up">HOW IT WORKS</span>
            <div className="step-details-container" data-aos="zoom-in">
                <Step color ="card_step1" number="1" text="Register into our application."/>
                <Step color ="card_step2" number="2" text="Choose a plan."/>
                <Step color ="card_step3" number="3" text="Enroll on activities."/>
            </div>
        </div>
    )
}