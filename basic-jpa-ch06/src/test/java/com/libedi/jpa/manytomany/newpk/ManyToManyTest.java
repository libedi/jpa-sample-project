package com.libedi.jpa.manytomany.newpk;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import java.util.Date;

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
 * @since 2019. 05. 16
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

    public void initSave() {
        // 회원 저장
        Member member1 = new Member();
        member1.setId("member1");
        member1.setUsername("회원1");
        em.persist(member1);

        // 상품 저장
        Product productA = new Product();
        productA.setId("productA");
        productA.setName("상품A");
        em.persist(productA);

        // 주문 저장
        Orders orders = new Orders();
        orders.setMember(member1);
        orders.setProduct(productA);
        orders.setOrderAmount(3L);
        orders.setOrderDate(new Date());
        em.persist(orders);

        em.flush();
        em.clear();
    }

    @Test
    public void test_find() {
        initSave();

        Long orderId = 1L;
        Orders orders = em.find(Orders.class, orderId);

        Member member = orders.getMember();
        Product product = orders.getProduct();

        assertThat(member).isNotNull();
        assertThat(product).isNotNull();

        System.out.println("member = " + member.getUsername());
        System.out.println("product = " + product.getName());
        System.out.println("orderAmount = " + orders.getOrderAmount());

        // 식별자 클래스를 사용하지 않아서 코드가 한결 단순해졌다.
    }

}
