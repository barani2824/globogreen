/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdi.onboardinghelper.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import javax.persistence.Table;

/**
 *
 * @author subasb
 */
@Entity
@Table(name = "jhi_provident_fund")
public class ProvidentFund implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fatherOrSpouseName;
    private String email;
    private String phone;
    private boolean earlierMemberOfPfScheme;
    private boolean earlierMemberOfPScheme;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "previous_emp_id")
    private PreviousEmployment previousEmployment;
    private String accountNumber;
    private String ifscCode;
    private String aadharNumber;
    private String panNumber;

    public ProvidentFund(Long id) {
        this.id = id;
    }

    public ProvidentFund() {

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
     * @return the earlierMemberOfPfScheme
     */
    public boolean isEarlierMemberOfPfScheme() {
        return earlierMemberOfPfScheme;
    }

    /**
     * @param earlierMemberOfPfScheme the earlierMemberOfPfScheme to set
     */
    public void setEarlierMemberOfPfScheme(boolean earlierMemberOfPfScheme) {
        this.earlierMemberOfPfScheme = earlierMemberOfPfScheme;
    }

    /**
     * @return the earlierMemberOfPScheme
     */
    public boolean isEarlierMemberOfPScheme() {
        return earlierMemberOfPScheme;
    }

    /**
     * @param earlierMemberOfPScheme the earlierMemberOfPScheme to set
     */
    public void setEarlierMemberOfPScheme(boolean earlierMemberOfPScheme) {
        this.earlierMemberOfPScheme = earlierMemberOfPScheme;
    }

    /**
     * @return the previousEmployment
     */
    public PreviousEmployment getPreviousEmployment() {
        return previousEmployment;
    }

    /**
     * @param previousEmployment the previousEmployment to set
     */
    public void setPreviousEmployment(PreviousEmployment previousEmployment) {
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
