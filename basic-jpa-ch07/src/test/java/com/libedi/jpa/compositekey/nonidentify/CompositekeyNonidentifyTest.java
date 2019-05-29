package com.libedi.jpa.compositekey.nonidentify;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runners.MethodSorters;
import org.junit.runners.model.Statement;

/**
 * CompositekeyNonidentifyTest
 *
 * @author Sang-jun, Park
 * @since 2019. 05. 29
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CompositekeyNonidentifyTest {

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

    @Before
    public void init1_IdClass() {
        Parent_IdClass_Nonidentify parent = new Parent_IdClass_Nonidentify();
        parent.setId1("myId1"); // 식별자
        parent.setId2("myId2"); // 식별자
        parent.setName("parentName");
        em.persist(parent);
        /*
         * 저장코드를 보면 식별자 클래스 ParentId 가 보이지 않는데,
         * 엔티티 등록 직전, 영속성 컨텍스트 내부에서 Parent.id1, Parent.id2를 사용해서
         * ParentId를 생성하고 영속성 컨텍스트 키로 사용한다.
         */

        em.flush();
        em.clear();
    }

    @Test
    public void test1_IdClass() {
        ParentId_IdClass_Nonidentify parentId = new ParentId_IdClass_Nonidentify("myId1", "myId2");
        Parent_IdClass_Nonidentify parent = em.find(Parent_IdClass_Nonidentify.class, parentId);

        assertThat(parent).isNotNull();
    }

    @Before
    public void init2_EmbeddedId() {
        Parent_EmbeddedId_Nonidentify parent = new Parent_EmbeddedId_Nonidentify();
        ParentId_EmbeddedId_Nonidentify parentId = new ParentId_EmbeddedId_Nonidentify("myId1", "myId2");
        parent.setId(parentId);
        parent.setName("parentName");
        em.persist(parent);
        /*
         * 저장코드를 보면 식별자 클래스 ParentId를 직접 생성해서 사용한다.
         */

        em.flush();
        em.clear();
    }

    @Test
    public void test2_EmbeddedId() {
        ParentId_EmbeddedId_Nonidentify parentId = new ParentId_EmbeddedId_Nonidentify("myId1", "myId2");
        Parent_EmbeddedId_Nonidentify parent = em.find(Parent_EmbeddedId_Nonidentify.class, parentId);

        assertThat(parent).isNotNull();
    }

}
