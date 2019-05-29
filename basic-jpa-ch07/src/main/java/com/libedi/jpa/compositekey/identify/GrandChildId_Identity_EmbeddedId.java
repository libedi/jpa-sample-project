package com.libedi.jpa.compositekey.identify;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * GrandChildId : 손자ID 식별자 클래스
 *
 * @author Sang-jun, Park
 * @since 2019. 05. 29
 */
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@EqualsAndHashCode
public class GrandChildId_Identity_EmbeddedId implements Serializable {

    private static final long serialVersionUID = -4354860300975357030L;

    private ChildId_Identity_EmbeddedId childId;    // 자식 엔티티의 PK에 해당. @MapsId("childId") 로 매핑.

    @Column(name = "GRANDCHILD_ID")
    private String id;

}
