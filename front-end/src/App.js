import React, { useState, useEffect } from 'react';
import Header from './components/header/Header';
import MyCarousel from './components/header/MyCarousel'
import Prices from './components/prices/Prices';
import Activities from './components/activities/Activities';
import Footer from './components/footer/Footer';
import Details from './components/details/Details';
import 'react-responsive-carousel/lib/styles/carousel.min.css';
import AOS from 'aos';
import SecurityContainer from './components/authentication/SecurityContainer';
import Scheduler from './components/scheduler/Scheduler.jsx';

import AuthService from './services/auth-service';
import Axios from 'axios';

const GET_REMAINING_ACTIVITY_RESERVATIONS_API_URL = "http://localhost:8080/AlterHabits/showRemainingAppointments";

export default function App() {

  const [currentUser, setCurrentUser] = useState(undefined);
  const [selectedShop, setSelectedShop] = useState(null);
  const [displayedEnrollButtonStyle, setDisplayedEnrollButtonStyle] = useState("enroll-to-shop-button not-display");
  const [numberOfActivityReservationLeft, setNumberOfActivityReservationLeft] = useState(0);
  const [userDidEnrollOnActivity, setUserDidEnrollOnActivity] = useState(false);
  const [signedIn, setSignedIn] = useState(false);
  const [displayedModal, setDisplayedModal] = useState('');
  const [shopsUpdated, setShopsUpdated] = useState(true);


  AOS.init({
    duration: 1200

  });

  useEffect(() => {
    const user = AuthService.getCurrentUser();

    if (user) {
      setCurrentUser(user);
      setSignedIn(true);
    }
  }, [])

  useEffect(() => {
    if (AuthService.getCurrentUser()) {
      Axios.get(
        GET_REMAINING_ACTIVITY_RESERVATIONS_API_URL,
        {
          headers: { 'Authorization': `Bearer ${AuthService.getCurrentUser().accessToken}` }
        }
      )
        .then(response => setNumberOfActivityReservationLeft(response.data));
    }
  }, [userDidEnrollOnActivity])

  useEffect(() => {
    setUserDidEnrollOnActivity(false);
  }, [numberOfActivityReservationLeft])

  useEffect(() => {
    if (currentUser) {
      setDisplayedEnrollButtonStyle('enroll-to-shop-button');
    }
  }, [currentUser])

  function logOut() {
    AuthService.logout();
    window.location.reload();
  }

  return (
    <div className="app-container">

      <SecurityContainer
        selectedShop={selectedShop}
        setSelectedShop={setSelectedShop}
        displayedModal={displayedModal}
        setDisplayedModal={setDisplayedModal}
        currentUser={currentUser}
        setUserDidEnrollOnActivity={setUserDidEnrollOnActivity}
        shopsUpdated={shopsUpdated}
        setShopsUpdated={setShopsUpdated} />
      <Header
        setDisplayedModal={setDisplayedModal}
        currentUser={currentUser}
        logOut={logOut}
        numberOfActivityReservationLeft={numberOfActivityReservationLeft} />
      <MyCarousel />
      <Details />
      <Activities
        setDisplayedModal={setDisplayedModal}
        selectedShop={selectedShop}
        setSelectedShop={setSelectedShop}
        displayedEnrollButtonStyle={displayedEnrollButtonStyle}
        numberOfActivityReservationLeft={numberOfActivityReservationLeft}
        shopsUpdated={shopsUpdated}
        setShopsUpdated={setShopsUpdated} />
      {
        signedIn ?
          <Scheduler
            userDidEnrollOnActivity={userDidEnrollOnActivity} /> :
          <Prices 
          setDisplayedModal={setDisplayedModal}/>
      }
      <Footer />

    </div>
  );
}