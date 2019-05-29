package com.libedi.jpa.compositekey.nonidentify;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * ParentId : 복합키 매핑을 위한 식별자 클래스
 *
 * - 식별자 클래스의 속성명과 엔티티에서 사용하는 식별자의 속성명이 동일해야 한다.
 * - Serializable 인터페이스를 구현해야 한다.
 * - equals, hashCode를 구현해야 한다.
 * - 기본 생성자가 있어야 한다.
 * - 식별자 클래스는 public이어야 한다.
 *
 * @author Sang-jun, Park
 * @since 2019. 05. 29
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@EqualsAndHashCode
public class ParentId_IdClass_Nonidentify implements Serializable {

    private static final long serialVersionUID = -1932812755717577434L;

    private String id1;     // Parent.id1 매핑
    private String id2;     // Parent.id2 매핑

}
