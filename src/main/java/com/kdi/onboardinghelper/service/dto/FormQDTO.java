/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdi.onboardinghelper.service.dto;

import java.sql.Date;

public class FormQDTO {

    private String nameOfEstablishment;
    private String addressOfEstablishment;
    private String nameOfEmployer;
    private String addressOfEmployer;
    private String fullname;
    private Date dateOfBirth;
    private AddressDTO postalAddress;
    private AddressDTO permanentAddress;
    private String fatherOrSpouseName;
    private Date dateOfAppointment;
    private String designation;
    private String natureOfWorkEntrusted;
    private String serialNumber;
    
    
    public FormQDTO(String nameOfEstablishment, String addressOfEstablishment, String nameOfEmployer, String addressOfEmployer, String fullname, Date dateOfBirth, AddressDTO postalAddress, AddressDTO permanentAddress, String fatherOrSpouseName, Date dateOfAppointment, String designation, String natureOfWorkEntrusted, String serialNumber) {
        this.nameOfEstablishment = nameOfEstablishment;
        this.addressOfEstablishment = addressOfEstablishment;
        this.nameOfEmployer = nameOfEmployer;
        this.addressOfEmployer = addressOfEmployer;
        this.fullname = fullname;
        this.dateOfBirth = dateOfBirth;
        this.postalAddress = postalAddress;
        this.permanentAddress = permanentAddress;
        this.fatherOrSpouseName = fatherOrSpouseName;
        this.dateOfAppointment = dateOfAppointment;
        this.designation = designation;
        this.natureOfWorkEntrusted = natureOfWorkEntrusted;
        this.serialNumber = serialNumber;
    }
    
    public FormQDTO() {}

    /**
     * @return the nameOfEstablishment
     */
    public String getNameOfEstablishment() {
        return nameOfEstablishment;
    }

    /**
     * @param nameOfEstablishment the nameOfEstablishment to set
     */
    public void setNameOfEstablishment(String nameOfEstablishment) {
        this.nameOfEstablishment = nameOfEstablishment;
    }

    /**
     * @return the addressOfEstablishment
     */
    public String getAddressOfEstablishment() {
        return addressOfEstablishment;
    }

    /**
     * @param addressOfEstablishment the addressOfEstablishment to set
     */
    public void setAddressOfEstablishment(String addressOfEstablishment) {
        this.addressOfEstablishment = addressOfEstablishment;
    }

    /**
     * @return the nameOfEmployer
     */
    public String getNameOfEmployer() {
        return nameOfEmployer;
    }

    /**
     * @param nameOfEmployer the nameOfEmployer to set
     */
    public void setNameOfEmployer(String nameOfEmployer) {
        this.nameOfEmployer = nameOfEmployer;
    }

    /**
     * @return the addressOfEmployer
     */
    public String getAddressOfEmployer() {
        return addressOfEmployer;
    }

    /**
     * @param addressOfEmployer the addressOfEmployer to set
     */
    public void setAddressOfEmployer(String addressOfEmployer) {
        this.addressOfEmployer = addressOfEmployer;
    }

    /**
     * @return the fullname
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * @param fullname the fullname to set
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
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
     * @return the postalAddress
     */
    public AddressDTO getPostalAddress() {
        return postalAddress;
    }

    /**
     * @param postalAddress the postalAddress to set
     */
    public void setPostalAddress(AddressDTO postalAddress) {
        this.postalAddress = postalAddress;
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
     * @return the dateOfAppointment
     */
    public Date getDateOfAppointment() {
        return dateOfAppointment;
    }

    /**
     * @param dateOfAppointment the dateOfAppointment to set
     */
    public void setDateOfAppointment(Date dateOfAppointment) {
        this.dateOfAppointment = dateOfAppointment;
    }

    /**
     * @return the designation
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * @param designation the designation to set
     */
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    /**
     * @return the natureOfWorkEntrusted
     */
    public String getNatureOfWorkEntrusted() {
        return natureOfWorkEntrusted;
    }

    /**
     * @param natureOfWorkEntrusted the natureOfWorkEntrusted to set
     */
    public void setNatureOfWorkEntrusted(String natureOfWorkEntrusted) {
        this.natureOfWorkEntrusted = natureOfWorkEntrusted;
    }

    /**
     * @return the serialNumber
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * @param serialNumber the serialNumber to set
     */
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}
