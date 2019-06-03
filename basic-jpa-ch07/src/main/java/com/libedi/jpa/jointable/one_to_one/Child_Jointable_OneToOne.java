package com.libedi.jpa.jointable.one_to_one;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * Child_Jointable_OneToOne
 *
 * @author Sang-jun, Park
 * @since 2019. 06. 03
 */
@Entity
@Getter
@Setter
public class Child_Jointable_OneToOne {

    @Id @GeneratedValue
    @Column(name = "CHILD_ID")
    private Long id;
    private String name;

    // 양방향 매핑시 적용
    @OneToOne(mappedBy = "child")
    private Parent_Jointable_OneToOne parent;

}
