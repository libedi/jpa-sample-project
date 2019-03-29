/*
 * Copyright (c) 2019 LINE Corporation. All rights reserved.
 * LINE Corporation PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.libedi.jpa;

import static org.assertj.core.api.Assertions.fail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.runners.MethodSorters;
import org.junit.runners.model.Statement;

/**
 * JpaCh05Test_5_3_BiDirection : 양방향 연관관계
 *
 * @author Sang-jun, Park
 * @since 2019. 03. 29
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JpaCh05Test_5_3_BiDirection {

    private EntityManagerFactory emf;
    private EntityManager em;

    @Rule
    public TestRule rule = (base, description) -> new Statement() {
        @Override
        public void evaluate() throws Throwable {
            emf = Persistence.createEntityManagerFactory("jpatest");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();
                base.evaluate();
                tx.commit();
            } catch (Throwable e) {
                System.out.println("ERROR: " + e.getMessage());
                tx.rollback();
                fail(e.toString());
            } finally {
                em.close();
                emf.close();
            }
        }
    };

}
