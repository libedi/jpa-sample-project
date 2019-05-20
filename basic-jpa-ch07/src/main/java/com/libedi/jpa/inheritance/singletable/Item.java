package com.libedi.jpa.inheritance.singletable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
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
 * 단일 테이블 전략 : 테이블 하나만 사용하되 구분 컬럼을 어떤 자식 데이터가 저장되었는지 구분.
 *
 * 1. 장점
 *  - 조인이 필요없어, 조회성능이 빠르다.
 *  - 조회쿼리가 단순하다.
 *
 * 2. 단점
 *  - 자식 엔티티가 매핑한 컬럼은 모두 null을 허용해야 한다. (서로 저장하는 컬럼이 다르기 때문에)
 *  - 단일 테이블에 모든 것을 저장하므로 테이블이 커질 수 있다. 그러므로 상황에 따라 조회 성능이 오히려 느려짐.
 *
 * 3. 특징
 *  - 구분컬럼(@DiscriminatorColumn)을 꼭 사용해야 한다.
 *  - @DiscriminatorValue 를 지정하지 않으면, 기본으로 엔티티 이름을 사용한다.
 *
 * 4. 관련 애노테이션
 *  - @DiscriminatorColumn, @DiscriminatorValue
 * </pre>
 *
 * @author Sang-jun, Park
 * @since 2019. 05. 17
 */
@Entity(name = "inheritance_singletable_Item")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE")
@Getter @Setter
public abstract class Item {

    @Id @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;    // 이름
    private int price;      // 가격
}
