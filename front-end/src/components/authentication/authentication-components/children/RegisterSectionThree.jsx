import React from 'react';

export default function RegisterSectionThree(props) {

    function handleChange(e, inputName) {
        if (inputName === 'email') {
            const value = e.target.value;
            props.setterValues.setEmail(value);
        } else if (inputName === 'phone number') {
            const value = e.target.value;
            props.setterValues.setPhoneNumber(value);
        } else if (inputName === 'mobile number') {
            const value = e.target.value;
            props.setterValues.setMobileNumber(value);
        }
    }

    function handleClick(e, value) {
        props.setterValues.setRole(value);
    }

    function handleBlur(e, inputName) {
        if (inputName === 'email') {
            props.errorValues.emailErrorMessage !== 'validated' && props.setterErrorValues.setEmailErrorMessage('');
        } else if (inputName === 'phone number') {
            props.errorValues.phoneNumberErrorMessage !== 'validated' && props.setterErrorValues.setPhoneNumberErrorMessage('');
        } else if (inputName === 'mobile number') {
            props.errorValues.mobileNumberErrorMessage !== 'validated' && props.setterErrorValues.setMobileNumberErrorMessage('');
        } else if (inputName === 'role') {
            props.errorValues.roleErrorMessage !== 'validated' && props.setterErrorValues.setRoleErrorMessage('');
        }
    }

    return (

        <div className={props.panelNumber !== 2 ? "not-display" : "register-section-three"}>
            <div className="input-error-container">
                <input
                    className="text-inputs"
                    type="text"
                    placeholder="Email... *"
                    autoComplete="new-password"
                    value={props.values.email}
                    onChange={e => handleChange(e, 'email')}
                    onBlur={e => handleBlur(e, 'email')}
                />
                {
                    !props.errorValues.emailErrorMessage || props.errorValues.emailErrorMessage !== 'validated' &&
                    <span className="error-message">{props.errorValues.emailErrorMessage}</span>
                }
            </div>
            <div className="input-error-container">
                <input
                    className="text-inputs"
                    type="text"
                    placeholder="Phone number..."
                    autoComplete="new-password"
                    value={props.values.phoneNumber}
                    onChange={e => handleChange(e, 'phone number')}
                    onBlur={e => handleBlur(e, 'phone number')}
                    />
                {
                    !props.errorValues.phoneNumberErrorMessage || props.errorValues.phoneNumberErrorMessage !== 'validated' &&
                    <span className="error-message">{props.errorValues.phoneNumberErrorMessage}</span>
                }
            </div>
            <div className="input-error-container">
                <input
                    className="text-inputs"
                    type="text"
                    placeholder="Mobile number... *"
                    autoComplete="new-password"
                    value={props.values.mobileNumber}
                    onChange={e => handleChange(e, 'mobile number')}
                    onBlur={e => handleBlur(e, 'mobile number')} />
                {
                    !props.errorValues.mobileNumberErrorMessage || props.errorValues.mobileNumberErrorMessage !== 'validated' &&
                    <span className="error-message">{props.errorValues.mobileNumberErrorMessage}</span>
                }
            </div>
            <div className="radio-toolbar input-error-container"
                onBlur={e => handleBlur(e, 'role')}>
                <input
                    type="radio"
                    id="medium"
                    name="role"
                />
                <label className="r_label" htmlFor="medium" onClick={e => handleClick(e, 'USER')}>Medium 29.99$ /Mo</label>
                <input
                    type="radio"
                    id="large"
                    name="role"
                />
                <label className="r_label" htmlFor="large" onClick={e => handleClick(e, 'PREMIUM')}>Large 46.99$ /Mo</label>
                <input
                    type="radio"
                    id="xlarge"
                    name="role"
                />
                <label className="r_label" htmlFor="xlarge" onClick={e => handleClick(e, 'ELIT')}>XLarge 55.99$ /Mo</label>
                {
                    !props.errorValues.roleErrorMessage || props.errorValues.roleErrorMessage !== 'validated' &&
                    <span className="error-message">{props.errorValues.roleErrorMessage}</span>
                }
            </div>
        </div>
    )
}