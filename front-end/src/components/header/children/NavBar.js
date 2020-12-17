import React, { useState, useEffect } from 'react';

function useWindowSize() {

    const [windowSize, setWindowSize] = useState({
        width: undefined,
        height: undefined,
    });

    useEffect(() => {
        function handleResize() {
            setWindowSize({
                width: window.innerWidth,
                height: window.innerHeight,
            });
        }
        window.addEventListener("resize", handleResize);

        handleResize();

        return () => window.removeEventListener("resize", handleResize);

    }, []);

    return windowSize;
}


function NavBar(props) {
    const size = useWindowSize();

    const [activityNumberHovered, setActivityNumberHovered] = useState(false);

    const [quizButtonHovered, setQuizButtonHovered] = useState(false);

    const [toggleStyle, setToggleStyle] = useState("collapse navbar-collapse");

    const [isDisplayed, setIsDisplayed] = useState(false);

    useEffect(() => {
        isDisplayed ? setToggleStyle("collapse navbar-collapse minified") : setToggleStyle("collapse navbar-collapse")
    }, [isDisplayed]);

    useEffect(() => {
        size.width > 991 && setIsDisplayed(false)
    }, [size]);

    function handleClick(id, e){
        if(id === "mapCarousel" ){
            document.getElementById(id).scrollIntoView({behavior: "smooth"}); 
        }else if( id === "mapDetails" ){
            document.getElementById(id).scrollIntoView({ behavior: 'smooth'});
        }else if( id === "mapScheduler" ){
            document.getElementById(id).scrollIntoView({ behavior: 'smooth'});
        }else if( id === "mapPrices" ) {
            document.getElementById(id).scrollIntoView({ behavior: 'smooth'});
        }else if( id === "mapActivities" ){
            document.getElementById(id).scrollIntoView({ behavior: 'smooth' });
        }
    }

    return (
        <nav className="navbar navbar-expand-lg navbar-light move-navbar">
            <a className="navbar-brand float-left text-light go-to-buttons" onClick={e => handleClick('mapCarousel', e)}>
                <span className="navbar-text text-light logo logo-size">ALTER HABITS</span>
            </a>
            <button className="navbar-toggler" data-toggle="collapse" type="button" data-toggle="collapse" data-target="#collapse_target" onClick={() => setIsDisplayed(!isDisplayed)}>
                <span className="navbar-toggler-icon"></span>
            </button>
            <div className={toggleStyle} id="collapse_target">
                <ul className="navbar-nav mr-auto">
                    <li className="nav-item">
                        <a className="nav-link text-light navfont go-to-buttons" onClick={e => handleClick('mapDetails', e)}>How it works</a>
                    </li>
                    <li className="nav-item">
                        <a className="nav-link text-light navfont go-to-buttons" onClick={e => handleClick('mapActivities', e)}>Activities</a>
                    </li>
                    <li className="nav-item">
                        {
                            props.currentUser ?
                                <a className="nav-link text-light navfont go-to-buttons" onClick={e => handleClick('mapScheduler', e)} >Scheduler</a> :
                                <a className="nav-link text-light navfont go-to-buttons" onClick={e => handleClick('mapPrices', e)} >Prices</a>
                        }
                    </li>
                    <li className="nav-item">
                        <a className="nav-link text-light navfont go-to-buttons" onClick={() => props.setDisplayedModal('partner')}>Become a Partner</a>
                    </li>
                </ul>

                <div className="d-flex flex-row-reverse bd-highlight log-out-activities-left-container">
                    {
                        props.currentUser ?
                            <>
                                <button type="button" className="btn btn-outline-success my-2 my-sm-0 ml-3" onClick={props.logOut}>Log Out</button>
                                <button type="button" className="btn btn-outline-success my-2 my-sm-0 ml-3"
                                    onMouseEnter={() => setQuizButtonHovered(true)}
                                    onMouseLeave={() => setQuizButtonHovered(false)}
                                    onClick={() => props.setDisplayedModal('quiz')}>Quiz</button>
                                <div className={quizButtonHovered ? 'quiz-info' : 'quiz-info not-display'}>Take a mini quiz and we will suggest some activities you might like.</div>
                                <span className="activities-left" onMouseEnter={() => setActivityNumberHovered(true)} onMouseLeave={() => setActivityNumberHovered(false)}>{props.numberOfActivityReservationLeft}</span>
                                <div className={activityNumberHovered ? 'activity-left-info' : 'activity-left-info not-display'}>Number of activities left for this month.</div>
                            </>
                            :
                            <>
                                <button type="button" className="btn btn-outline-success my-2 my-sm-0 ml-3" onClick={() => props.setDisplayedModal( 'register' )}>Sign Up</button>
                                <button type="button" className="btn btn-outline-success my-2 my-sm-0" onClick={() => props.setDisplayedModal('login')}>Log in</button>
                            </>
                    }
                </div>

            </div>
        </nav>
    )
}

export default NavBar