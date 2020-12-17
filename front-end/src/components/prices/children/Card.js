import React from 'react';


export default function Card(props) {
   const color = "card text-center " + props.color
   return (
      <div className="price-card">

         <div data-aos="flip-right">
            <div className={color}>
               <div className="title">
                  <i className={props.image} aria-hidden="true"></i>
                  <h2>{props.size}</h2>
               </div>
               <div className="price">
                  <h4><sup>$</sup>{props.price}</h4>
               </div>
               <div className="option">
                  <ul>
                     <li><i className="fa fa-check" aria-hidden="true"></i> {props.activitiesNumber} activities per month. </li>
                     <li><i className="fa fa-check" aria-hidden="true"></i> Whichever activity you want.</li>
                     <li><i className="fa fa-check" aria-hidden="true"></i> No equipment needed.</li>
                  </ul>
               </div>
               <a onClick={() => props.setDisplayedModal('register')}>Purchase</a>
            </div>
         </div>
      </div>
   )
}