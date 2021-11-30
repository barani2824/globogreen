/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdi.onboardinghelper.service.dto;

import java.sql.Date;
import java.util.List;

public class FormIDTO {

    private String firstname;
    private String lastname;
    private AddressDTO presentAddress;
    private AddressDTO permanentAddress;
    private Date dateOfBirth;
    private String gender;
    private String maritalStatus;
    private String religion;
    private String department;
    private String ticketNumber;
    private Date dateOfAppointment;
    private List<NomineeIDTO> nominees;
    
    
    public FormIDTO(String firstname, String lastname, AddressDTO presentAddress, AddressDTO permanentAddress, Date dateOfBirth, String gender, String maritalStatus, String religion, String department, String ticketNumber, Date dateOfAppointment, List<NomineeIDTO> nominees) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.presentAddress = presentAddress;
        this.permanentAddress = permanentAddress;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.religion = religion;
        this.department = department;
        this.ticketNumber = ticketNumber;
        this.dateOfAppointment = dateOfAppointment;
        this.nominees = nominees;
    }
    
    public FormIDTO(){}

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
     * @return the nominees
     */
    public List<NomineeIDTO> getNominees() {
        return nominees;
    }

    /**
     * @param nominees the nominees to set
     */
    public void setNominees(List<NomineeIDTO> nominees) {
        this.nominees = nominees;
    }
}
