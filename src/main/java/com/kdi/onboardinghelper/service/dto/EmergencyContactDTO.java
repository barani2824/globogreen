/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdi.onboardinghelper.service.dto;

public class EmergencyContactDTO {

    private String name;
    private String address;
    private String relationshipWithYou;
    private String phone;

    public EmergencyContactDTO(String name, String address, String relationshipWithYou, String phone) {
        this.name = name;
        this.address = address;
        this.relationshipWithYou = relationshipWithYou;
        this.phone = phone;
    }
    
    public EmergencyContactDTO() {}

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
