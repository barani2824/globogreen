/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdi.onboardinghelper.service.dto;

import java.sql.Date;
import java.util.List;

public class FormFDTO {

    private String firstname;
    private String lastname;
    private AddressDTO permanentAddress;
    private Date dateOfBirth;
    private String gender;
    private String maritalStatus;
    private Date excludingHusbandDate;
    private String religion;
    private String department;
    private String ticketNumber;
    private Date dateOfAppointment;
    private String postOffice;
    private String district;
    private String state;
    private List<NomineeFDTO> nominees;
    
    public FormFDTO(String firstname, String lastname, AddressDTO permanentAddress, Date dateOfBirth, String gender, String maritalStatus, Date excludingHusbandDate, String religion, String department, String ticketNumber, Date dateOfAppointment, String postOffice, String district, String state, List<NomineeFDTO> nominees) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.permanentAddress = permanentAddress;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.excludingHusbandDate = excludingHusbandDate;
        this.religion = religion;
        this.department = department;
        this.ticketNumber = ticketNumber;
        this.dateOfAppointment = dateOfAppointment;
        this.postOffice = postOffice;
        this.district = district;
        this.state = state;
        this.nominees = nominees;
    }
    
    public FormFDTO() {}

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
     * @return the excludingHusbandDate
     */
    public Date getExcludingHusbandDate() {
        return excludingHusbandDate;
    }

    /**
     * @param excludingHusbandDate the excludingHusbandDate to set
     */
    public void setExcludingHusbandDate(Date excludingHusbandDate) {
        this.excludingHusbandDate = excludingHusbandDate;
    }

    /**
     * @return the religion
     */
    public String getReligion() {
        return religion;
    }

    /**
     * @param religion the religion to set
     */
    public void setReligion(String religion) {
        this.religion = religion;
    }

    /**
     * @return the department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * @param department the department to set
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * @return the ticketNumber
     */
    public String getTicketNumber() {
        return ticketNumber;
    }

    /**
     * @param ticketNumber the ticketNumber to set
     */
    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
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
     * @return the postOffice
     */
    public String getPostOffice() {
        return postOffice;
    }

    /**
     * @param postOffice the postOffice to set
     */
    public void setPostOffice(String postOffice) {
        this.postOffice = postOffice;
    }

    /**
     * @return the district
     */
    public String getDistrict() {
        return district;
    }

    /**
     * @param district the district to set
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the nominees
     */
    public List<NomineeFDTO> getNominees() {
        return nominees;
    }

    /**
     * @param nominees the nominees to set
     */
    public void setNominees(List<NomineeFDTO> nominees) {
        this.nominees = nominees;
    }

}
