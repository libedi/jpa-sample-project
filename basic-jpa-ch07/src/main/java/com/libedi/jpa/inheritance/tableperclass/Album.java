/*
 * Copyright (c) 2019 LINE Corporation. All rights reserved.
 * LINE Corporation PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.libedi.jpa.inheritance.tableperclass;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Album
 *
 * @author Sang-jun, Park (libedi@linecorp.com)
 * @since 2019. 05. 20
 */
@Entity(name = "inheritance_tableperclass_Album")
@Getter @Setter
public class Album extends Item {

    private String artist;
}
