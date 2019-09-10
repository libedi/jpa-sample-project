package com.libedi.demo.repository.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libedi.demo.domain.customer.Customer;

/**
 * CustomerRepository
 *
 * @author Sang-jun, Park
 * @since 2019. 09. 10
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
