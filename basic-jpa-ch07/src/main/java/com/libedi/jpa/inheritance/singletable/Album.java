package com.libedi.jpa.inheritance.singletable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Album
 *
 * @author Sang-jun, Park
 * @since 2019. 05. 20
 */
@Entity(name = "inheritance_singletable_Album")
@DiscriminatorValue("A")
@Getter @Setter
public class Album extends Item {

    private String artist;
}
