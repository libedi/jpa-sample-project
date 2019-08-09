package com.libedi.jpa.compositekey.nonidentify;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * Child_EmbeddedId_Nonidentify
 *
 * @author Sang-jun, Park
 * @since 2019. 07. 05
 */
@Entity
@Getter
@Setter
public class Child_EmbeddedId_Nonidentify {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "PARENT_ID1", referencedColumnName = "PARENT_ID1"),   // name과 referencedColumnName가 같으면 생략 가능하다.
        @JoinColumn(name = "PARENT_ID2", referencedColumnName = "PARENT_ID2")
    })
    private Parent_EmbeddedId_Nonidentify parent;
}
