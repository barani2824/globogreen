/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdi.onboardinghelper.service.dto;

import java.sql.Date;

public class PreviousEmploymentDTO {

    private String universalAccountNumber;
    private String pfAccountNumber;
    private Date dateOfExit;
    private String schemeCertificateNumber;
    private String pensionPaymentOrderNumber;
    private boolean isInternationalWorker;
    private String country;
    private String passportNumber;
    private Date dateOfIssue;
    private Date dateOfExpiry;
    
    
    public PreviousEmploymentDTO(String universalAccountNumber, String pfAccountNumber, Date dateOfExit, String schemeCertificateNumber, String pensionPaymentOrderNumber, boolean isInternationalWorker, String country, String passportNumber, Date dateOfIssue, Date dateOfExpiry) {
        this.universalAccountNumber = universalAccountNumber;
        this.pfAccountNumber = pfAccountNumber;
        this.dateOfExit = dateOfExit;
        this.schemeCertificateNumber = schemeCertificateNumber;
        this.pensionPaymentOrderNumber = pensionPaymentOrderNumber;
        this.isInternationalWorker = isInternationalWorker;
        this.country = country;
        this.passportNumber = passportNumber;
        this.dateOfIssue = dateOfIssue;
        this.dateOfExpiry = dateOfExpiry;
    }
    
    public PreviousEmploymentDTO() {}

    /**
     * @return the universalAccountNumber
     */
    public String getUniversalAccountNumber() {
        return universalAccountNumber;
    }

    /**
     * @param universalAccountNumber the universalAccountNumber to set
     */
    public void setUniversalAccountNumber(String universalAccountNumber) {
        this.universalAccountNumber = universalAccountNumber;
    }

    /**
     * @return the pfAccountNumber
     */
    public String getPfAccountNumber() {
        return pfAccountNumber;
    }

    /**
     * @param pfAccountNumber the pfAccountNumber to set
     */
    public void setPfAccountNumber(String pfAccountNumber) {
        this.pfAccountNumber = pfAccountNumber;
    }

    /**
     * @return the dateOfExit
     */
    public Date getDateOfExit() {
        return dateOfExit;
    }

    /**
     * @param dateOfExit the dateOfExit to set
     */
    public void setDateOfExit(Date dateOfExit) {
        this.dateOfExit = dateOfExit;
    }

    /**
     * @return the schemeCertificateNumber
     */
    public String getSchemeCertificateNumber() {
        return schemeCertificateNumber;
    }

    /**
     * @param schemeCertificateNumber the schemeCertificateNumber to set
     */
    public void setSchemeCertificateNumber(String schemeCertificateNumber) {
        this.schemeCertificateNumber = schemeCertificateNumber;
    }

    /**
     * @return the pensionPaymentOrderNumber
     */
    public String getPensionPaymentOrderNumber() {
        return pensionPaymentOrderNumber;
    }

    /**
     * @param pensionPaymentOrderNumber the pensionPaymentOrderNumber to set
     */
    public void setPensionPaymentOrderNumber(String pensionPaymentOrderNumber) {
        this.pensionPaymentOrderNumber = pensionPaymentOrderNumber;
    }

    /**
     * @return the isInternationalWorker
     */
    public boolean isInternationalWorker() {
        return isInternationalWorker;
    }

    /**
     * @param isInternationalWorker the isInternationalWorker to set
     */
    public void setIsInternationalWorker(boolean isInternationalWorker) {
        this.isInternationalWorker = isInternationalWorker;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
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
}
