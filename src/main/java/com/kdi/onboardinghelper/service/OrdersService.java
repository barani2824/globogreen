package com.kdi.onboardinghelper.service;

import com.kdi.onboardinghelper.config.Constants;
import com.kdi.onboardinghelper.domain.Authority;
import com.kdi.onboardinghelper.domain.PersonalDetails;
import com.kdi.onboardinghelper.domain.User;
import com.kdi.onboardinghelper.model.Orders;
import com.kdi.onboardinghelper.repository.AuthorityRepository;
import com.kdi.onboardinghelper.repository.OrdersRepository;
import com.kdi.onboardinghelper.repository.PersonalDetailsRepository;
import com.kdi.onboardinghelper.repository.UserRepository;
import com.kdi.onboardinghelper.security.AuthoritiesConstants;
import com.kdi.onboardinghelper.security.SecurityUtils;
import com.kdi.onboardinghelper.service.dto.UserDTO;

import io.github.jhipster.security.RandomUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Service class for managing users.
 */
@Service
@Transactional
public class OrdersService {

    private final Logger log = LoggerFactory.getLogger(OrdersService.class);

    private final OrdersRepository orderRepository;
    
   

    public OrdersService(OrdersRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Orders saveDetails(Orders o){
     return   this.orderRepository.save(o);
    }

    
     @Transactional(readOnly = true)
    public Page<Orders> getAllOrders(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }
}

  

   
    
  

   
