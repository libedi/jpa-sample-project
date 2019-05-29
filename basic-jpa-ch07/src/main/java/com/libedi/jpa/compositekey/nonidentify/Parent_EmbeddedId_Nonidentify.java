package com.libedi.jpa.compositekey.nonidentify;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

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
@Getter @Setter
public class Parent_EmbeddedId_Nonidentify {

    @EmbeddedId
    private ParentId_EmbeddedId_Nonidentify id;

    private String name;

}
