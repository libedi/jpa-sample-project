package com.libedi.jpa.inheritance.tableperclass;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Book
 *
 * @author Sang-jun, Park
 * @since 2019. 05. 17
 */
@Entity(name = "inheritance_tableperclass_Book")
@Getter @Setter
public class Book extends Item {

    private String author;
    private String isbn;
}
