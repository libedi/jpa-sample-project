package com.libedi.jpa.manytomany.joinentity;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * <pre>
 * MemberProductId
 * - 복합키를 사용하기 위한 식별자 클래스.
 * - 사용하려는 엔티티에 @IdClass 로 지정하면 된다.
 *
 * 복합키를 위한 식별자 클래스의 특징
 * - 복합키는 별도의 식별자 클래스로 만들어야 한다.
 * - Serializable을 구현해야 한다.
 * - equals와 hashCode 메서드를 구현해야 한다.
 * - 기본 생성자가 있어야 한다.
 * - 식별자 클래스는 public이어야 한다.
 * - @IdClass 를 사용하는 방법 외에 @EmbeddedId 를 사용하는 방법도 있다.
 * </pre>
 *
 * @author Sang-jun, Park
 * @since 2019. 05. 16
 */
@Getter @Setter
@EqualsAndHashCode
public class MemberProductId implements Serializable {

    private static final long serialVersionUID = 7127817741230839210L;

    private String member;      // MemberProduct.member 와 연결
    private String product;     // MemberProduct.product 와 연결

    // equals and hashCode
}
