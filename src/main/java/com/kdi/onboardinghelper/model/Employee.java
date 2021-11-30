/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdi.onboardinghelper.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author subasb
 */
@Entity
@Table(name = "jhi_employee")
public class Employee implements Serializable {

    /**
     *
     */
    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String firstname;
    private String lastname;
    private String employeeCode;
    private String department;
    private String designation;
    private String natureOfWorkEntrusted;
    private String serialNumber;
    private Date dateOfAppointment;
    private Date dateOfBirth;
    private String gender;
    private String bloodGroup;
    private String maritalStatus;
    private String nationality;
    private String religion;
    private String placeOfBirth;
    private String email;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(targetEntity = Phone.class, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private List<Phone> phones;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "present_address_id")
    private Address presentAddress;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "postal_address_id")
    private Address postalAddress;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "permanent_address_id")
    private Address permanentAddress;
    private String aadharNumber;
    private String panNumber;
    private String passportNumber;
    private String placeOfPassportIssue;
    private Date dateOfIssue;
    private Date dateOfExpiry;
    private String ticketNumber;
    private Date excludingHusbandDate;
    private String postOffice;
    private String district;
    private String state;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pf_id")
    private ProvidentFund providentFund;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(targetEntity = Dependent.class, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private List<Dependent> dependents;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(targetEntity = EmergencyContact.class, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private List<EmergencyContact> emergencyContacts;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(targetEntity = Nominee.class, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private List<Nominee> nominees;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(columnDefinition = "mediumtext")
    private String photo;

    public Employee(Long id) {
        this.id = id;
    }

    public Employee() {
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
     * @return the phones
     */
    public List<Phone> getPhones() {
        return phones;
    }

    /**
     * @param phones the phones to set
     */
    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    /**
     * @return the presentAddress
     */
    public Address getPresentAddress() {
        return presentAddress;
    }

    /**
     * @param presentAddress the presentAddress to set
     */
    public void setPresentAddress(Address presentAddress) {
        this.presentAddress = presentAddress;
    }

    /**
     * @return the postalAddress
     */
    public Address getPostalAddress() {
        return postalAddress;
    }

    /**
     * @param postalAddress the postalAddress to set
     */
    public void setPostalAddress(Address postalAddress) {
        this.postalAddress = postalAddress;
    }

    /**
     * @return the permanentAddress
     */
    public Address getPermanentAddress() {
        return permanentAddress;
    }

    /**
     * @param permanentAddress the permanentAddress to set
     */
    public void setPermanentAddress(Address permanentAddress) {
        this.permanentAddress = permanentAddress;
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
     * @return the providentFund
     */
    public ProvidentFund getProvidentFund() {
        return providentFund;
    }

    /**
     * @param providentFund the providentFund to set
     */
    public void setProvidentFund(ProvidentFund providentFund) {
        this.providentFund = providentFund;
    }

    /**
     * @return the dependents
     */
    public List<Dependent> getDependents() {
        return dependents;
    }

    /**
     * @param dependents the dependents to set
     */
    public void setDependents(List<Dependent> dependents) {
        this.dependents = dependents;
    }

    /**
     * @return the emergencyContacts
     */
    public List<EmergencyContact> getEmergencyContacts() {
        return emergencyContacts;
    }

    /**
     * @param emergencyContacts the emergencyContacts to set
     */
    public void setEmergencyContacts(List<EmergencyContact> emergencyContacts) {
        this.emergencyContacts = emergencyContacts;
    }

    /**
     * @return the nominees
     */
    public List<Nominee> getNominees() {
        return nominees;
    }

    /**
     * @param nominees the nominees to set
     */
    public void setNominees(List<Nominee> nominees) {
        this.nominees = nominees;
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
