package com.libedi.jpa.compositekey.identify_to_non;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

/**
 * Parent : 부모 엔티티
 *
 * - 복합키를 사용한 식별관계 코드보다 매핑도 쉽고, 코드도 단순하다.
 * - 복합키가 없으므로 식별자 클래스를 만들지 않아도 된다.
 *
 * @author Sang-jun, Park
 * @since 2019. 05. 29
 */
@Entity
@Getter
@Setter
public class Parent_NonIdentify {

    @Id
    @GeneratedValue
    @Column(name = "PARENT_ID")
    private Long id;
    private String name;

}
