import React, { useEffect } from 'react';
import Login from './authentication-components/Login';
import "./authentication.css";
import BookActivity from './authentication-components/BookActivity';
import Quiz from './authentication-components/Quiz';
import Register from './authentication-components/Register.jsx';
import PartnerForm from './authentication-components/PartnerForm';

export default function SecurityContainer(props) {

    const customSecurityContainerStyle = props.displayedModal ? "security-container" : "not-display";
    const customLoginStyle = props.displayedModal === 'login' ? "login-container" : "not-display";
    const customBookActivityStyle = props.displayedModal === 'bookActivity' ? "book-activity-container" : "not-display";
    const customQuizStyle = props.displayedModal === 'quiz' ? 'quiz-component-container' : 'not-display';
    const customRegisterStyle = props.displayedModal === 'register' ? 'register-component-container' : 'not-display';
    const customPartnerFormStyle = props.displayedModal === 'partner' ? 'partner-form-container' : 'not-display';

    useEffect(() => {
    }, [props.displayedModal])

    return (
        <div className={customSecurityContainerStyle} onClick={() => { props.setDisplayedModal('') }}>
            <Register
                customRegisterStyle={customRegisterStyle}
                setDisplayedModal={props.setDisplayedModal} />
            <Login customLoginStyle={customLoginStyle} />
            <BookActivity
                customBookActivityStyle={customBookActivityStyle}
                selectedShop={props.selectedShop}
                setSelectedShop={props.setSelectedShop}
                setDisplayedModal={props.setDisplayedModal}
                currentUser={props.currentUser}
                setUserDidEnrollOnActivity={props.setUserDidEnrollOnActivity} />
            <Quiz
                customQuizStyle={customQuizStyle} />
            <PartnerForm
                customPartnerFormStyle={customPartnerFormStyle}
                setDisplayedModal={props.setDisplayedModal} 
                setShopsUpdated={props.setShopsUpdated}/>
        </div>
    )
}