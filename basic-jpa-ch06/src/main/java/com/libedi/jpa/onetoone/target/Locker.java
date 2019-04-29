package com.libedi.jpa.onetoone.target;

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
 * Locker
 * : 일대일 대상 테이블에 외래키. 대상 테이블은 LOCKER
 *
 * @author Sang-jun, Park
 * @since 2019. 04. 29
 */
@Entity
@Table(name = "LOCKER_TARGET")
@Getter @Setter
public class Locker {

    @Id
    @GeneratedValue
    @Column(name = "LOCKER_ID")
    private Long id;

    private String name;

    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Member member;

}
