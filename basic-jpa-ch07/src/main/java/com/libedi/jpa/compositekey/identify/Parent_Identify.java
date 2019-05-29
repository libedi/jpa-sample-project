package com.libedi.jpa.compositekey.identify;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

/**
 * Parent : 부모 엔티티
 *
 * @author Sang-jun, Park
 * @since 2019. 05. 29
 */
@Entity
@Getter @Setter
public class Parent_Identify {

    @Id @Column(name = "PARENT_ID")
    private String id;
    private String name;

}
