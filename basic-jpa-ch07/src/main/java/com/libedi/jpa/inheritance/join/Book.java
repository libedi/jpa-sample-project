package com.libedi.jpa.inheritance.join;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Getter;
import lombok.Setter;

/**
 * Book
 *
 * @author Sang-jun, Park
 * @since 2019. 05. 17
 */
@Entity(name = "inheritance_join_Book")
@DiscriminatorValue("B")                // 엔티티를 저장할 떄 구분 컬럼 입력값을 지정
@PrimaryKeyJoinColumn(name = "BOOK_ID") // 자식 테이블의 기본키 컬럼명 변경: 기본적으로는 부모테이블의 ID컬럼명을 그대로 사용.
@Getter @Setter
public class Book extends Item {

    private String author;
    private String isbn;
}
