package com.libedi.jpa.inheritance.join;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Movie
 *
 * @author Sang-jun, Park
 * @since 2019. 05. 17
 */
@Entity(name = "inheritance_join_Movie")
@DiscriminatorValue("M")    // 엔티티를 저장할 떄 구분 컬럼 입력값을 지정
@Getter @Setter
public class Movie extends Item {

    private String director;
    private String actor;

}
