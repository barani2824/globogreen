/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdi.onboardinghelper.service.dto;

import java.sql.Date;
import java.util.List;

public class PersonalFormDTO {

    private String title;
    private String firstname;
    private String lastname;
    private AddressDTO presentAddress;
    private AddressDTO permanentAddress;
    private List<PhoneDTO> phones;
    private String email;
    private Date dateOfBirth;
    private String gender;
    private String maritalStatus;
    private String nationality;
    private String passportNumber;
    private String placeOfPassportIssue;
    private Date dateOfIssue;
    private Date dateOfExpiry;
    private String placeOfBirth;
    private String aadharNumber;
    private String panNumber;
    private List<DependentDTO> dependents;
    private List<EmergencyContactDTO> emergencyContacts;
    
        public PersonalFormDTO(String title, String firstname, String lastname, AddressDTO presentAddress, AddressDTO permanentAddress, List<PhoneDTO> phones, String email, Date dateOfBirth, String gender, String maritalStatus, String nationality, String passportNumber, String placeOfPassportIssue, Date dateOfIssue, Date dateOfExpiry, String placeOfBirth, String aadharNumber, String panNumber, List<DependentDTO> dependents, List<EmergencyContactDTO> emergencyContacts) {
        this.title = title;
        this.firstname = firstname;
        this.lastname = lastname;
        this.presentAddress = presentAddress;
        this.permanentAddress = permanentAddress;
        this.phones = phones;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.nationality = nationality;
        this.passportNumber = passportNumber;
        this.placeOfPassportIssue = placeOfPassportIssue;
        this.dateOfIssue = dateOfIssue;
        this.dateOfExpiry = dateOfExpiry;
        this.placeOfBirth = placeOfBirth;
        this.aadharNumber = aadharNumber;
        this.panNumber = panNumber;
        this.dependents = dependents;
        this.emergencyContacts = emergencyContacts;
    }
        
    public PersonalFormDTO() {}

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the presentAddress
     */
    public AddressDTO getPresentAddress() {
        return presentAddress;
    }

    /**
     * @param presentAddress the presentAddress to set
     */
    public void setPresentAddress(AddressDTO presentAddress) {
        this.presentAddress = presentAddress;
    }

    /**
     * @return the permanentAddress
     */
    public AddressDTO getPermanentAddress() {
        return permanentAddress;
    }

    /**
     * @param permanentAddress the permanentAddress to set
     */
    public void setPermanentAddress(AddressDTO permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    /**
     * @return the phones
     */
    public List<PhoneDTO> getPhones() {
        return phones;
    }

    /**
     * @param phones the phones to set
     */
    public void setPhones(List<PhoneDTO> phones) {
        this.phones = phones;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the dateOfBirth
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @param dateOfBirth the dateOfBirth to set
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the maritalStatus
     */
    public String getMaritalStatus() {
        return maritalStatus;
    }

    /**
     * @param maritalStatus the maritalStatus to set
     */
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    /**
     * @return the nationality
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * @param nationality the nationality to set
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * @return the passportNumber
     */
    public String getPassportNumber() {
        return passportNumber;
    }

    /**
     * @param passportNumber the passportNumber to set
     */
    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    /**
     * @return the placeOfPassportIssue
     */
    public String getPlaceOfPassportIssue() {
        return placeOfPassportIssue;
    }

    /**
     * @param placeOfPassportIssue the placeOfPassportIssue to set
     */
    public void setPlaceOfPassportIssue(String placeOfPassportIssue) {
        this.placeOfPassportIssue = placeOfPassportIssue;
    }

    /**
     * @return the dateOfIssue
     */
    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    /**
     * @param dateOfIssue the dateOfIssue to set
     */
    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    /**
     * @return the dateOfExpiry
     */
    public Date getDateOfExpiry() {
        return dateOfExpiry;
    }

    /**
     * @param dateOfExpiry the dateOfExpiry to set
     */
    public void setDateOfExpiry(Date dateOfExpiry) {
        this.dateOfExpiry = dateOfExpiry;
    }

    /**
     * @return the placeOfBirth
     */
    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    /**
     * @param placeOfBirth the placeOfBirth to set
     */
    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    /**
     * @return the aadharNumber
     */
    public String getAadharNumber() {
        return aadharNumber;
    }

    /**
     * @param aadharNumber the aadharNumber to set
     */
    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    /**
     * @return the panNumber
     */
    public String getPanNumber() {
        return panNumber;
    }

    /**
     * @param panNumber the panNumber to set
     */
    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    /**
     * @return the dependents
     */
    public List<DependentDTO> getDependents() {
        return dependents;
    }

    /**
     * @param dependents the dependents to set
     */
    public void setDependents(List<DependentDTO> dependents) {
        this.dependents = dependents;
    }

    /**
     * @return the emergencyContacts
     */
    public List<EmergencyContactDTO> getEmergencyContacts() {
        return emergencyContacts;
    }

    /**
     * @param emergencyContacts the emergencyContacts to set
     */
    public void setEmergencyContacts(List<EmergencyContactDTO> emergencyContacts) {
        this.emergencyContacts = emergencyContacts;
    }
}
