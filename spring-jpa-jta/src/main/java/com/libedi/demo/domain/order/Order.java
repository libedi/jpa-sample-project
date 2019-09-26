package com.libedi.demo.domain.order;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.libedi.demo.domain.common.BaseAuditEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Order
 *
 * @author Sang-jun, Park
 * @since 2019. 09. 10
 */
@Entity
@Table(name = "order_test")
@Getter
@Setter
public class Order extends BaseAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    private Integer count;

    private Long amount;

    @Builder
    private Order(Integer count, Long amount) {
        this.count = count;
        this.amount = amount;
    }

}
