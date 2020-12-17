/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.models;

/**
 *
 * @author vaggelis
 */
 
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.CreditCardNumber;

/**
 *
 * @author vaggelis
 */
public class RegisterUserDto {

    @NotEmpty(message = "Name can't be empty!")
    @Pattern(regexp = "^[A-Za-z]*$", message = "Invalid input for name. Name must contain only letters!")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 45 letters!")
    private String name;

    @NotEmpty(message = "Surname can't be empty!")
    @Pattern(regexp = "^[A-Za-z]*$", message = "Invalid input for surname. Surname must contain only letters!")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 45 letters")
    private String surname;
    private String gender;
    private String dateOfBirth;
    
    @Email(message = "Must be a well-formed email address!")
    @NotEmpty(message = "Email is mandatory!")
    @Size(min = 1, max = 200, message = "Email can't be more than 200 characters!")
    private String email;

    @Pattern(regexp = "^21[0-9]+$", message = "Only numbers allowed on this field!")
    @Size(min = 10, max = 10, message = "Phone number must be 10 digits!")
    private String phoneNumber;

    @NotEmpty(message = "Mobile number is mandatory!")
    @Pattern(regexp = "^69[0-9]+$", message = "Only numbers allowed on this field!")
    @Size(min = 10, max = 10, message = "Phone number must be 10 digits!")
    private String mobileNumber;

    @NotEmpty(message = "Username is mandatory!")
    @Size(min = 6, max = 20, message = "Username must be between 6 and 20 characters!")
    private String username;

    @NotEmpty(message = "Password is mandatory!")
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$", message = "Password must be at least 8 characters "
            + "and have at least one upper case letter (A-Z), one lower case letter (a-z), one digit (0-9) and one special character (#?!@$%^&*-)!")
    private String password;

    @NotEmpty(message = "This field is mandatory!")
    private String matchingPassword;
    
    @NotEmpty(message = "Choose a subscription!")
    private String role;
    
    @NotEmpty(message = "Please enter your credit/debit card's number!")
    @CreditCardNumber(message = "Enter a valid credit/debit card number!")
    @Pattern(regexp = "^[0-9]+$", message = "Only numbers allowed on this field.")
    private String creditDebitCardNumber;
    
    @NotEmpty(message = "Please enter you name as it is written on the credit/debit card!")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Enter a valid name!")
    @Size(min = 5, max = 60, message = "This field must be between 5 and 60 letters.")
    private String creditDebitCardName;
    
    @NotEmpty(message = "Please enter the expiration month of your card!")
    @Pattern(regexp = "^(0?[1-9]|1[012])$", message = "Enter a valid two digit value (e.g. 05).")
    private String creditDebitCardExpMonth;
    
    @NotEmpty(message = "Please enter the expiration year of your card!")
    @Pattern(regexp = "^20[0-9]{2}$", message = "Enter a valid 4 digit value starting with 20__ (e.g. 2025)")
    private String creditDebitCardExpYear;
    
    public RegisterUserDto() {
    }

    public RegisterUserDto(String name, String surname, String gender, String dateOfBirth, String email, String phoneNumber, String mobileNumber, String username, String password, String matchingPassword, String role, String creditDebitCardNumber, String creditDebitCardName, String creditDebitCardExpMonth, String creditDebitCardExpYear) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.mobileNumber = mobileNumber;
        this.username = username;
        this.password = password;
        this.matchingPassword = matchingPassword;
        this.role = role;
        this.creditDebitCardNumber = creditDebitCardNumber;
        this.creditDebitCardName = creditDebitCardName;
        this.creditDebitCardExpMonth = creditDebitCardExpMonth;
        this.creditDebitCardExpYear = creditDebitCardExpYear;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getGender() {
        return gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }
    
    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }
    
    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCreditDebitCardNumber() {
        return creditDebitCardNumber;
    }

    public void setCreditDebitCardNumber(String creditDebitCardNumber) {
        this.creditDebitCardNumber = creditDebitCardNumber;
    }

    public String getCreditDebitCardName() {
        return creditDebitCardName;
    }

    public void setCreditDebitCardName(String creditDebitCardName) {
        this.creditDebitCardName = creditDebitCardName;
    }

    public String getCreditDebitCardExpMonth() {
        return creditDebitCardExpMonth;
    }

    public void setCreditDebitCardExpMonth(String creditDebitCardExpMonth) {
        this.creditDebitCardExpMonth = creditDebitCardExpMonth;
    }

    public String getCreditDebitCardExpYear() {
        return creditDebitCardExpYear;
    }

    public void setCreditDebitCardExpYear(String creditDebitCardExpYear) {
        this.creditDebitCardExpYear = creditDebitCardExpYear;
    }
}
