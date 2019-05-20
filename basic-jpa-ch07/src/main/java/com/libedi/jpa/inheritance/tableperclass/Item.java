package com.libedi.jpa.inheritance.tableperclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Getter;
import lombok.Setter;

/**
 * Item
 * <pre>
 *
 * 구현 클래스마다 테이블 전략 : 자식 엔티티마다 테이블을 생성. (일반적으로 비추천)
 *
 * 1. 장점
 * - 서브 타입을 구분해서 처리할 때 효과적.
 * - not null 제약조건 사용가능.
 *
 * 2. 단점
 * - 여러 자식 테이블을 함께 조회할 때 성능이 느리다. (SQL에 UNION을 사용해야 한다.)
 * - 자식 테이블을 통합해서 쿼리하기 어렵다.
 *
 * 3. 특징
 *  - 구분컬럼을 사용하지 않는다.
 * </pre>
 *
 * @author Sang-jun, Park
 * @since 2019. 05. 17
 */
@Entity(name = "inheritance_tableperclass_Item")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter @Setter
public abstract class Item {

    @Id @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;    // 이름
    private int price;      // 가격
}
