package com.libedi.jpa.jointable.one_to_one;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * Parent_Jointable_OneToOne
 *
 * @author Sang-jun, Park
 * @since 2019. 06. 03
 */
@Entity
@Getter
@Setter
public class Parent_Jointable_OneToOne {

    @Id @GeneratedValue
    @Column(name = "PARENT_ID")
    private Long id;

    private String name;

    @OneToOne
    @JoinTable(name = "PARENT_CHILD_JOINTABLE_ONETOONE",
            joinColumns = @JoinColumn(name = "PARENT_ID"),          // PARENT_CHILD 의 PK & FK
            inverseJoinColumns = @JoinColumn(name = "CHILD_ID"))    // PARENT_CHILD 의 UK & FK
    private Child_Jointable_OneToOne child;
}
