/*
 * Copyright (c) 2019 LINE Corporation. All rights reserved.
 * LINE Corporation PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.libedi.demo.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.libedi.demo.domain.Child;
import com.libedi.demo.domain.Parent;

/**
 * ParentRepositoryTest - 1:1 식별관계 매핑
 *
 * @author Sang-jun, Park (libedi@linecorp.com)
 * @since 2019. 04. 19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ParentRepositoryTest {

    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private ChildRepository childRepository;

//    @Test
    @Before
    public void testChild() {
        // given
        Parent parent = parentRepository.save(Parent.builder().name("parent name").build());

        // when
        Child child = childRepository.save(Child.builder().content("child content").parent(parent).build());
        parent.setChild(child);
        // then
        assertThat(child).isNotNull();
        System.out.println(parent.toString());
        System.out.println(child.toString());

        parentRepository.flush();
        childRepository.flush();
    }

    @Test
    public void testParent() {
        // given
        long id = 1L;

        // when
        Optional<Parent> parent = parentRepository.findById(id);

        // then
        assertThat(parent.isPresent()).isTrue();
        parent.ifPresent(p -> {
            Child child = p.getChild();

            assertThat(child).isNotNull();
            System.out.println(p.toString());
        });

    }

}
