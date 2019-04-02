/*
 * Copyright (c) 2019 LINE Corporation. All rights reserved.
 * LINE Corporation PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.libedi.demo.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * TestEntity
 *
 * @author Sang-jun, Park (libedi@linecorp.com)
 * @since 2019. 04. 02
 */
@Entity
@Table(name = "test_entity")
@Getter @Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_id")
    private Long id;

    private String name;

    @ElementCollection
    @CollectionTable(name = "test_enum", joinColumns = @JoinColumn(name = "test_id"))
    @Column(name = "enum_name")
    @Enumerated(EnumType.STRING)
    private final Set<TestEnum> enums = new HashSet<>();

    @Builder
    public TestEntity(String name, Set<TestEnum> enums) {
        this.name = name;
        enums.forEach(this.enums::add);
    }

}
