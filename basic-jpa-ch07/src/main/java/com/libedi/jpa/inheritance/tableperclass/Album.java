package com.libedi.jpa.inheritance.tableperclass;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Album
 *
 * @author Sang-jun, Park
 * @since 2019. 05. 20
 */
@Entity(name = "inheritance_tableperclass_Album")
@Getter @Setter
public class Album extends Item {

    private String artist;
}
