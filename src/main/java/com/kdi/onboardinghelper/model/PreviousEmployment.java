/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdi.onboardinghelper.model;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

/**
 *
 * @author subasb
 */
@Entity
@Table(name = "jhi_previous_employment")
public class PreviousEmployment implements Serializable {

    /**
     *
     */
    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String universalAccountNumber;
    private String pfAccountNumber;
    private Date dateOfExit;
    private String schemeCertificateNumber;
    private String pensionPaymentOrderNumber;
    private boolean internationalWorker;
    private String country;

    public PreviousEmployment(Long id) {
        this.id = id;
    }

    public PreviousEmployment() {

    }

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
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

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
     * @return the internationalWorker
     */
    public boolean isInternationalWorker() {
        return internationalWorker;
    }

    /**
     * @param internationalWorker the internationalWorker to set
     */
    public void setInternationalWorker(boolean internationalWorker) {
        this.internationalWorker = internationalWorker;
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
}
