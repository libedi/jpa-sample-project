package com.libedi.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.libedi.demo.domain.customer.Customer;
import com.libedi.demo.domain.order.Order;

/**
 * SampleServiceTest
 *
 * @author Sang-jun, Park
 * @since 2019. 09. 26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
//@Transactional    // INSERT와 SELECT의 트랜잭션 분리를 위해 주석처리
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SampleServiceTest {

    @Autowired
    private SampleService service;

    @Test
    public void test01_allRollback() {
        // given
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> service.allRollback());

        // when
        Customer customer = service.findOneCustomer();
        Order order = service.findOneOrder();

        // then
        assertThat(customer).isNull();
        assertThat(order).isNull();
    }

    @Test
    public void test02_orderRollback() {
        // given
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> service.orderRollback(true));

        // when
        Customer customer = service.findOneCustomer();
        Order order = service.findOneOrder();

        // then
        assertThat(customer).isNull();
        assertThat(order).isNull();
    }

    @Test
    public void test03_customerRollback() {
        // given
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> service.customerRollback(true));

        // when
        Customer customer = service.findOneCustomer();
        Order order = service.findOneOrder();

        // then
        assertThat(customer).isNull();
        assertThat(order).isNull();
    }

    @Test
    public void test04_allCommit() {
        // given
        service.allCommit();

        // when
        Customer customer = service.findOneCustomer();
        Order order = service.findOneOrder();

        // then
        assertThat(customer).isNotNull();
        assertThat(order).isNotNull();
    }

}
