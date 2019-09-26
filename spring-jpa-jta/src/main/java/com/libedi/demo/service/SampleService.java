package com.libedi.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.libedi.demo.domain.customer.Customer;
import com.libedi.demo.domain.order.Order;
import com.libedi.demo.repository.customer.CustomerRepository;
import com.libedi.demo.repository.order.OrderRepository;

import lombok.RequiredArgsConstructor;

/**
 * SampleService
 *
 * @author Sang-jun, Park
 * @since 2019. 09. 10
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SampleService {

    private final CustomerRepository customerRepository;

    private final OrderRepository orderRepository;

    public Customer findOneCustomer() {
        return customerRepository.findAll().stream().findFirst().orElse(null);
    }

    public Order findOneOrder() {
        return orderRepository.findAll().stream().findFirst().orElse(null);
    }

    @Transactional
    public void allCommit() {
        customerRepository.save(Customer.builder().name("customer1").build());
        orderRepository.save(Order.builder().count(1).amount(1000L).build());
    }

    @Transactional
    public void allRollback() {
        customerRepository.save(Customer.builder().name("customer1").build());
        orderRepository.save(Order.builder().count(1).amount(1000L).build());
        throw new RuntimeException();
    }

    @Transactional
    public void orderRollback(boolean isRollback) {
        orderRepository.save(Order.builder().count(1).amount(1000L).build());
        if(isRollback) {
            throw new RuntimeException();
        }
        customerRepository.save(Customer.builder().name("customer1").build());
    }

    @Transactional
    public void customerRollback(boolean isRollback) {
        customerRepository.save(Customer.builder().name("customer1").build());
        if(isRollback) {
            throw new RuntimeException();
        }
        orderRepository.save(Order.builder().count(1).amount(1000L).build());
    }

}
