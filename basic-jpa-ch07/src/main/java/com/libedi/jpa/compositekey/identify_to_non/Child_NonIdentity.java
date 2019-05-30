package com.libedi.jpa.compositekey.identify_to_non;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * Child : 자식 엔티티
 *
 * @author Sang-jun, Park
 * @since 2019. 05. 30
 */
@Entity
@Getter
@Setter
public class Child_NonIdentity {

    @Id
    @GeneratedValue
    @Column(name = "CHILD_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private Parent_NonIdentify parent;

    private String name;

}
