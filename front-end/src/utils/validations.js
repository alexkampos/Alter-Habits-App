import validator from "validator";
import moment from 'moment';

class ValidateFields {

    validateUsername(username) {
        if (validator.isEmpty(username)) {
            return "Username is mandatory!";
        } else {
            if (!validator.isLength(username, { min: 6, max: 20 })) {
                return "Username must be between 6 and 20 characters!";
            } else {
                return "validated";
            }
        }
    }

    validatePassword(password) {
        if (validator.isEmpty(password)) {
            return "Password is mandatory!";
        } else {
            if (!validator.isLength(password, { min: 8 })) {
                return "Password must be more than 8 characters!";
            } else if (!validator.matches(password, "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$")) {
                return "Password must have at least one upper case letter (A-Z), one lower case letter (a-z), one digit (0-9) and one special character (#?!@$%^&*-)!";
            } else {
                return "validated";
            }
        }
    }

    validateRetypedPassword(password, matchingPassword) {
        if (validator.isEmpty(matchingPassword)) {
            return "This field is mandatory!";
        } else {
            if (password !== matchingPassword) {
                return "This field must match password field!";
            } else {
                return "validated";
            }
        }
    }

    validateFirstName(firstName) {
        if (validator.isEmpty(firstName)) {
            return "First name is mandatory!";
        } else {
            if (!validator.matches(firstName, "^[A-Za-z]*$")) {
                return "Only letters allowed!"
            } else if (!validator.isLength(firstName, { min: 2, max: 50 })) {
                return "First name must be between 2 and 50 characters!";
            } else {
                return "validated";
            }
        }
    }

    validateLastName(lastName) {
        if (validator.isEmpty(lastName)) {
            return "Last name is mandatory!";
        } else {
            if (!validator.matches(lastName, "^[A-Za-z]*$")) {
                return "Only letters allowed!"
            } else if (!validator.isLength(lastName, { min: 2, max: 50 })) {
                return "Last name must be between 2 and 50 characters!";
            } else {
                return "validated";
            }
        }
    }


    validateGender(gender) {
        if (gender === 'Gender') {
            return "Gender is mandatory!";
        } else {
            return "validated";
        }
    }

    validateDateOfBirth(dateOfBirth) {
        const maxAgeDate = moment(new Date('1920-01-01')).format('DD/MM/YYYY');
        const minAgeDate = moment(new Date('2003-01-01')).format('DD/MM/YYYY');
        if (!validator.isAfter(dateOfBirth, maxAgeDate)) {
            return "You must be an adult to use our services!";
        } else if (!validator.isBefore(dateOfBirth, minAgeDate)) {
            return "A little bit too old...";
        } else {
            return "validated";
        }
    }

    validateEmail(email) {
        if (validator.isEmpty(email)) {
            return "Email is mandatory!";
        } else {
            if (!validator.isEmail(email)) {
                return "Invalid email!"
            } else if (!validator.isLength(email, { max: 200 })) {
                return "Email can't be more than 200 characters!";
            } else {
                return "validated";
            }
        }
    }

    validatePhoneNumber(phoneNumber) {
            if (!validator.matches(phoneNumber, "^21[0-9]+$")) {
                return "Invalid phone number!";
            } else if (!validator.isLength(phoneNumber, { min: 10, max: 10 })) {
                return "Phone number must be 10 digits.";
            } else {
                return "validated";
            }
    }

    validateMobileNumber(mobileNumber) {
        if (validator.isEmpty(mobileNumber)) {
            return "Mobile number is mandatory!";
        } else {
            if (!validator.matches(mobileNumber, "^69[0-9]+$")) {
                return "Invalid mobile number!";
            } else if (!validator.isLength(mobileNumber, { min: 10, max: 10 })) {
                return "Mobile number must be 10 digits."
            } else {
                return "validated";
            }
        }
    }

    validateSubscription(subscription) {
        if (validator.isEmpty(subscription)) {
            return "Please choose a subscription";
        } else {
            return "validated";
        }
    }

    validateCreditCardNumber(creditCardNumber) {
        if (validator.isEmpty(creditCardNumber)) {
            return "Credit card number is mandatory!";
        } else {
            if (!validator.isCreditCard(creditCardNumber)) {
                return "Invalid credit card number!";
            } else {
                return "validated";
            }
        }
    }

    validateCreditCardName(creditCardName) {
        if (validator.isEmpty(creditCardName)) {
            return "Credit card name is mandatory!";
        } else {
            if (!validator.isAlpha(creditCardName)) {
                return "Only letters allowed!";
            } else if (!validator.isLength(creditCardName, { min: 5, max: 60 })) {
                return "Credit card name must be between 5 and 60 letters.";
            } else {
                return "validated";
            }
        }
    }

    validateCreditCardExpMonth(expMonth) {
        if (validator.isEmpty(expMonth)) {
            return "This field is mandatory!";
        } else {
            if (!validator.matches(expMonth, "^(0?[1-9]|1[012])$")) {
                return "Enter a valid two digit value (e.g. 05).";
            } else {
                return "validated";
            }
        }
    }

    validateCreditCardExpYear(expYear) {
        if (validator.isEmpty(expYear)) {
            return "This field is mandatory!";
        } else {
            if (!validator.matches(expYear, "^20[0-9]{2}$")) {
                return "Enter a valid 4 digit value starting with 20__ (e.g. 2025)";
            } else {
                return "validated";
            }
        }
    }

}

const validateFields = new ValidateFields();

export { validateFields };