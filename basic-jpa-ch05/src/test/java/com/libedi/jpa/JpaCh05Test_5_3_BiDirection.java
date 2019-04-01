/*
 * Copyright (c) 2019 LINE Corporation. All rights reserved.
 * LINE Corporation PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.libedi.jpa;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

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

import com.libedi.jpa.entity.bidirect.Member;
import com.libedi.jpa.entity.bidirect.MemberRefactoring;
import com.libedi.jpa.entity.bidirect.Team;
import com.libedi.jpa.entity.bidirect.TeamRefactoring;

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
//                tx.rollback();
                fail(e.toString());
            } finally {
                em.close();
                emf.close();
            }
        }
    };

//    @Test
    public void test_1_saveEntityForTest() {
        // 팀1 저장
        Team team1 = new Team("team1", "팀1");
        em.persist(team1);

        // 회원1 저장
        Member member1 = new Member("member1", "회원1");
        member1.setTeam(team1);
        em.persist(member1);

        // 회원2 저장
        Member member2 = new Member("member2", "회원2");
        member2.setTeam(team1);
        em.persist(member2);

        em.flush();
        em.clear();
        System.out.println("=====================");
    }

    // 일대다 방향으로 객체 그래프 탐색
    @Test
    public void test_5_3_2_findByObjectGrapthToOneToMany() {
        test_1_saveEntityForTest();

        Team team = em.find(Team.class, "team1");
        assertThat(team).isNotNull();
        System.out.println(team);
        // 객체 그래프 탐색. (팀 -> 회원)
        List<Member> members = team.getMembers();
        assertThat(members).isNotEmpty();       // fail 발생!

        members.forEach(member -> System.out.println("member.username = " + member.getUsername()));
        /*
         * 본 예제에서 save()시에 em.flush()와 em.clear()를 하지 않으면, team.getMembers()는 비어있게 된다.
         * 양방향 매핑관계는 연관관계의 주인(다 인 쪽)이 설정하는데, Member에만 설정하고 Team에는 설정되어 있지 않으므로
         * 객체상으로는 team -> member로 설정이 안되어 있기 때문이다.
         * 영속성 컨텍스트에서도 마찬가지로, 1차 캐시에서는 객체간의 해당 관계가 매핑되어 있지 않기 때문이다.
         * 따라서 영속성 컨텍스트를 비워주고, DB에서 새로 연관관계를 가져와야 제대로 team.getMembers()가 조회된다.
         *
         * 이후, 객체까지 고려한 양방향 연관관계 설정이 되면 flush()와 clear()를 하지 않아도 된다.
         */
    }

    // 양방향 연관관계 주의점 : 연관관계 주인이 아닌 곳에 값을 입력하는 경우
    @Test
    public void test_5_6_0_saveNonOwner() {
        // 회원1 저장
        Member member1 = new Member("member1", "회원1");
        em.persist(member1);
        // 회원2 저장
        Member member2 = new Member("member2", "회원2");
        em.persist(member2);

        Team team1 = new Team("team1", "팀1");
        // 주인이 아닌 곳에만 연관관계 설정
        team1.getMembers().add(member1);
        team1.getMembers().add(member2);

        em.persist(team1);
        /*
         * MEMBER.TEAM_ID 에 null 값이 입력된다.
         * 중요! : 연관관계 주인만이 외래 키의 값을 변경할 수 있다!
         */
    }

    // 순수한 객체 양방향 모두 관계를 설정
    @Test
    public void test_5_6_1_1_setPureObject_Bidirection() {
        Team team1 = new Team("team1", "팀1");
        Member member1 = new Member("member1", "회원1");
        Member member2 = new Member("member2", "회원2");

        member1.setTeam(team1);             // 연관관계 설정 member1 -> team1
        team1.getMembers().add(member1);    // 연관관계 설정 team1 -> member1

        member2.setTeam(team1);             // 연관관계 설정 member2 -> team1
        team1.getMembers().add(member2);    // 연관관계 설정 team1 -> member2

        List<Member> members = team1.getMembers();
        assertThat(members).isNotEmpty();
        System.out.println("members.size = " + members.size());
    }

    // JPA 코드로 완성
    @Test
    public void test_5_6_1_2_setORM_Bidirection() {
        // 팀1 저장
        Team team1 = new Team("team1", "팀1");
        em.persist(team1);

        Member member1 = new Member("member1", "회원1");
        member1.setTeam(team1);             // 연관관계 주인
        team1.getMembers().add(member1);    // 주인이 아니다. 저장시 사용되지 않는다.
        em.persist(member1);

        Member member2 = new Member("member2", "회원2");
        member2.setTeam(team1);             // 연관관계 주인
        team1.getMembers().add(member2);    // 주인이 아니다. 저장시 사용되지 않는다.
        em.persist(member2);

        List<Member> members = em.find(Team.class, "team1").getMembers();
        assertThat(members).isNotEmpty();
        System.out.println("members.size = " + members.size());
    }

    // 양방향 리팩토링 : 연관관계 편의 메서드 사용
    @Test
    public void test_5_6_2_refactoringBidirectionForORM() {
        TeamRefactoring team1 = new TeamRefactoring("team1", "팀1");
        em.persist(team1);

        MemberRefactoring member1 = new MemberRefactoring("member1", "회원1");
        member1.setTeam(team1);
        em.persist(member1);

        MemberRefactoring member2 = new MemberRefactoring("member2", "회원2");
        member2.setTeam(team1);
        em.persist(member2);
    }

}
