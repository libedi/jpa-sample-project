package com.libedi.jpa.one_to_one.identify;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * BoardDetail
 *
 * @author Sang-jun, Park
 * @since 2019. 05. 30
 */
@Entity
@Getter
@Setter
public class BoardDetail {

    @Id
    private Long boardId;

    @MapsId     // BoardDetail.boardId 매핑
    @OneToOne
    @JoinColumn(name = "BOARD_ID")
    private Board board;

    private String content;

}
