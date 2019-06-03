package com.libedi.jpa.jointable.many_to_one;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * Child_Jointable_ManyToOne
 *
 * @author Sang-jun, Park
 * @since 2019. 06. 03
 */
@Entity
@Getter
@Setter
public class Child_Jointable_ManyToOne {

    @Id @GeneratedValue
    @Column(name = "CHILD_ID")
    private Long id;

    private String name;

    @ManyToOne(optional = false)
    @JoinTable(name = "PARENT_CHILD_JOINTABLE_MANYTOONE",
            joinColumns = @JoinColumn(name = "CHILD_ID"),
            inverseJoinColumns = @JoinColumn(name = "PARENT_ID"))
    private Parent_Jointable_ManyToOne parent;

}
