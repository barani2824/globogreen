/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdi.onboardinghelper.repository;

import com.kdi.onboardinghelper.model.Establishment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author subasb
 */
@Repository
public interface EstablishmentRepository extends JpaRepository<Establishment, Long> {

}

