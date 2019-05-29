package com.libedi.jpa.compositekey.identify;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * ChildId : 자식 ID 식별자 클래스
 *
 * @author Sang-jun, Park
 * @since 2019. 05. 29
 */
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@EqualsAndHashCode
public class ChildId_Identity_EmbeddedId implements Serializable {

    private static final long serialVersionUID = -4522688475693289929L;

    private String parentId;    // 부모 엔티티의 PK에 해당. @MapsId("parentId") 로 매핑.

    @Column(name = "CHILD_ID")
    private String id;

}
