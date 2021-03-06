package com.libedi.jpa.entity.unidirect;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * Team
 *
 * @author Sang-jun, Park
 * @since 2019. 03. 29
 */
@Entity
@Table(name = "TEAM")
@Getter @Setter
public class TeamByUnidirect {

    @Id
    @Column(name = "TEAM_ID")
    private String id;
    private String name;

    public TeamByUnidirect() {}

    public TeamByUnidirect(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
