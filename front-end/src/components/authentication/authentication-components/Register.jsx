import React, { useState, useRef, useLayoutEffect } from "react";
import RegisterSectionOne from "./children/RegisterSectionOne";
import RegisterSectionTwo from "./children/RegisterSectionTwo";
import RegisterSectionThree from "./children/RegisterSectionThree";
import RegisterSectionFour from "./children/RegisterSectionFour";
import { validateFields } from '../../../utils/validations.js';
import Axios from "axios";

const REGISTER_API_URL = "http://localhost:8080/AlterHabits/register/submit";

export default function Register(props) {

  const [panelNumber, setPanelNumber] = useState(0);
  const [panel1isInvalid, setPanel1isInvalid] = useState(true);
  const [panel2isInvalid, setPanel2isInvalid] = useState(true);
  const [panel3isInvalid, setPanel3isInvalid] = useState(true);
  const [panel4isInvalid, setPanel4isInvalid] = useState(true);

  // Panel 1
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [retypedPassword, setRetypedPassword] = useState('');
  // Panel 2
  const [firstName, setFirstName] = useState('');
  const [lastName, setLastName] = useState('');
  const [gender, setGender] = useState('');
  const [dateOfBirth, setDateOfBirth] = useState(new Date());
  // Panel 3
  const [email, setEmail] = useState('');
  const [phoneNumber, setPhoneNumber] = useState('');
  const [mobileNumber, setMobileNumber] = useState('');
  const [role, setRole] = useState('');
  // Panel 4
  const [creditCardNumber, setCreditCardNumber] = useState('');
  const [creditCardName, setCreditCardName] = useState('');
  const [creditCardExpMonth, setCreditCardExpMonth] = useState('');
  const [creditCardExpYear, setCreditCardExpYear] = useState('');

  // Errors displayed state
  //Panel 1
  const [usernameErrorMessage, setUsernameErrorMessage] = useState('');
  const [passwordErrorMessage, setPasswordErrorMessage] = useState('');
  const [retypedPasswordErrorMessage, setRetypedPasswordErrorMessage] = useState('');
  // Panel 2
  const [firstNameErrorMessage, setFirstNameErrorMessage] = useState('');
  const [lastNameErrorMessage, setLastNameErrorMessage] = useState('');
  const [genderErrorMessage, setGenderErrorMessage] = useState('');
  const [dateOfBirthErrorMessage, setDateOfBirthErrorMessage] = useState('');
  // Panel 3
  const [emailErrorMessage, setEmailErrorMessage] = useState('');
  const [phoneNumberErrorMessage, setPhoneNumberErrorMessage] = useState('');
  const [mobileNumberErrorMessage, setMobileNumberErrorMessage] = useState('');
  const [roleErrorMessage, setRoleErrorMessage] = useState('');
  // Panel 4
  const [creditCardNumberErrorMessage, setCreditCardNumberErrorMessage] = useState('');
  const [creditCardNameErrorMessage, setCreditCardNameErrorMessage] = useState('');
  const [creditCardExpMonthErrorMessage, setCreditCardExpMonthErrorMessage] = useState('');
  const [creditCardExpYearErrorMessage, setCreditCardExpYearErrorMessage] = useState('');



  const panel1values = {
    username,
    password,
    retypedPassword
  }

  const panel2values = {
    firstName,
    lastName,
    gender,
    dateOfBirth,
  }

  const panel3values = {
    email,
    phoneNumber,
    mobileNumber,
    role
  }

  const panel4values = {
    creditCardNumber,
    creditCardName,
    creditCardExpMonth,
    creditCardExpYear
  }

  const panel1errorValues = {
    usernameErrorMessage,
    passwordErrorMessage,
    retypedPasswordErrorMessage
  }

  const panel2errorValues = {
    firstNameErrorMessage,
    lastNameErrorMessage,
    genderErrorMessage,
    dateOfBirthErrorMessage,
  }

  const panel3errorValues = {
    emailErrorMessage,
    phoneNumberErrorMessage,
    mobileNumberErrorMessage,
    roleErrorMessage
  }

  const panel4errorValues = {
    creditCardNumberErrorMessage,
    creditCardNameErrorMessage,
    creditCardExpMonthErrorMessage,
    creditCardExpYearErrorMessage
  }

  const panel1setterValues = {
    setUsername,
    setPassword,
    setRetypedPassword
  }

  const panel2setterValues = {
    setFirstName,
    setLastName,
    setGender,
    setDateOfBirth
  }

  const panel3setterValues = {
    setEmail,
    setPhoneNumber,
    setMobileNumber,
    setRole
  }

  const panel4setterValues = {
    setCreditCardNumber,
    setCreditCardName,
    setCreditCardExpMonth,
    setCreditCardExpYear,
  }

  const panel1setterErrorValues = {
    setUsernameErrorMessage,
    setPasswordErrorMessage,
    setRetypedPasswordErrorMessage
  }

  const panel2setterErrorValues = {
    setFirstNameErrorMessage,
    setLastNameErrorMessage,
    setGenderErrorMessage,
    setDateOfBirthErrorMessage
  }

  const panel3setterErrorValues = {
    setEmailErrorMessage,
    setPhoneNumberErrorMessage,
    setMobileNumberErrorMessage,
    setRoleErrorMessage
  }

  const panel4setterErrorValues = {
    setCreditCardNumberErrorMessage,
    setCreditCardNameErrorMessage,
    setCreditCardExpMonthErrorMessage,
    setCreditCardExpYearErrorMessage,
  }

  const firstUpdate = useRef(true);

  useLayoutEffect(() => {
    if (firstUpdate.current) {
      return;
    }
    setUsernameErrorMessage(validateFields.validateUsername(username));
  }, [username])

  useLayoutEffect(() => {
    if (firstUpdate.current) {
      return;
    }
    setPasswordErrorMessage(validateFields.validatePassword(password));

  }, [password]);

  useLayoutEffect(() => {
    if (firstUpdate.current) {
      return;
    }
    setRetypedPasswordErrorMessage(validateFields.validateRetypedPassword(password, retypedPassword));
  }, [retypedPassword]);

  useLayoutEffect(() => {
    if (firstUpdate.current) {
      return;
    }
    setFirstNameErrorMessage(validateFields.validateFirstName(firstName));
  }, [firstName]);

  useLayoutEffect(() => {
    if (firstUpdate.current) {
      return;
    }
    setLastNameErrorMessage(validateFields.validateLastName(lastName));
  }, [lastName]);

  useLayoutEffect(() => {
    if (firstUpdate.current) {
      return;
    }
    setGenderErrorMessage(validateFields.validateGender(gender));
  }, [gender]);

  useLayoutEffect(() => {
    if (firstUpdate.current) {
      return;
    }
    setDateOfBirthErrorMessage(validateFields.validateDateOfBirth(dateOfBirth.toString()));
  }, [dateOfBirth]);

  useLayoutEffect(() => {
    if (firstUpdate.current) {
      return;
    }
    setEmailErrorMessage(validateFields.validateEmail(email));
  }, [email]);

  useLayoutEffect(() => {
    if (firstUpdate.current) {
      return;
    }
    setPhoneNumberErrorMessage(validateFields.validatePhoneNumber(phoneNumber));
  }, [phoneNumber]);

  useLayoutEffect(() => {
    if (firstUpdate.current) {
      return;
    }
    setMobileNumberErrorMessage(validateFields.validateMobileNumber(mobileNumber));
  }, [mobileNumber]);

  useLayoutEffect(() => {
    if (firstUpdate.current) {
      return;
    }
    setRoleErrorMessage(validateFields.validateSubscription(role));
  }, [role]);

  useLayoutEffect(() => {
    if (firstUpdate.current) {
      return;
    }
    setCreditCardNumberErrorMessage(validateFields.validateCreditCardNumber(creditCardNumber));
  }, [creditCardNumber]);

  useLayoutEffect(() => {
    if (firstUpdate.current) {
      return;
    }
    setCreditCardNameErrorMessage(validateFields.validateCreditCardName(creditCardName));
  }, [creditCardName]);

  useLayoutEffect(() => {
    if (firstUpdate.current) {
      return;
    }
    setCreditCardExpMonthErrorMessage(validateFields.validateCreditCardExpMonth(creditCardExpMonth));
  }, [creditCardExpMonth]);

  useLayoutEffect(() => {
    if (firstUpdate.current) {
      firstUpdate.current = false;
      return;
    }
    setCreditCardExpYearErrorMessage(validateFields.validateCreditCardExpYear(creditCardExpYear));
  }, [creditCardExpYear]);

  useLayoutEffect(() => {
    if (panelNumber === 0) {
      if (usernameErrorMessage === 'validated' && passwordErrorMessage === 'validated' && retypedPasswordErrorMessage === 'validated') {
        console.log("entered second if")
        setPanel1isInvalid(false);
      } else {
        setPanel1isInvalid(true);
      }
    } else if (panelNumber === 1) {
      if (firstNameErrorMessage === 'validated' && lastNameErrorMessage === 'validated' && genderErrorMessage === 'validated' && dateOfBirthErrorMessage === 'validated') {
        setPanel2isInvalid(false);
      } else {
        setPanel2isInvalid(true);
      }
    } else if (panelNumber === 2) {
      console.log("entered first if")
      console.log(emailErrorMessage)
      console.log(phoneNumberErrorMessage)
      console.log(mobileNumberErrorMessage)
      if (emailErrorMessage === 'validated' && (phoneNumberErrorMessage === 'validated' || phoneNumberErrorMessage === '') && mobileNumberErrorMessage === 'validated' && roleErrorMessage === 'validated') {
        setPanel3isInvalid(false);
      } else {
        setPanel3isInvalid(true);
      }
    } else if (panelNumber === 3) {
      if (creditCardNumberErrorMessage === 'validated' && creditCardNameErrorMessage === 'validated' && creditCardExpMonthErrorMessage === 'validated' && creditCardExpYearErrorMessage === 'validated') {
        setPanel4isInvalid(false)
      } else {
        setPanel4isInvalid(true);
      }
    }
  }, [usernameErrorMessage, passwordErrorMessage, retypedPasswordErrorMessage, firstNameErrorMessage, lastNameErrorMessage, dateOfBirthErrorMessage, genderErrorMessage, emailErrorMessage, phoneNumberErrorMessage, mobileNumberErrorMessage, roleErrorMessage, creditCardNumberErrorMessage, creditCardNameErrorMessage, creditCardExpMonthErrorMessage, creditCardExpYearErrorMessage])

  function handleButtonClick(direction, e) {
    if (direction === 'back') {
      setPanelNumber(panelNumber - 1);
    } else if (direction === 'forward') {
      setPanelNumber(panelNumber + 1);
    } else if (direction === 'submit') {
      Axios.post(REGISTER_API_URL, {
                name: firstName,
                surname: lastName,
                gender: gender,
                dateOfBirth: dateOfBirth.toString(),
                email: email,
                phoneNumber: phoneNumber,
                mobileNumber: mobileNumber,
                username: username,
                password: password,
                matchingPassword: password,
                role: role,
                creditDebitCardNumber: creditCardNumber,
                creditDebitCardName: creditCardName,
                creditDebitCardExpMonth: creditCardExpMonth,
                creditDebitCardExpYear: creditCardExpYear
              
      }).then(response => {
        console.log(response)
        props.setDisplayedModal('')
      })
    }
  }

  function onClickForm(e) {
    e.stopPropagation();
  }

  function handleSubmitForm(e) {
    e.preventDefault();
  }

  return (
    <div className={props.customRegisterStyle} onClick={onClickForm}>
      <form className='register-form' onSubmit={handleSubmitForm}>
        <RegisterSectionOne
          panelNumber={panelNumber}
          values={panel1values}
          setterValues={panel1setterValues}
          errorValues={panel1errorValues}
          setterErrorValues={panel1setterErrorValues} />
        <RegisterSectionTwo
          panelNumber={panelNumber}
          values={panel2values}
          setterValues={panel2setterValues}
          errorValues={panel2errorValues}
          setterErrorValues={panel2setterErrorValues} />
        <RegisterSectionThree
          panelNumber={panelNumber}
          values={panel3values}
          setterValues={panel3setterValues}
          errorValues={panel3errorValues}
          setterErrorValues={panel3setterErrorValues} />
        <RegisterSectionFour
          panelNumber={panelNumber}
          values={panel4values}
          setterValues={panel4setterValues}
          errorValues={panel4errorValues}
          setterErrorValues={panel4setterErrorValues} />
      </form>
      <div className="buttons-container">
        <button className="back-button" disabled={panelNumber < 1 && true} onClick={e => handleButtonClick('back', e)}>Previous</button>
        {
          panelNumber === 0 &&
          <button className="forward-button" disabled={panel1isInvalid && true} onClick={e => handleButtonClick('forward', e)}>{panelNumber === 3 ? "Submit" : "Next"}</button>
        }
        {
          panelNumber === 1 &&
          <button className="forward-button" disabled={panel2isInvalid && true} onClick={e => handleButtonClick('forward', e)}>{panelNumber === 3 ? "Submit" : "Next"}</button>
        }
        {
          panelNumber === 2 &&
          <button className="forward-button" disabled={panel3isInvalid && true} onClick={e => handleButtonClick('forward', e)}>{panelNumber === 3 ? "Submit" : "Next"}</button>
        }
        {
          panelNumber === 3 &&
          <button className="forward-button" disabled={panel4isInvalid && true} onClick={e => handleButtonClick('submit', e)}>{panelNumber === 3 ? "Submit" : "Next"}</button>
        }
      </div>
    </div>
  )
}
