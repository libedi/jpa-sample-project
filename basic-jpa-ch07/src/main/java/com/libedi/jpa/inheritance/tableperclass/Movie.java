package com.libedi.jpa.inheritance.tableperclass;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Movie
 *
 * @author Sang-jun, Park
 * @since 2019. 05. 17
 */
@Entity(name = "inheritance_tableperclass_Movie")
@Getter @Setter
public class Movie extends Item {

    private String director;
    private String actor;

}
