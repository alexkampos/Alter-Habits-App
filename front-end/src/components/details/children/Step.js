import React from 'react';
import classnames from 'classnames';

export default function Step(props) {
    return (
        <div className={classnames('step-container', props.color)}>
            <span className="step-number">Step {props.number}</span>
            <span className="step-text">{props.text}</span>
        </div>
    )
}

