package com.libedi.jpa.jointable.many_to_many;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

/**
 * Parent_Jointable_ManyToMany
 *
 * @author Sang-jun, Park
 * @since 2019. 06. 03
 */
@Entity
@Getter
@Setter
public class Parent_Jointable_ManyToMany {

    @Id @GeneratedValue
    @Column(name = "PARENT_ID")
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "PARENT_CHILD_JOINTABLE_MANYTOMANY",
            joinColumns = @JoinColumn(name = "")
    )
    private List<Child_Jointable_ManyToMany> child = new ArrayList<>();

}
