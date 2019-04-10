package com.libedi.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libedi.demo.domain.TestEntity;

/**
 * TestRepository
 *
 * @author Sang-jun, Park (libedi@linecorp.com)
 * @since 2019. 04. 02
 */
public interface TestRepository extends JpaRepository<TestEntity, Long> {

}
