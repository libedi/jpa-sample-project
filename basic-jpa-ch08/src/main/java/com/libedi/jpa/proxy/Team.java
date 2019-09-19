package com.libedi.jpa.proxy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

/**
 * Team
 *
 * @author Sang-jun, Park
 * @since 2019. 06. 13
 */
@Entity
@Getter
@Setter
public class Team {

    @Id
    @Column(name = "TEAM_ID")
    private String id;

    private String name;

}
