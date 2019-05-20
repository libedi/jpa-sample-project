package com.libedi.jpa.mappedsuperclass;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

/**
 * BaseEntity : 객체들이 주로 사용하는 공통 매핑 정보를 정의.
 *
 * @MappedSuperclass
 * - 테이블과 매핑되지 않고 자식 클래스에 엔티티의 매핑 정보를 상속하기 위해 사용.
 * - @MappedSuperclass 로 지정한 클래스는 엔티티가 아니므로 em.find()나 JPQL에서 사용할 수 없다.
 * - 이 클래스를 직접 생성해서 사용하는 일은 거의 없으므로, 추상 클래스로 만드는 것을 권장.
 *
 * @author Sang-jun, Park
 * @since 2019. 05. 20
 */
@MappedSuperclass
@Getter @Setter
public abstract class BaseEntity {

    @Id @GeneratedValue
    private Long id;
    private String name;
}
