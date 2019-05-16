package com.libedi.jpa.manytomany;

import static org.junit.Assert.fail;

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

/**
 * ManyToManyTest
 *
 * @author Sang-jun, Park
 * @since 2019. 05. 10
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ManyToManyTest {

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

    public void init_ManyToManyUnidirect() {
        Product productA = new Product();
        productA.setId("productA");
        productA.setName("상품A");
        em.persist(productA);

        Member member1 = new Member();
        member1.setId("member1");
        member1.setUsername("회원1");
        member1.getProducts().add(productA);    // 연관관계 설정
        em.persist(member1);
        em.flush();
        em.clear();

        // INSERT PRODUCT
        // INSERT MEMBER
        // INSERT MEMBER_PRODUCT
    }

    @Test
    public void test01_find() {
        init_ManyToManyUnidirect();

        Member member = em.find(Member.class, "member1");
        /*
         * getProducts() 실행시 아래 쿼리가 실행된다.
         *
         * SELECT * FROM MEMBER_PRODUCT MP
         * JOIN PRODUCT P ON MP.PRODUCT_ID=P.PRODUCT_ID
         * WHERE MP.MEMBER_ID=?
         *
         * 연결테이블인 MEMBER_PRODUCT 와 상품 테이블을 조인해서 관련 상품을 조회한다.
         */
        member.getProducts().forEach(product -> System.out.println("product.name = " + product.getName()));
    }

    public void init_ManyToManyBidirect() {
        Product productB = new Product();
        productB.setId("productB");
        productB.setName("상품B");
        em.persist(productB);

        Member member2 = new Member();
        member2.setId("member2");
        member2.setUsername("회원2");
        member2.addProduct(productB);    // 연관관계 설정
        em.persist(member2);
        em.flush();
        em.clear();

        // INSERT PRODUCT
        // INSERT MEMBER
        // INSERT MEMBER_PRODUCT
    }

    @Test
    public void test02_findInverse() {
        init_ManyToManyBidirect();

        Product product = em.find(Product.class, "productB");
        product.getMembers().forEach(member -> System.out.println("member = " + member.getUsername()));
    }

}
