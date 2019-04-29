package com.libedi.jpa.onetoone.main;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * Member
 * : 일대일 주 테이블에 외래키. 주 테이블은 MEMBER.
 *
 * @author Sang-jun, Park
 * @since 2019. 04. 29
 */
@Entity
@Table(name = "MEMBER_MAIN")
@Getter @Setter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String username;

    @OneToOne
    @JoinColumn(name = "LOCKER_ID", unique = true)  // 일대일이므로 FK에 유니크 제약조건이 추가되었다.
    private Locker locker;
}
