import React, { forwardRef } from 'react';
import Select from 'react-select';
import DatePicker from 'react-datepicker';
import "react-datepicker/dist/react-datepicker.css";

export default function RegisterSectionTwo(props) {

    // const MyCustomInput = ({ value, onClick }) => {
    //     return (
    //         <button className="date-of-birth-picker" onClick={onClick}>
    //             {value}
    //         </button>
    //     )
    //     };

        const MyCustomInput = forwardRef((props, ref) => {
            return (
                <button className="date-of-birth-picker" onClick={props.onClick}>
                    {props.value}
                </button>
            )
            });

    const options = [
        { value: 'male', label: 'Male' },
        { value: 'female', label: 'Female' },
        { value: 'other', label: 'Other' }];

    const customStyles = {
        control: (base, state) => ({
            ...base,
            boxShadow: "none",
            color: "rgba(238, 238, 238, 0.849)",
            backgroundColor: "inherit",
            border: "none",
            borderBottom: "1px solid rgba(214, 213, 213, 0.699)",
            outline: "none",
            borderRadius: "0",
            marginTop: "30px"
        })
    };

    function handleBlur(e, inputName) {
        if (inputName === 'first name') {
            props.errorValues.firstNameErrorMessage !== 'validated' && props.setterErrorValues.setFirstNameErrorMessage('')
        } else if (inputName === 'last name') {
            props.errorValues.lastNameErrorMessage !== 'validated' && props.setterErrorValues.setLastNameErrorMessage('')
        } else if (inputName === 'gender') {
            props.errorValues.genderErrorMessage !== 'validated' && props.setterErrorValues.setGenderErrorMessage('')
        } else if (inputName === 'date of birth') {
            props.errorValues.dateOfBirthErrorMessage !== 'validated' && props.setterErrorValues.setDateOfBirthErrorMessage('')
        }
    }

    function handleChange(e, inputName) {
        if (inputName === 'first name') {
            const value = e.target.value;
            props.setterValues.setFirstName(value);
        } else if (inputName === 'last name') {
            const value = e.target.value;
            props.setterValues.setLastName(value);
        } else if (inputName === 'gender') {
            const value = e.value;
            props.setterValues.setGender(value);
        }
    }

    return (
        <div className={props.panelNumber !== 1 ? "not-display" : "register-section-two"}>
            <div className="input-error-container">
                <input
                    className="text-inputs"
                    type="text"
                    placeholder="First name... *"
                    autoComplete="new-password"
                    value={props.values.firstName}
                    onBlur={e => handleBlur(e, 'first name')}
                    onChange={e => handleChange(e, "first name")} />
                {
                    !props.errorValues.firstNameErrorMessage || props.errorValues.firstNameErrorMessage !== 'validated' &&
                    <span className="error-message">{props.errorValues.firstNameErrorMessage}</span>
                }
            </div>
            <div className="input-error-container">
                <input
                    className="text-inputs"
                    type="text"
                    placeholder="Last name... *"
                    autoComplete="new-password"
                    value={props.values.lastName}
                    onBlur={e => handleBlur(e, 'last name')}
                    onChange={e => handleChange(e, "last name")} />
                {
                    !props.errorValues.lastNameErrorMessage || props.errorValues.lastNameErrorMessage !== 'validated' &&
                    <span className="error-message">{props.errorValues.lastNameErrorMessage}</span>
                }
            </div>
            <div className="input-error-container">
                <Select
                    options={options}
                    styles={customStyles}
                    placeholder="Gender... *"
                    onChange={e => handleChange(e, "gender")}
                    onBlur={e => handleBlur(e, 'gender')} />
                {
                    !props.errorValues.genderErrorMessage || props.errorValues.genderErrorMessage !== 'validated' &&
                    <span className="error-message">{props.errorValues.genderErrorMessage}</span>
                }
            </div>
            <div className="input-error-container">
                <DatePicker
                    selected={props.values.dateOfBirth}
                    onChange={dateOfBirth => props.setterValues.setDateOfBirth(dateOfBirth)}
                    customInput={<MyCustomInput />}
                    dateFormat="dd/MM/yyyy"
                    monthsShown={1}
                    showYearDropdown />
                {
                    !props.errorValues.dateOfBirthErrorMessage || props.errorValues.dateOfBirthErrorMessage !== 'validated' &&
                    <span className="error-message">{props.errorValues.dateOfBirthErrorMessage}</span>
                }
            </div>
        </div>
    )
}