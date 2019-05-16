package com.libedi.jpa.manytomany.newpk;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

/**
 * Orders
 * <pre>
 * 다대다 관계에서 연결 엔티티를 사용할 시, 복합키를 사용해야 한다.
 * 이는 식별자 클래스를 만드는 등 복잡한 방법이 필요하다.
 *
 * 추천하는 기본 키 생성 전략은 연결 엔티티에 새로운 기본키를 생성하는 것이다.
 * 이는 복합키를 만들지 않아도 되므로 간단히 매핑할 수 있다.
 * </pre>
 *
 * @author Sang-jun, Park
 * @since 2019. 05. 16
 */
@Entity
@Getter @Setter
public class Orders {

    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    private Long orderAmount;

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
}
