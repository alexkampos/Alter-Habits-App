import React, { useEffect, useState } from 'react';
import "./scheduler.css";
import DayColumn from './children/DayColumn';
import Axios from 'axios';
import filterReservationsDates from '../../utils/filter-reservations-dates';
import AuthService from '../../services/auth-service';

const WEEK_RESERVATIONS_API_URL = "http://localhost:8080/AlterHabits/showListOfTheWeekReservationsOfTheUser"

export default function Scheduler(props) {

    const day1 = new Date();
    const day2 = new Date();
    const day3 = new Date();
    const day4 = new Date();
    const day5 = new Date();
    const day6 = new Date();
    const day7 = new Date();

    const [allReservations, setAllReservations] = useState([]);
    const [filteredReservations, setFilteredReservations] = useState([]);

    useEffect(() => {
        Axios.get(WEEK_RESERVATIONS_API_URL,
            {
                headers: { 'Authorization': `Bearer ${AuthService.getCurrentUser().accessToken}` }
            })
            .then(response => {
                setAllReservations(response.data.map(reservation => {
                   return {
                    activityName: reservation.activityName,   
                    reservationDate: new Date(reservation.reservationDate),
                    latitude: reservation.latitude,
                    longitude: reservation.longitude,
                    shopName: reservation.shopName
                   }
                }));
            })
    }, [props.userDidEnrollOnActivity]);


    useEffect(() => {
        if(allReservations.length !== 0){
        setFilteredReservations(filterReservationsDates(allReservations));
        
        }
        
    }, [allReservations]);

    return (
        <div className="scheduler-component-container" id="mapScheduler">
            <span className="section-title">SCHEDULER</span>
            <div className="scheduler-container">
                <div className="transparency-div"></div>
                <DayColumn
                    date={day1}
                    userDidEnrollOnActivity={props.userDidEnrollOnActivity}
                    reservationsList={filteredReservations[0]} />
                <DayColumn
                    date={day2.setDate(new Date().getDate() + 1)}
                    userDidEnrollOnActivity={props.userDidEnrollOnActivity}
                    reservationsList={filteredReservations[1]} />
                <DayColumn
                    date={day3.setDate(new Date().getDate() + 2)}
                    userDidEnrollOnActivity={props.userDidEnrollOnActivity}
                    reservationsList={filteredReservations[2]} />
                <DayColumn
                    date={day4.setDate(new Date().getDate() + 3)}
                    userDidEnrollOnActivity={props.userDidEnrollOnActivity}
                    reservationsList={filteredReservations[3]} />
                <DayColumn
                    date={day5.setDate(new Date().getDate() + 4)}
                    userDidEnrollOnActivity={props.userDidEnrollOnActivity}
                    reservationsList={filteredReservations[4]} />
                <DayColumn
                    date={day6.setDate(new Date().getDate() + 5)}
                    userDidEnrollOnActivity={props.userDidEnrollOnActivity}
                    reservationsList={filteredReservations[5]} />
                <DayColumn
                    hideBorder={true}
                    date={day7.setDate(new Date().getDate() + 6)}
                    userDidEnrollOnActivity={props.userDidEnrollOnActivity}
                    reservationsList={filteredReservations[6]} />
            </div>
        </div>
    )
}