import React, { useEffect, useState } from 'react';
import Appointment from './Appointment';
import Moment from 'react-moment';

export default function DayColumn(props) {
    const [appointments, setAppointments] = useState([]);

    useEffect(() => {
        if (props.reservationsList) {
            if (props.reservationsList.length !== 0) {
                setAppointments(props.reservationsList.map(reservation => {
                    return <Appointment reservationInfo={reservation} />
                })
                )
            }
        }
    }, [props.reservationsList]);


    return (
        <div className="day-column-container" style={props.hideBorder && { borderRight: "none" }}>
            <div className="day-of-the-week">
                <Moment format="ddd, D MMM">
                    {props.date}
                </Moment>
            </div>
            {appointments}
            {/* <Appointment/> */}
        </div>
    )
}