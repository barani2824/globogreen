/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdi.onboardinghelper.service.dto;

import java.sql.Date;

public class ProvidentFundFormDTO {

    private String firstname;
    private String lastname;
    private Date dateOfBirth;
    private String gender;
    private String maritalStatus;
    private String fatherOrSpouseName;
    private String email;
    private String phone;
    private boolean isEarlierMemberOfPfScheme;
    private boolean isEarlierMemberOfPScheme;
    private PreviousEmploymentDTO previousEmployment;
    private String accountNumber;
    private String ifscCode;
    private String aadharNumber;
    private String panNumber;

    public ProvidentFundFormDTO(String firstname, String lastname, Date dateOfBirth, String gender, String maritalStatus, String fatherOrSpouseName, String email, String phone, boolean isEarlierMemberOfPfScheme, boolean isEarlierMemberOfPScheme, PreviousEmploymentDTO previousEmployment, String accountNumber, String ifscCode, String aadharNumber, String panNumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.fatherOrSpouseName = fatherOrSpouseName;
        this.email = email;
        this.phone = phone;
        this.isEarlierMemberOfPfScheme = isEarlierMemberOfPfScheme;
        this.isEarlierMemberOfPScheme = isEarlierMemberOfPScheme;
        this.previousEmployment = previousEmployment;
        this.accountNumber = accountNumber;
        this.ifscCode = ifscCode;
        this.aadharNumber = aadharNumber;
        this.panNumber = panNumber;
    }
    
    public ProvidentFundFormDTO() {}

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
     * @return the fatherOrSpouseName
     */
    public String getFatherOrSpouseName() {
        return fatherOrSpouseName;
    }

    /**
     * @param fatherOrSpouseName the fatherOrSpouseName to set
     */
    public void setFatherOrSpouseName(String fatherOrSpouseName) {
        this.fatherOrSpouseName = fatherOrSpouseName;
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
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the isEarlierMemberOfPfScheme
     */
    public boolean isEarlierMemberOfPfScheme() {
        return isEarlierMemberOfPfScheme;
    }

    /**
     * @param isEarlierMemberOfPfScheme the isEarlierMemberOfPfScheme to set
     */
    public void setIsEarlierMemberOfPfScheme(boolean isEarlierMemberOfPfScheme) {
        this.isEarlierMemberOfPfScheme = isEarlierMemberOfPfScheme;
    }

    /**
     * @return the isEarlierMemberOfPScheme
     */
    public boolean isEarlierMemberOfPScheme() {
        return isEarlierMemberOfPScheme;
    }

    /**
     * @param isEarlierMemberOfPScheme the isEarlierMemberOfPScheme to set
     */
    public void setIsEarlierMemberOfPScheme(boolean isEarlierMemberOfPScheme) {
        this.isEarlierMemberOfPScheme = isEarlierMemberOfPScheme;
    }

    /**
     * @return the previousEmployment
     */
    public PreviousEmploymentDTO getPreviousEmployment() {
        return previousEmployment;
    }

    /**
     * @param previousEmployment the previousEmployment to set
     */
    public void setPreviousEmployment(PreviousEmploymentDTO previousEmployment) {
        this.previousEmployment = previousEmployment;
    }

    /**
     * @return the accountNumber
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * @param accountNumber the accountNumber to set
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * @return the ifscCode
     */
    public String getIfscCode() {
        return ifscCode;
    }

    /**
     * @param ifscCode the ifscCode to set
     */
    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
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
}
