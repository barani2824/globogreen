/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdi.onboardinghelper.repository;

import com.kdi.onboardinghelper.model.PreviousEmployment;
import com.kdi.onboardinghelper.model.ProvidentFund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author subasb
 */
@Repository
public interface ProvidentFundRepository extends JpaRepository<ProvidentFund, Long> {

    @Query("SELECT NEW com.kdi.onboardinghelper.model.PreviousEmployment(pf.previousEmployment.id) FROM ProvidentFund pf where pf.id = ?1")
    public PreviousEmployment getPreviousEmploymentById(Long id);
}
