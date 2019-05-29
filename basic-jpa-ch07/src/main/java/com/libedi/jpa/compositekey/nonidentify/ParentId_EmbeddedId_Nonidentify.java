package com.libedi.jpa.compositekey.nonidentify;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * ParentId : 복합키 매핑을 위한 식별자 클래스
 *
 * @IdClass 와 다르게 @EmbeddedId 를 적용한 식별자 클래스에는 기본키를 직접 매핑한다.
 *
 * - @Embeddable 애노테이션을 붙여주어야 한다.
 * - Serializable 인터페이스를 구현해야 한다.
 * - equals, hashCode를 구현해야 한다.
 * - 기본 생성자가 있어야 한다.
 * - 식별자 클래스는 public 이어야 한다.
 *
 * @author Sang-jun, Park
 * @since 2019. 05. 29
 */
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@EqualsAndHashCode
public class ParentId_EmbeddedId_Nonidentify implements Serializable {

    private static final long serialVersionUID = -2399550482298518739L;

    @Column(name = "PARENT_ID1")
    private String id1;

    @Column(name = "PARENT_ID2")
    private String id2;
}
