package com.libedi.demo.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libedi.demo.domain.order.Order;

/**
 * OrderRepository
 *
 * @author Sang-jun, Park
 * @since 2019. 09. 10
 */
public interface OrderRepository extends JpaRepository<Order, Long> {

}
