package com.libedi.jpa.secondarytable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import lombok.Getter;

/**
 * Board_SecondaryTable
 * - 하나의 엔티티에 여러 테이블 매핑
 *
 * @author Sang-jun, Park
 * @since 2019. 06. 07
 */
@Entity
@Getter
@Table(name = "BOARD_SECONDARYTABLE")
@SecondaryTable(name = "BOARD_DETAIL_SECONDARYTABLE",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "BOARD_DETAIL_ID"))
public class Board_SecondaryTable {

    @Id @GeneratedValue
    @Column(name = "BOARD_ID")
    private Long id;

    private String title;

    @Column(table = "BOARD_DETAIL_SECONDARYTABLE")
    private String content;

}
