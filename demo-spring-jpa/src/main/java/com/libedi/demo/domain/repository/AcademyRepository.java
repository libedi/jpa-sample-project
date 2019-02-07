package com.libedi.demo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libedi.demo.domain.Academy;

/**
 * AcademyRepository
 *
 * @author Sang-jun, Park
 * @since 2019. 02. 07
 */
public interface AcademyRepository extends JpaRepository<Academy, Long> {

}
