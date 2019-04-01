/*
 * Copyright (c) 2019 LINE Corporation. All rights reserved.
 * LINE Corporation PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.libedi.jpa.entity.bidirect;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Team
 *
 * @author Sang-jun, Park (libedi@linecorp.com)
 * @since 2019. 04. 01
 */
@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Team {

    @Id
    @Column(name = "TEAM_ID")
    private String id;
    private String name;

    /*
     * 일대다 관계 매핑.
     * mappedBy 속성은 양방향 매핑일 때 사용.
     * 반대쪽 매핑의 필드명을 값으로 주면 된다.
     */
    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();

    public Team(String id, String name) {
        this.id = id;
        this.name = name;
    }

}
