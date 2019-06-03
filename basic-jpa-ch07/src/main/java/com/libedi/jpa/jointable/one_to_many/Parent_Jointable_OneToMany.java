/*
 * LINE Corporation PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.libedi.jpa.jointable.one_to_many;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

/**
 * Parent_Jointable_OneToMany
 *
 * @author Sang-jun, Park
 * @since 2019. 06. 03
 */
@Entity
@Getter
@Setter
public class Parent_Jointable_OneToMany {

    @Id @GeneratedValue
    @Column(name = "PARENT_ID")
    private Long id;

    private String name;

    @OneToMany
    @JoinTable(name = "PARENT_CHILD_JOINTABLE_ONETOMANY",
            joinColumns = @JoinColumn(name = "PARENT_ID"),          // PARENT_CHILD 의 FK
            inverseJoinColumns = @JoinColumn(name = "CHILD_ID"))    // PARENT_CHILD 의 PK & FK
    private List<Child_Jointable_OneToMany> child = new ArrayList<>();

}
