/*
 * Copyright (c) 2019 LINE Corporation. All rights reserved.
 * LINE Corporation PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.libedi.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

/**
 * Team
 *
 * @author Sang-jun, Park
 * @since 2019. 03. 29
 */
@Entity
@Getter @Setter
public class Team {

    @Id
    @Column(name = "TEAM_ID")
    private String id;
    private String name;

    public Team() {}

    public Team(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
