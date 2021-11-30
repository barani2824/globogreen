/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdi.onboardinghelper.service.dto;

public class NomineeIDTO {

    private String name;
    private String address;
    private String relationshipWithYou;
    private int age;
    
    
    public NomineeIDTO(String name, String address, String relationshipWithYou, int age) {
        this.name = name;
        this.address = address;
        this.relationshipWithYou = relationshipWithYou;
        this.age = age;
    }
    
    public NomineeIDTO() {}

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
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }
}
