package com.libedi.jpa.compositekey.nonidentify;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

/**
 * Child
 *
 * @author Sang-jun, Park
 * @since 2019. 05. 29
 */
@Entity
public class Child_IdClass_Nonidentify {

    @Id
    private String id;

    // referencedColumnName : 외래키가 참조하는 대상 테이블의 PK 컬러명
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "PARENT_ID1", referencedColumnName = "PARENT_ID1"),   // name과 referencedColumnName가 같으면 생략 가능하다.
        @JoinColumn(name = "PARENT_ID2", referencedColumnName = "PARENT_ID2")
    })
    private Parent_IdClass_Nonidentify parent;

}
