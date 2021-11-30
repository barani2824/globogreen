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

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 *
 * @author subasb
 */
@Entity
@Table(name = "jhi_nominee")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Nominee implements Serializable {

    /**
     *
     */
    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String relationshipWithYou;
    private int age;
    private float proportion;
    private NomineeType nomineeType;

    public Nominee(Long id) {
        this.id = id;
    }

    public Nominee() {

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

    /**
     * @return the proportion
     */
    public float getProportion() {
        return proportion;
    }

    /**
     * @param proportion the proportion to set
     */
    public void setProportion(float proportion) {
        this.proportion = proportion;
    }

    /**
     * @return the nomineeType
     */
    public NomineeType getNomineeType() {
        return nomineeType;
    }

    /**
     * @param nomineeType the nomineeType to set
     */
    public void setNomineeType(NomineeType nomineeType) {
        this.nomineeType = nomineeType;
    }
}
