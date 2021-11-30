/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdi.onboardinghelper.model;

import java.io.Serializable;

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
@Table(name = "jhi_emergency_contact")
public class EmergencyContact implements Serializable {

    /**
     *
     */
    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emergencyContactId;
    private String name;
    private String address;
    private String relationshipWithYou;
    private String phone;

    public EmergencyContact(Long id) {
        emergencyContactId = id;
    }

    public EmergencyContact() {

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
     * @return the emergencyContactId
     */
    public Long getEmergencyContactId() {
        return emergencyContactId;
    }

    /**
     * @param emergencyContactId the emergencyContactId to set
     */
    public void setEmergencyContactId(Long emergencyContactId) {
        this.emergencyContactId = emergencyContactId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the relationshipWithYou
     */
    public String getRelationshipWithYou() {
        return relationshipWithYou;
    }

    /**
     * @param relationshipWithYou the relationshipWithYou to set
     */
    public void setRelationshipWithYou(String relationshipWithYou) {
        this.relationshipWithYou = relationshipWithYou;
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
}
