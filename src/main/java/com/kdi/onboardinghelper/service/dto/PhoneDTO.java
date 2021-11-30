/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdi.onboardinghelper.service.dto;

import com.kdi.onboardinghelper.model.PhoneType;

public class PhoneDTO {

    private PhoneType phoneType;
    private String number;

    public PhoneDTO(PhoneType phoneType, String number) {
        this.phoneType = phoneType;
        this.number = number;
    }
    
    public PhoneDTO() {}

    /**
     * @return the phoneType
     */
    public PhoneType getPhoneType() {
        return phoneType;
    }

    /**
     * @param phoneType the phoneType to set
     */
    public void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
    }

    /**
     * @return the number
     */
    public String getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(String number) {
        this.number = number;
    }
}
