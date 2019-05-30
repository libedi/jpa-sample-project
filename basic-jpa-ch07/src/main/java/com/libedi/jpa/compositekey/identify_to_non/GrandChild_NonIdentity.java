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
 * GrandChild : 손자 엔티티
 *
 * @author Sang-jun, Park
 * @since 2019. 05. 30
 */
@Entity
@Getter
@Setter
public class GrandChild_NonIdentity {

    @Id
    @GeneratedValue
    @Column(name = "GRANDCHILD_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CHILD_ID")
    private Child_NonIdentity child;

    private String name;

}
