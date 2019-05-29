package com.libedi.jpa.compositekey.identify;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.Getter;
import lombok.Setter;

/**
 * Child : 자식 엔티티
 *
 * @author Sang-jun, Park
 * @since 2019. 05. 29
 */
@Entity
@Getter @Setter
public class Child_Identity_EmbeddedId {

    @EmbeddedId
    private ChildId_Identity_EmbeddedId id;

    // @MapsId 는 외래키와 매핑한 연관관계를 기본키에도 매핑하겠다는 의미. -> 외래키와 기본키를 동시에 사용하겠다는 의미.
    @MapsId("parentId")     // ChildId.parentId 매핑
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private Parent_Identify parent;

    private String name;

}
