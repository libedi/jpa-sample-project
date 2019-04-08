package com.libedi.jpa.onetomany;

import static org.junit.Assert.fail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runners.model.Statement;

/**
 * OneToManyTest : 일대다 테스트
 *
 * @author Sang-jun, Park
 * @since 2019. 04. 08
 */
public class OneToManyTest {

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

    // 일대다 단방향 매핑의 단점
    @Test
    public void test_DisadvantageOneToMany() {
        Member member1 = new Member("member1");
        Member member2 = new Member("member2");

        Team team1 = new Team("team1");
        team1.getMembers().add(member1);
        team1.getMembers().add(member2);

        em.persist(member1);    // INSERT-member1 (TEAM_ID = null)
        em.persist(member2);    // INSERT-member2 (TEAM_ID = null)
        em.persist(team1);      // INSERT-team1
        // UPDATE-member1.fk, UPDATE-member2.fk

        /*
         * 단점 : INSERT 쿼리 한번에 끝날걸, UPDATE 쿼리를 추가로 실행해야 한다.
         *
         * Member 엔티티는 Team 엔티티를 몰라서 최초 INSERT시에 TEAM_ID에 아무 값도 저장이 안된다.
         * Team 엔티티를 저장한 후에야, Team.members 의 참조값을 확인해서 외래키를 업데이트 한다.
         */

        // * 결론 : 일대다 단방향 매핑 보다는 "다대일 양방향 매핑"을 사용하자!
    }
}
