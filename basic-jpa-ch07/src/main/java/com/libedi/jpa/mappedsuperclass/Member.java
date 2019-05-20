package com.libedi.jpa.mappedsuperclass;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Member
 *
 * @author Sang-jun, Park
 * @since 2019. 05. 20
 */
@Entity
@AttributeOverride(name = "id", column = @Column(name = "MEMBER_ID"))   // 부모로부터 물려받은 매핑정보 재정의
@Getter @Setter
public class Member extends BaseEntity {

    // ID 상속
    // NAME 상속
    private String email;
}
