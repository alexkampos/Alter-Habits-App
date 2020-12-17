import React, { useEffect, useState, forwardRef } from 'react';
import { Dropdown, DropdownButton } from 'react-bootstrap';
import DatePicker from 'react-datepicker';
import AuthService from '../../../services/auth-service';
import Axios from 'axios';
import "react-datepicker/dist/react-datepicker.css";

const RESERVE_ACTIVITY_API_URL = "http://localhost:8080/AlterHabits/book";

export default function BookActivity(props) {

    function onClickBooking(e) {
        e.stopPropagation();
    }

    const [activitiesToPick, setActivitiesToPick] = useState([]);
    const [dropdownTitle, setDropdownTitle] = useState("Pick Activity");
    const [reservationDate, setReservationDate] = useState(new Date());
    const [selectedActivityIdForReservation, setSelectedActivityIdForReservation] = useState(0);

    function handleSelect(e) {
        setDropdownTitle(e.split(',')[1].toUpperCase());
        setSelectedActivityIdForReservation(e.substr(0,e.indexOf(',')));
    }

      const MyCustomInput = forwardRef((props, ref) => {
        return (
            <button className="btn btn-primary date-picker" onClick={props.onClick}>
                {props.value}
            </button>
        )
        });

    useEffect(() => {
        if (props.selectedShop) {
            const activities = props.selectedShop.activities.map(activity => {
                return <Dropdown.Item eventKey={[activity.activityId, activity.activityName]}>{activity.activityName.toUpperCase()}</Dropdown.Item>
            })
            setActivitiesToPick(activities);
        }
    }, [props.selectedShop]);

    useEffect(() => {
        if (props.displayedModal === 'bookActivity') {
            setDropdownTitle("Pick Activity")
        }
    }, [props.displayedModal]);
    function handleReservationSubmit(){
        Axios.get(RESERVE_ACTIVITY_API_URL+"?date="+reservationDate+"&shopId="+props.selectedShop.shopId.toString()+"&activityId="+selectedActivityIdForReservation.toString(),
           {
            headers: { 'Authorization': `Bearer ${AuthService.getCurrentUser().accessToken}` }
          })
        .then(response => {
                props.setUserDidEnrollOnActivity(true);
                props.setDisplayedModal('');
        })

    }

    return (
        <div className={props.customBookActivityStyle} onClick={onClickBooking}>
            <DropdownButton className="dropdown-activities" onSelect={handleSelect} title={dropdownTitle}>
                {activitiesToPick}
            </DropdownButton>
            <DatePicker
                selected={reservationDate}
                onChange={reservationDate => setReservationDate(reservationDate)}
                customInput={<MyCustomInput/>}
                timeInputLabel="Time:"
                dateFormat="dd/MM/yyyy h:mm aa"
                showTimeInput
            />
            <button className="enroll-button" onClick={handleReservationSubmit}>Enroll</button>
        </div>
    )
}