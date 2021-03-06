package com.libedi.jpa.compositekey.identify;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * Child : 자식 엔티티
 *
 * @author Sang-jun, Park
 * @since 2019. 05. 29
 */
@Entity
@IdClass(ChildId_Identity_IdClass.class)
@Getter @Setter
public class Child_Identify_IdClass {

    // 식별관계는 기본키와 외래키를 같이 매핑해야 한다.
    // 따라서 식별자 매핑인 @Id 와 연관관계 매핑인 @ManyToOne 을 같이 사용한다.
    @Id
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private Parent_Identify parent;

    @Id @Column(name = "CHILD_ID")
    private String childId;

    private String name;

}
