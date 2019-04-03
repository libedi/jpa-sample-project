/*
 * Copyright (c) 2019 LINE Corporation. All rights reserved.
 * LINE Corporation PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.libedi.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.libedi.demo.domain.TestEntity;
import com.libedi.demo.dto.TestDto;
import com.libedi.demo.repository.TestRepository;
import com.libedi.demo.transform.TestTransformer;

import lombok.RequiredArgsConstructor;

/**
 * TestService
 *
 * @author Sang-jun, Park (libedi@linecorp.com)
 * @since 2019. 04. 02
 */
@Service
@RequiredArgsConstructor
public class TestService {

    private final TestRepository testRepository;

    @Transactional
    public void save(TestDto dto) {
        TestEntity entity = TestTransformer.transform(dto);
        testRepository.save(entity);
    }

    /**
     * @param id
     * @return
     */
    public TestDto getTestEntity(long id) {
        return testRepository.findById(id).map(TestTransformer::transform).get();
    }

    /**
     * @param id
     */
    @Transactional
    public void delete(long id) {
        testRepository.findById(id).ifPresent(testRepository::delete);
    }
}
