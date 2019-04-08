package com.libedi.jpa.manytoone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * Member
 *
 * @author Sang-jun, Park
 * @since 2019. 04. 08
 */
@Entity
@Getter @Setter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String username;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public void setTeam(Team team) {
        this.team = team;

        // Team 쪽에도 연관관계가 설정되도록 하여 양방향이 되게 한다.
        // 양쪽에 편의 메서드를 추가하면 서로의 메서드를 호출해 무한루프에 빠질 수 있다.
        // 무한루프에 빠지지 않도록 체크한다.
        if(team.getMembers().contains(this) == false) {
            team.getMembers().add(this);
        }
    }


}
