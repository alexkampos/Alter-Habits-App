import React from 'react';

export default function RegisterSectionFour(props) {

    function handleChange(e, inputName) {
        if (inputName === 'credit card number') {
            const value = e.target.value;
            props.setterValues.setCreditCardNumber(value);
        } else if (inputName === 'credit card name') {
            const value = e.target.value;
            props.setterValues.setCreditCardName(value);
        } else if (inputName === 'credit card month') {
            const value = e.target.value;
            props.setterValues.setCreditCardExpMonth(value);
        } else if (inputName === 'credit card year') {
            const value = e.target.value;
            props.setterValues.setCreditCardExpYear(value);
        }
    }

    function handleBlur(e, inputName) {
        if (inputName === 'credit card number') {
            props.errorValues.creditCardNumberErrorMessage !== 'validated' && props.setterErrorValues.setCreditCardNumberErrorMessage('');
        } else if (inputName === 'credit card name') {
            props.errorValues.creditCardNameErrorMessage !== 'validated' && props.setterErrorValues.setCreditCardNameErrorMessage('');
        } else if (inputName === 'credit card month') {
            props.errorValues.creditCardExpMonthErrorMessage !== 'validated' && props.setterErrorValues.setCreditCardExpMonthErrorMessage('');
        } else if (inputName === 'credit card year') {
            props.errorValues.creditCardExpYearErrorMessage !== 'validated' && props.setterErrorValues.setCreditCardExpYearErrorMessage('');
        }
    }

    return (
        <div className={props.panelNumber !== 3 ? "not-display" : "register-section-four"}>
            <div className="input-error-container">
                <input 
                className="text-inputs" 
                type="text" 
                placeholder="Credit card number... *"
                autoComplete="new-password"
                value={props.values.creditCardNumber}
                onChange={e => handleChange(e, 'credit card number')}
                onBlur={e => handleBlur(e, 'credit card number')} />
                {
                    !props.errorValues.creditCardNumberErrorMessage || props.errorValues.creditCardNumberErrorMessage !== 'validated' &&
                    <span className="error-message">{props.errorValues.creditCardNumberErrorMessage}</span>
                }
            </div>
            <div className="input-error-container">
                <input 
                className="text-inputs" 
                type="text" 
                placeholder="Credit card name... *"
                value={props.values.creditCardName}
                onChange={e => handleChange(e, 'credit card name')}
                onBlur={e => handleBlur(e, 'credit card name')} />
                {
                    !props.errorValues.creditCardNameErrorMessage || props.errorValues.creditCardNameErrorMessage !== 'validated' &&
                    <span className="error-message">{props.errorValues.creditCardNameErrorMessage}</span>
                }
            </div>
            <div className="input-error-container">
                <input 
                className="text-inputs"
                type="text" 
                placeholder="Credit card exp. month... *"
                value={props.values.creditCardExpMonth}
                onChange={e => handleChange(e, 'credit card month')}
                onBlur={e => handleBlur(e, 'credit card month')}  />
                {
                    !props.errorValues.creditCardExpMonthErrorMessage || props.errorValues.creditCardExpMonthErrorMessage !== 'validated' &&
                    <span className="error-message">{props.errorValues.creditCardExpMonthErrorMessage}</span>
                }
            </div>
            <div className="input-error-container">
                <input 
                className="text-inputs" 
                type="text" 
                placeholder="Credit card exp. year... *"
                value={props.values.creditCardExpYear}
                onChange={e => handleChange(e, 'credit card year')}
                onBlur={e => handleBlur(e, 'credit card year')} />
                {
                    !props.errorValues.creditCardExpYearErrorMessage || props.errorValues.creditCardExpYearErrorMessage !== 'validated' &&
                    <span className="error-message">{props.errorValues.creditCardExpYearErrorMessage}</span>
                }
            </div>
        </div>
    )
}