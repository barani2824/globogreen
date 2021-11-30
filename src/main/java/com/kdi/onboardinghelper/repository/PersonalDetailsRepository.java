package com.kdi.onboardinghelper.repository;

import com.kdi.onboardinghelper.domain.Authority;
import com.kdi.onboardinghelper.domain.PersonalDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */

@Repository
public interface PersonalDetailsRepository extends JpaRepository<PersonalDetails, Long> {
}
