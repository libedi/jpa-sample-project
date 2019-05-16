package com.libedi.jpa.manytomany.joinentity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * Member
 *
 * @author Sang-jun, Park
 * @since 2019. 05. 10
 */
@Entity(name = "Member_ManyToMany_joinEntity")
@Table(name = "MEMBER_MANY")
@Getter @Setter
public class Member {

    @Id @Column(name = "MEMBER_ID")
    private String id;

    private String username;

    /*
     * 실무에서는 연결 테이블에 FK 외에 다른 컬럼들도 필요한 경우가 많다.
     * 그럴 경우, @ManyToMany를 사용할 수 없고,
     * 연결 엔티티를 만들어 다대다 -> 일대다 다대일 관계로 풀어야 한다.
     * 여기서는 MemberProduct 라는 연결 엔티티를 생성한다.
     */
    // 역방향
    @OneToMany(mappedBy = "member")
    private final List<MemberProduct> products = new ArrayList<>();


}
