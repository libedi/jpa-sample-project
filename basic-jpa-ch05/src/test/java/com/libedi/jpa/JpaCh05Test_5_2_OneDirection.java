/*
 * Copyright (c) 2019 LINE Corporation. All rights reserved.
 * LINE Corporation PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.libedi.jpa;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runners.MethodSorters;
import org.junit.runners.model.Statement;

import com.libedi.jpa.entity.Member;
import com.libedi.jpa.entity.Team;

/**
 * JpaCh05Test_5_2_OneDirection : 단방향 연관관계
 *
 * @author Sang-jun, Park (libedi@linecorp.com)
 * @since 2019. 03. 29
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JpaCh05Test_5_2_OneDirection {

    private EntityManagerFactory emf;
    private EntityManager em;

    // 순수한 객체 연관관계
//    @Test
    public void test_5_1_1_ObjectRelation() {
        /*
         * 객체 연관관계 vs 테이블 연관관계 정리
         *
         * - 객체는 참조(주소)로 연관관계를 맺는다.
         * - 테이블은 외래키로 연관관계를 맺는다.
         * - 참조를 사용하는 객체의 연관관계는 언제나 단방향.
         * - 외래키를 사용하는 테이블의 연관관계는 양방향.
         * - 객체를 양방향으로 참조하려면 단방향 연관관계를 2개 만들어야 한다.
         * A -> B (a.b)
         * B -> A (b.a)
         */
        Member member1 = new Member("member1", "회원1");
        Member member2 = new Member("member2", "회원2");
        Team team1 = new Team("team1", "팀1");

        member1.setTeam(team1);
        member2.setTeam(team1);

        Team findTeam = member1.getTeam();
    }

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

    // 연관관계를 매핑한 엔티티 저장
//    @Test
    public void test_5_2_1_save() {
        // 팀1 저장
        Team team1 = new Team("team1", "팀1");
        em.persist(team1);

        // 회원1 저장
        Member member1 = new Member("member1", "회원1");
        em.persist(member1);
        member1.setTeam(team1);

        // 회원2 저장
        Member member2 = new Member("member2", "회원2");
        member2.setTeam(team1);
        em.persist(member2);
    }

    // 연관관계가 있는 엔티티 조회 방법 : 객체 그래프 탐색
    @Test
    public void test_5_2_2_findByObjectGraph() {
        test_5_2_1_save();

        Member member = em.find(Member.class, "member1");
        Team team = member.getTeam();

        assertThat(member).isNotNull();
        assertThat(team).isNotNull();
        assertThat(team.getName()).isNotBlank().isEqualTo("팀1");

        System.out.println(team.getName());
    }

    // 연관관계가 있는 엔티티 조회 방법 : JPQL
    @Test
    public void test_5_2_2_findByJPQL() {
        test_5_2_1_save();

        String jpql = "select m from Member m join m.team t where t.name=:teamName";
        List<Member> resultList = em.createQuery(jpql, Member.class)
                .setParameter("teamName", "팀1")
                .getResultList();

        assertThat(resultList).isNotEmpty();

        resultList.forEach(m -> System.out.println("[query] member.username=" + m.getUsername()));
    }

    // 연관관계 수정
    @Test
    public void test_5_2_3_update() {
        test_5_2_1_save();

        // 새로운 팀2
        Team team2 = new Team("team2", "팀2");
        em.persist(team2);

        // 회원1에 새로운팀 2 설정
        Member member1 = em.find(Member.class, "member1");
        member1.setTeam(team2);
    }

    // 연관관계 제거
    @Test
    public void test_5_2_4_deleateRelation() {
        test_5_2_1_save();

        Member member1 = em.find(Member.class, "member1");
        member1.setTeam(null);
    }

    // 연관된 엔티티 삭제
    @Test
    public void test_5_2_5_deleteEntity() {
        /*
         * 연관된 엔티티를 삭제하려면 기존의 연관관계를 제거하고 삭제해야 한다.
         * 그렇지 않으면 키 제약조건에 의해 DB오류가 발생.
         */
        test_5_2_1_save();

        Member member1 = em.find(Member.class, "member1");
        Member member2 = em.find(Member.class, "member2");
        Team team1 = em.find(Team.class, "team1");
        member1.setTeam(null);
        member2.setTeam(null);
        em.remove(team1);
    }

}
