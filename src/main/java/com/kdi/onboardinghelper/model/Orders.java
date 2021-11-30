/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdi.onboardinghelper.model;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

/**
 *
 * @author baranitharan
 */
@Entity
@Table(name = "jhi_orders")
public class Orders implements Serializable {

    /**
     *
     */
    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerEmail;
    private String customerMobileNumber;
    private String customerName;
    private String estimatedCost;
    private String mobileBrand;
    private String mobileModel;
    private String orderStatus;
    private String repairDetails;
    private Date estimatedDeliveryTime;
    private boolean hasDisplayScratch;

    public Orders(Long id) {
        this.setId(id);
    }

    public Orders() {

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
     * @return the customerEmail
     */
    public String getCustomerEmail() {
        return customerEmail;
    }

    /**
     * @param customerEmail the customerEmail to set
     */
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    /**
     * @return the customerMobileNumber
     */
    public String getCustomerMobileNumber() {
        return customerMobileNumber;
    }

    /**
     * @param customerMobileNumber the customerMobileNumber to set
     */
    public void setCustomerMobileNumber(String customerMobileNumber) {
        this.customerMobileNumber = customerMobileNumber;
    }

    /**
     * @return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName the customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * @return the estimatedCost
     */
    public String getEstimatedCost() {
        return estimatedCost;
    }

    /**
     * @param estimatedCost the estimatedCost to set
     */
    public void setEstimatedCost(String estimatedCost) {
        this.estimatedCost = estimatedCost;
    }

    /**
     * @return the mobileBrand
     */
    public String getMobileBrand() {
        return mobileBrand;
    }

    /**
     * @param mobileBrand the mobileBrand to set
     */
    public void setMobileBrand(String mobileBrand) {
        this.mobileBrand = mobileBrand;
    }

    /**
     * @return the mobileModel
     */
    public String getMobileModel() {
        return mobileModel;
    }

    /**
     * @param mobileModel the mobileModel to set
     */
    public void setMobileModel(String mobileModel) {
        this.mobileModel = mobileModel;
    }

    /**
     * @return the orderStatus
     */
    public String getOrderStatus() {
        return orderStatus;
    }

    /**
     * @param orderStatus the orderStatus to set
     */
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * @return the repairDetails
     */
    public String getRepairDetails() {
        return repairDetails;
    }

    /**
     * @param repairDetails the repairDetails to set
     */
    public void setRepairDetails(String repairDetails) {
        this.repairDetails = repairDetails;
    }

    /**
     * @return the estimatedDeliveryTime
     */
    public Date getEstimatedDeliveryTime() {
        return estimatedDeliveryTime;
    }

    /**
     * @param estimatedDeliveryTime the estimatedDeliveryTime to set
     */
    public void setEstimatedDeliveryTime(Date estimatedDeliveryTime) {
        this.estimatedDeliveryTime = estimatedDeliveryTime;
    }

    /**
     * @return the hasDisplayScratch
     */
    public boolean isHasDisplayScratch() {
        return hasDisplayScratch;
    }

    /**
     * @param hasDisplayScratch the hasDisplayScratch to set
     */
    public void setHasDisplayScratch(boolean hasDisplayScratch) {
        this.hasDisplayScratch = hasDisplayScratch;
    }

}
