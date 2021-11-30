/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdi.onboardinghelper.web.rest;

import com.kdi.onboardinghelper.model.Employee;
import com.kdi.onboardinghelper.repository.EmployeeRepository;
import com.kdi.onboardinghelper.service.HelperService;
import com.kdi.onboardinghelper.service.dto.CompleteFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author subasb
 */
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private HelperService helperService;

    @GetMapping("/get/{email}")
    public ResponseEntity<CompleteFormDTO> getEmployee(@PathVariable("email") String email) {
        try {
            Employee employee = employeeRepository.findByEmail(email);
            if (employee == null) {
                return ResponseEntity.badRequest().body(null);
            }
            return ResponseEntity.ok().body(helperService.getCompleteForm(employee));
        } catch (Exception e) {
           return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/save")
    public CompleteFormDTO saveEmployee(@RequestBody CompleteFormDTO completeForm) {
        Employee employee = employeeRepository.save(helperService.getEmployee(completeForm));
        return helperService.getCompleteForm(employee);
    }
}
