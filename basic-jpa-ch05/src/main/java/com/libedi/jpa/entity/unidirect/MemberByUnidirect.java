/*
 * Copyright (c) 2019 LINE Corporation. All rights reserved.
 * LINE Corporation PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.libedi.jpa.entity.unidirect;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * Member
 *
 * @author Sang-jun, Park
 * @since 2019. 03. 29
 */
@Entity(name = "MEMBER")
@Getter @Setter
public class MemberByUnidirect {

    @Id
    @Column(name = "MEMBER_ID")
    private String id;
    private String username;

    // 연관관계 매핑
    @ManyToOne                      // 회원과 팀은 다대일 관계이다. 회원(N) : 팀(1)
    @JoinColumn(name = "TEAM_ID")   // 외래 키 매핑. name 속성에 매핑할 외래키 이름을 지정.
    private TeamByUnidirect team;  // 팀의 참조를 보관

    public MemberByUnidirect() {}

    public MemberByUnidirect(String id, String username) {
        this.id = id;
        this.username = username;
    }

    // 연관관계 설정
    public void setTeam(TeamByUnidirect team) {
        this.team = team;
    }

}
