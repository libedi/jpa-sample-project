package com.libedi.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * OneEntity
 *
 * @author Sang-jun, Park
 * @since 2019. 04. 17
 */
@Entity
@Table(name = "one")
@Getter @Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class OneEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oneId;

    private String oneName;

}
