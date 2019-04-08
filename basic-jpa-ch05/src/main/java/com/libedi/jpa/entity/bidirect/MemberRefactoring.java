package com.libedi.jpa.entity.bidirect;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * MemberRefactoring
 *
 * @author Sang-jun, Park (libedi@linecorp.com)
 * @since 2019. 04. 01
 */
@Entity
@Table(name = "MEMBER")
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberRefactoring {

    @Id
    @Column(name = "MEMBER_ID")
    private String id;
    private String username;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private TeamRefactoring team;

    public void setTeam(TeamRefactoring team) {
        // 기존 팀과 관계를 제거
        if(Objects.nonNull(this.team)) {
            this.team.getMembers().remove(this);
        }
        this.team = team;
        team.getMembers().add(this);
    }

    public MemberRefactoring(String id, String username) {
        this.id = id;
        this.username = username;
    }
}
