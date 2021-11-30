package com.kdi.onboardinghelper.repository;

import com.kdi.onboardinghelper.domain.Authority;
import com.kdi.onboardinghelper.domain.User;
import com.kdi.onboardinghelper.model.Orders;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {

   Page<Orders> findAll(Pageable pageabl);
}
