/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdi.onboardinghelper.web.rest;

import com.kdi.onboardinghelper.domain.PersonalDetails;
import com.kdi.onboardinghelper.model.Orders;
import com.kdi.onboardinghelper.service.OrdersService;
import com.kdi.onboardinghelper.service.PdfService;
import com.kdi.onboardinghelper.service.dto.UserDTO;
import io.github.jhipster.web.util.PaginationUtil;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import static java.lang.Math.log;
import java.util.List;
import javax.validation.Valid;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author subasb
 */
@RestController
@RequestMapping("/api/orders")
public class OrdersController {
   private final Logger log = LoggerFactory.getLogger(OrdersController.class);
    @Autowired
    private OrdersService ordersService;

    
    @PostMapping()
    public ResponseEntity<Orders> persistUser(@Valid @RequestBody Orders userDTO) {
        log.debug("REST request to update User : {}", userDTO);
        Orders existingUser;
        existingUser = ordersService.saveDetails(userDTO);
        return new ResponseEntity<>(existingUser, HttpStatus.OK);
    }
    
    @GetMapping()
    public ResponseEntity<List<Orders>> getAllOrders(Pageable pageable) {
        final Page<Orders> page = ordersService.getAllOrders(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

  }
