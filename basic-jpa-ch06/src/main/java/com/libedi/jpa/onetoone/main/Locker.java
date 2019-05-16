package com.libedi.jpa.onetoone.main;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * Locker
 * : 일대일 주 테이블에 외래키. 연관관계의 주인은 member이므로 mappedBy를 선언했다.
 *
 * @author Sang-jun, Park
 * @since 2019. 04. 29
 */
@Entity(name = "Locker_main")
@Table(name = "LOCKER_MAIN")
@Getter @Setter
public class Locker {

    @Id
    @GeneratedValue
    @Column(name = "LOCKER_ID")
    private Long id;

    private String name;

    @OneToOne(mappedBy = "locker")
    private Member member;

}
