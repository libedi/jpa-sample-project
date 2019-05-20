package com.libedi.jpa.inheritance.singletable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Book
 *
 * @author Sang-jun, Park
 * @since 2019. 05. 17
 */
@Entity(name = "inheritance_singletable_Book")
@DiscriminatorValue("B")                // 엔티티를 저장할 떄 구분 컬럼 입력값을 지정
@Getter @Setter
public class Book extends Item {

    private String author;
    private String isbn;
}
