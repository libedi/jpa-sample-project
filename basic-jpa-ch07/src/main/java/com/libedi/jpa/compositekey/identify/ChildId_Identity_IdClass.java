package com.libedi.jpa.compositekey.identify;

import java.io.Serializable;

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
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@EqualsAndHashCode
public class ChildId_Identity_IdClass implements Serializable {

    private static final long serialVersionUID = -6084822797447243165L;

    private Parent_Identify parent; // Child.parent 매핑
    private String childId;         // Child.childId 매핑

}
