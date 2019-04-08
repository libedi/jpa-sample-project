package com.libedi.jpa.onetomany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Member
 *
 * @author Sang-jun, Park
 * @since 2019. 04. 08
 */
@Entity(name = "Member_oneToMany")
@Table(name = "MEMBER")
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String username;

    public Member(String username) {
        this.username = username;
    }

    /*
     * 일대다 양방향 매핑을 위한 설정.
     * - 외래키를 1인 Team에서 관리하기 때문에,
     * - 다 쪽은 읽기만 가능하게 설정.
     */
    @ManyToOne
    @JoinColumn(name = "TEAM_ID",
        insertable = false, updatable = false)  // 읽기전용으로 설정
    private Team team;
    /*
     * 이 방법은 일대다 양방향 매핑이라기보다는
     * 일대다 단방향 매핑 반대편에 다대일 단방향 매핑을 읽기전용으로 추가한 것.
     * 따라서, 일대다 단방향 매핑의 단점을 그대로 가짐. ==> 읽기전용이라 한번에 INSERT가 안됨.
     *
     * 결론 : 될 수 있으면, 다대일 양방향 매핑으로 가라...(고집부리지말고)
     */


}
