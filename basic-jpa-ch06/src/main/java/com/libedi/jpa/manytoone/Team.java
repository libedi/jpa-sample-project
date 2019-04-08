package com.libedi.jpa.manytoone;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

/**
 * Team
 *
 * @author Sang-jun, Park (libedi@linecorp.com)
 * @since 2019. 04. 08
 */
@Entity
@Getter @Setter
public class Team {

    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();

    public void addMember(Member member) {
        members.add(member);

        // Member 쪽에도 연관관계가 설정되도록 하여 양방향이 되게 한다.
        // 양쪽에 편의 메서드를 추가하면 서로의 메서드를 호출해 무한루프에 빠질 수 있다.
        // 무한루프에 빠지지 않도록 체크한다.
        if(member.getTeam() != this) {
            member.setTeam(this);
        }
    }


}
