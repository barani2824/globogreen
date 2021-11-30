/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdi.onboardinghelper.repository;

import com.kdi.onboardinghelper.model.Address;
import com.kdi.onboardinghelper.model.Dependent;
import com.kdi.onboardinghelper.model.EmergencyContact;
import com.kdi.onboardinghelper.model.Employee;
import com.kdi.onboardinghelper.model.Nominee;
import com.kdi.onboardinghelper.model.NomineeType;
import com.kdi.onboardinghelper.model.Phone;
import com.kdi.onboardinghelper.model.ProvidentFund;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author subasb
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    public Employee findByEmail(String email);

    @Query("SELECT new com.kdi.onboardinghelper.model.Employee(e.id) FROM Employee e where e.email = ?1")
    public Employee getEmployeeByEmail(String email);

    @Query("SELECT new com.kdi.onboardinghelper.model.Phone(p.id) FROM Employee e JOIN e.phones p where e.id = ?1")
    public List<Phone> getPhonesById(Long id);

    @Query("SELECT new com.kdi.onboardinghelper.model.Address(e.presentAddress.id) FROM Employee e where e.id = ?1")
    public Address getPresentAddressById(Long id);

    @Query("SELECT new com.kdi.onboardinghelper.model.Address(e.postalAddress.id) FROM Employee e where e.id = ?1")
    public Address getPostalAddressById(Long id);

    @Query("SELECT new com.kdi.onboardinghelper.model.Address(e.permanentAddress.id) FROM Employee e where e.id = ?1")
    public Address getPermanentAddressById(Long id);

    @Query("SELECT new com.kdi.onboardinghelper.model.ProvidentFund(e.providentFund.id) FROM Employee e where e.id = ?1")
    public ProvidentFund getProvidentFundById(Long id);

    @Query("SELECT new com.kdi.onboardinghelper.model.Dependent(d.dependentId) FROM Employee e JOIN e.dependents d where e.id = ?1")
    public List<Dependent> getDependentsById(Long id);

    @Query("SELECT new com.kdi.onboardinghelper.model.EmergencyContact(ec.emergencyContactId) FROM Employee e JOIN e.emergencyContacts ec where e.id = ?1")
    public List<EmergencyContact> getEmergencyContactsById(Long id);

    @Query("SELECT new com.kdi.onboardinghelper.model.Nominee(n.id) FROM Employee e JOIN e.nominees n where e.id = ?1 AND n.nomineeType = ?2")
    public List<Nominee> getNomineesById(Long id, NomineeType nomineeType);
}
