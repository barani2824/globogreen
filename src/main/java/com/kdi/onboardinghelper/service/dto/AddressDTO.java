/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdi.onboardinghelper.service.dto;

public class AddressDTO {

    private String shortAddress;
    private String pincode;

    public AddressDTO(String shortAddress, String pincode) {
        this.shortAddress = shortAddress;
        this.pincode = pincode;
    }
    
    public AddressDTO() {}

    /**
     * @return the shortAddress
     */
    public String getShortAddress() {
        return shortAddress;
    }

    /**
     * @param shortAddress the shortAddress to set
     */
    public void setShortAddress(String shortAddress) {
        this.shortAddress = shortAddress;
    }

    /**
     * @return the pincode
     */
    public String getPincode() {
        return pincode;
    }

    /**
     * @param pincode the pincode to set
     */
    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}
