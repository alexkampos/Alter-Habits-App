import React, { useEffect, useState } from 'react';
import activities from '../../../activities-data/activities v1.2.json';

function importAll(r) {
    let images = {};
    r.keys().map((item, index) => { images[item.replace('./', '')] = r(item); });
    return images;
}

const images = importAll(require.context('../../../images/activities', false, /\.(png|jpe?g|svg)$/));

function MapSearch(props) {

    const [activitiesInfo, setActivitiesInfo] = useState([]);
    const activityIdInt = parseInt(props.activityId);

    function handleClick(e){
        props.setActivityId(e.target.getAttribute('activityid'));
    }

    useEffect(() => {
        setActivitiesInfo(activities.map(activity => {
        return <div key={activity.id} activityid={activity.id} className={activity.id === activityIdInt ? "activity-info activity-selected" : "activity-info"} onClick={handleClick}>
            <img activityid={activity.id} src={images['' + activity.id + '.jpg']}></img>
            <div activityid={activity.id} className="text-description-container">
                <div activityid={activity.id} className="text">{activity.name.toUpperCase()}</div>
                <div activityid={activity.id} className="description">{activity.description}</div>
            </div>
        </div>
    }))
}, [props.activityId])
    return (
        <div className="map-search-container">
            {activitiesInfo}
        </div>
    )
} 

export default MapSearch