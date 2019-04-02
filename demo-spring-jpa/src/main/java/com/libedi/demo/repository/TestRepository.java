/*
 * Copyright (c) 2019 LINE Corporation. All rights reserved.
 * LINE Corporation PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
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
