package com.libedi.jpa.manytomany.joinentity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

/**
 * MemberProduct
 *
 * @author Sang-jun, Park
 * @since 2019. 05. 16
 */
@Entity
@IdClass(MemberProductId.class) // 복합 기본키 사용 : 회원상품 엔티티는 PK가 MEMBER_ID와 PRODUCT_ID로 이루어진 복합키
                                // JPA에서 복합키를 사용하려면 별도의 식별자 클래스를 만들어야 한다.
@Getter @Setter
public class MemberProduct {

    @ManyToOne
    @Id @JoinColumn(name = "MEMBER_ID")     // PK와 FK를 한번에 매핑
    private Member member;  // MemberProductId.member 와 연결

    @ManyToOne
    @Id @JoinColumn(name = "PRODUCT_ID")    // PK와 FK를 한번에 매핑
    private Product product;    // MemberProductId.product 와 연결

    private Long orderAmount;

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

}
