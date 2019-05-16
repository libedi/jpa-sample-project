package com.libedi.jpa.onetoone.target;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.libedi.jpa.onetoone.main.Locker;

import lombok.Getter;
import lombok.Setter;

/**
 * Member
 * : 일대일 대상 테이블에 외래키. 대상테이블은 LOCKER.
 * : 연관관계의 주인은 locker이므로 mappedBy를 선언했다.
 *
 * @author Sang-jun, Park
 * @since 2019. 04. 29
 */
@Entity(name = "Member_target")
@Table(name = "MEMBER_TARGET")
@Getter @Setter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String username;

    /*
     * 외래키가 대상 테이블에 있을 경우, 단방향인 경우에는 주 테이블의 엔티티에서
     * 대상 테이블로 매핑할 수 있는 방법이 없다. (당연하지... 알 수가 없잖아...)
     * 그래서 양방향만 허용한다.
     */
    @OneToOne(mappedBy = "member")
    private Locker locker;
}
