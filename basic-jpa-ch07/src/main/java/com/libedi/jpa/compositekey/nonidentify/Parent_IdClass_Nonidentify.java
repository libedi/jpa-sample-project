package com.libedi.jpa.compositekey.nonidentify;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.Getter;
import lombok.Setter;

/**
 * Parent
 *
 * JPA는 복합키를 지원하기 위해 2가지 방법을 제공한다.
 * 1. @IdClass : 관계형 데이터베이스에 가까운 방법
 * 2. @EmbeddedId : 좀 더 객체지향에 가까운 방법
 *
 * @author Sang-jun, Park
 * @since 2019. 05. 29
 */
@Entity
@IdClass(ParentId_IdClass_Nonidentify.class)    // 복합키를 매핑하기 위한 식별자 클래스 지정
@Getter @Setter
public class Parent_IdClass_Nonidentify {

    @Id
    @Column(name = "PARENT_ID1")
    private String id1;     // ParentId.id1 과 연결

    @Id
    @Column(name = "PARENT_ID2")
    private String id2;     // ParentId.id2 와 연결


    private String name;
}
