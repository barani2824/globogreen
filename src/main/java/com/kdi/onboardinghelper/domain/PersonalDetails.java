/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdi.onboardinghelper.domain;

import com.kdi.onboardinghelper.config.Constants;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author barank
 */
@Entity
@Table(name = "jhi_personal_details")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class PersonalDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private static long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column(length = 254, unique = true)
    private String email;

    @Column(name = "gender", length = 50)
    private String gender;
    
    @Column(name = "PASSPORT_NUMBER", length = 50)
    private String passportNumber;
    @Column(name = "PASSPORT_ISSUED_DATE", length = 50)
    private String passportIssuedDate;
    @Column(name = "MARITAL_STATUS", length = 50)
    private String maritalStatus;
    @Column(name = "dob", length = 50)
    private String dob;
    @Column(name = "aadhar", length = 50)
    private String aadhar;
    @Column(name = "PHONE_NUMBER", length = 50)
    private Integer phoneNumber;
    @Column(name = "nationality", length = 50)
    private String nationality;
    @Column(name = "PLACE_OF_ISSUE", length = 50)
    private String placeOfIssue;
    @Column(name = "DAE_OF_EXPIRY", length = 50)
    private String daeOfExpiry;
    @Column(name = "PLACE_OF_BIRTH", length = 50)
    private String placeOfBirth;
    @Column(name = "pan", length = 50)
    private String pan;
    @Column(name = "PRESENT_ADDRESS", length = 50)
    private String presentAddress;
    @Column(name = "PRESENT_PIN", length = 50)
    private String presentPin;
    @Column(name = "PERMENANT_ADDRESS", length = 50)
    private String permenantAddress;
    @Column(name = "PERMENANT_PIN", length = 50)
    private String permenantPin;

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
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
     * @return the passportIssuedDate
     */
    public String getPassportIssuedDate() {
        return passportIssuedDate;
    }

    /**
     * @param passportIssuedDate the passportIssuedDate to set
     */
    public void setPassportIssuedDate(String passportIssuedDate) {
        this.passportIssuedDate = passportIssuedDate;
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
     * @return the dob
     */
    public String getDob() {
        return dob;
    }

    /**
     * @param dob the dob to set
     */
    public void setDob(String dob) {
        this.dob = dob;
    }

    /**
     * @return the aadhar
     */
    public String getAadhar() {
        return aadhar;
    }

    /**
     * @param aadhar the aadhar to set
     */
    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    /**
     * @return the phoneNumber
     */
    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
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
     * @return the placeOfIssue
     */
    public String getPlaceOfIssue() {
        return placeOfIssue;
    }

    /**
     * @param placeOfIssue the placeOfIssue to set
     */
    public void setPlaceOfIssue(String placeOfIssue) {
        this.placeOfIssue = placeOfIssue;
    }

    /**
     * @return the daeOfExpiry
     */
    public String getDaeOfExpiry() {
        return daeOfExpiry;
    }

    /**
     * @param daeOfExpiry the daeOfExpiry to set
     */
    public void setDaeOfExpiry(String daeOfExpiry) {
        this.daeOfExpiry = daeOfExpiry;
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
     * @return the pan
     */
    public String getPan() {
        return pan;
    }

    /**
     * @param pan the pan to set
     */
    public void setPan(String pan) {
        this.pan = pan;
    }

    /**
     * @return the presentAddress
     */
    public String getPresentAddress() {
        return presentAddress;
    }

    /**
     * @param presentAddress the presentAddress to set
     */
    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

    /**
     * @return the presentPin
     */
    public String getPresentPin() {
        return presentPin;
    }

    /**
     * @param presentPin the presentPin to set
     */
    public void setPresentPin(String presentPin) {
        this.presentPin = presentPin;
    }

    /**
     * @return the permenantAddress
     */
    public String getPermenantAddress() {
        return permenantAddress;
    }

    /**
     * @param permenantAddress the permenantAddress to set
     */
    public void setPermenantAddress(String permenantAddress) {
        this.permenantAddress = permenantAddress;
    }

    /**
     * @return the permenantPin
     */
    public String getPermenantPin() {
        return permenantPin;
    }

    /**
     * @param permenantPin the permenantPin to set
     */
    public void setPermenantPin(String permenantPin) {
        this.permenantPin = permenantPin;
    }

}
