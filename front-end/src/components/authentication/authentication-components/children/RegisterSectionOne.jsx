import React from 'react';

export default function RegisterSectionOne(props) {

    function handleChange(e, inputName) {
        if (inputName === 'username') {
            const value = e.target.value;
            props.setterValues.setUsername(value);
        } else if (inputName === 'password') {
            const value = e.target.value;
            props.setterValues.setPassword(value);
        } else if (inputName === 'retyped password') {
            const value = e.target.value;
            props.setterValues.setRetypedPassword(value);
        }
    }

    function handleBlur(e, inputName) {
        if (inputName === 'username') {
            props.errorValues.usernameErrorMessage !== 'validated' && props.setterErrorValues.setUsernameErrorMessage('');
        } else if (inputName === 'password') {
            props.errorValues.passwordErrorMessage !== 'validated' && props.setterErrorValues.setPasswordErrorMessage('');
        } else if (inputName === 'retyped password') {
            props.errorValues.retypedPasswordErrorMessage !== 'validated' && props.setterErrorValues.setRetypedPasswordErrorMessage('');
        }
    }

    return (
        <div className={props.panelNumber !== 0 ? "not-display" : "register-section-one"}>
            <div className="input-error-container">
                <input 
                className="text-inputs" 
                type="text"
                 placeholder="Username... *" 
                 onChange={e => handleChange(e, 'username')} 
                 value={props.values.username} 
                 onBlur={e => handleBlur(e, 'username')} />
                {
                    !props.errorValues.usernameErrorMessage || props.errorValues.usernameErrorMessage !== 'validated' &&
                    <span className="error-message">{props.errorValues.usernameErrorMessage}</span>
                }
            </div>
            <div className="input-error-container">
                <input 
                className="text-inputs" 
                type="password" 
                placeholder="Password... *"  
                onChange={e => handleChange(e, 'password')} 
                value={props.values.password} 
                onBlur={e => handleBlur(e, 'password')}/>
                {
                    !props.errorValues.passwordErrorMessage || props.errorValues.passwordErrorMessage !== 'validated' &&
                    <span className="error-message">{props.errorValues.passwordErrorMessage}</span>
                }
            </div>
            <div className="input-error-container">
                <input 
                className="text-inputs" 
                type="password" 
                placeholder="Confirm password... *" 
                onChange={e => handleChange(e, 'retyped password')} 
                value={props.values.retypedPassword} 
                onBlur={e => handleBlur(e, 'retyped password')} />
                {
                    !props.errorValues.retypedPasswordErrorMessage || props.errorValues.retypedPasswordErrorMessage !== 'validated' &&
                    <span className="error-message">{props.errorValues.retypedPasswordErrorMessage}</span>
                }
            </div>
        </div>
    )
}