/*
 * Copyright (c) 2019 LINE Corporation. All rights reserved.
 * LINE Corporation PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.libedi.demo.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.libedi.demo.domain.TestEnum;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TestDto
 *
 * @author Sang-jun, Park (libedi@linecorp.com)
 * @since 2019. 04. 02
 */
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(value = Include.NON_NULL)
public class TestDto {

    private Long id;
    private String name;
    private Set<TestEnum> enums;

    @Builder
    public TestDto(Long id, String name, Set<TestEnum> enums) {
        this.id = id;
        this.name = name;
        this.enums = enums;
    }

}