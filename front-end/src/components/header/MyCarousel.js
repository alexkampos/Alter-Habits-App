import React from 'react';
import { Carousel } from 'react-responsive-carousel';
import './header.css';

export default function MyCarousel(){
    return (
        <div className="my-carousel-container" id="mapCarousel">
        <Carousel infiniteLoop useKeyboardArrows autoPlay showThumbs={false}> 
            <div>
                <img alt="" src="https://digitaldefynd.com/wp-content/uploads/2019/05/Best-Yoga-classes-course-tutorial-certification-training-online.jpg" />
                <p className="legend">Yoga</p>
            </div>
            <div>
                <img alt="" src="https://images.unsplash.com/photo-1571902943202-507ec2618e8f?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80" />
                <p className="legend">Gym</p>
            </div>
            <div>
                <img alt="" src="https://cdn.pixabay.com/photo/2016/11/14/05/26/children-1822701_1280.jpg" />
                <p className="legend">Martial Arts</p>
            </div>
            <div>
                <img alt="" src="https://cdn.pixabay.com/photo/2016/11/22/21/43/agility-1850711_1280.jpg" />
                <p className="legend">Dance</p>
            </div>
        </Carousel>
        </div>
    )
}