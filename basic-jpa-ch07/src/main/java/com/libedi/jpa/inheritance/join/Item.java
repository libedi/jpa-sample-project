package com.libedi.jpa.inheritance.join;

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
 * Item : 수퍼타입 테이블에 해당
 * <pre>
 *
 * 조인전략
 *
 * 1. 장점
 *  - 테이블이 정규화된다.
 *  - 외래 키 참조 무결성 제약조건을 활용할 수 있다.
 *  - 저장공간을 효율적으로 사용한다.
 *
 * 2. 단점
 *  - 조회할 때 조인이 많이 사용되어 성능 저하 발생 가능
 *  - 조회 쿼리가 복잡
 *  - 데이터 등록시 INSERT SQL이 2번 실행
 *
 * 3. 특징
 *  - 구분컬럼(@DiscriminatorColumn) 없이도 사용가능
 *
 * 4. 관련 애노테이션
 *  - @DiscriminatorColumn, @DiscriminatorValue, @PrimaryKeyJoinColumn
 * </pre>
 *
 * @author Sang-jun, Park
 * @since 2019. 05. 17
 */
@Entity(name = "inheritance_join_Item")
@Inheritance(strategy = InheritanceType.JOINED) // 상속매핑 설정: 조인전략 사용.
@DiscriminatorColumn(name = "DTYPE")            // 부모 테이블의 구분 컬럼 지정: 저장된 자식 테이블을 구분할 수 있다. (ALBUM인지, BOOK인지, MOVIE인지..)
@Getter @Setter
public abstract class Item {

    @Id @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;
    private int price;
}
