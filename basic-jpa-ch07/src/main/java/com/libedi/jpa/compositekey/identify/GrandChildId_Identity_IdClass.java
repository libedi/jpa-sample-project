package com.libedi.jpa.compositekey.identify;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * GrandChildId : 손자 ID 식별자 클래스
 *
 * @author Sang-jun, Park
 * @since 2019. 05. 29
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@EqualsAndHashCode
public class GrandChildId_Identity_IdClass implements Serializable {

    private static final long serialVersionUID = 7512585610840853924L;

    private Child_Identify_IdClass child;   // GrandChild.child 매핑
    private String id;                      // GrandChild.id 매핑

}
