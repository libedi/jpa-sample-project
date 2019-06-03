package com.libedi.jpa.jointable.one_to_many;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

/**
 * Child_Jointable_OneToMany
 *
 * @author Sang-jun, Park
 * @since 2019. 06. 03
 */
@Entity
@Getter
@Setter
public class Child_Jointable_OneToMany {

    @Id @GeneratedValue
    @Column(name = "CHILD_ID")
    private Long id;

    private String name;
}
