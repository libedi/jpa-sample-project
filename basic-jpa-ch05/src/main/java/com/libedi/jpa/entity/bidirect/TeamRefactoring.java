/*
 * Copyright (c) 2019 LINE Corporation. All rights reserved.
 * LINE Corporation PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.libedi.jpa.entity.bidirect;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * TeamRefactoring
 *
 * @author Sang-jun, Park (libedi@linecorp.com)
 * @since 2019. 04. 01
 */
@Entity
@Table(name = "TEAM")
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TeamRefactoring {

    @Id
    @Column(name = "TEAM_ID")
    private String id;
    private String name;

    @OneToMany(mappedBy = "team")
    private List<MemberRefactoring> members = new ArrayList<>();

    public TeamRefactoring(String id, String name) {
        this.id = id;
        this.name = name;
    }

}
