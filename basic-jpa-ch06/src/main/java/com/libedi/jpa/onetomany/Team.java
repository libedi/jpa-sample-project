package com.libedi.jpa.onetomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Team
 * - 하나의 팀이 여러 회원을 참조하는 경우: 일대다 단방향
 * - 팀은 회원을 참조하지만, 회원은 팀을 참조하지 않는다.
 *
 * @author Sang-jun, Park
 * @since 2019. 04. 08
 */
@Entity(name = "Team_oneToMany")
@Table(name = "TEAM")
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Team {

    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;

    private String name;

    public Team(String name) {
        this.name = name;
    }

    /*
     * 일대다 단방향 관계를 매핑할 때는 @JoinColumn을 명시해야 한다. 안그러면 기본적으로 조인 테이블을 생성한다.
     */
    @OneToMany
    @JoinColumn(name = "TEAM_ID")   // MEMBER 테이블의 TEAM_ID (FK)
    private final List<Member> members = new ArrayList<>();
}
