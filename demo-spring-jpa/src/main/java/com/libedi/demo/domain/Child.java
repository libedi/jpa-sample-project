package com.libedi.demo.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Child
 *
 * @author Sang-jun, Park
 * @since 2019. 04. 19
 */
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = "parent")
public class Child {

    @Id
    private Long id;    // parent의 ID값이 여기에 들어간다.

    private String content;

    @MapsId
    @OneToOne
    @JoinColumn(name = "parent_id")
    @JsonIgnore
    private Parent parent;

    @Builder
    private Child(String content, Parent parent) {
        this.content = content;
        this.parent = parent;
    }

}
