/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdi.onboardinghelper.service.dto;

import java.sql.Date;

public class BasicFormDTO {

    private String firstname;
    private String lastname;
    private AddressDTO address;
    private Date dateOfBirth;
    private String employeeCode;
    private String bloodGroup;
    private String photo;
    
    public BasicFormDTO(String firstname, String lastname, AddressDTO address, Date dateOfBirth, String employeeCode, String bloodGroup, String photo) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.employeeCode = employeeCode;
        this.bloodGroup = bloodGroup;
        this.photo = photo;
    }
    
    public BasicFormDTO() {}

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
     * @return the address
     */
    public AddressDTO getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(AddressDTO address) {
        this.address = address;
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
     * @return the employeeCode
     */
    public String getEmployeeCode() {
        return employeeCode;
    }

    /**
     * @param employeeCode the employeeCode to set
     */
    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    /**
     * @return the bloodGroup
     */
    public String getBloodGroup() {
        return bloodGroup;
    }

    /**
     * @param bloodGroup the bloodGroup to set
     */
    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    /**
     * @return the photo
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * @param photo the photo to set
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
