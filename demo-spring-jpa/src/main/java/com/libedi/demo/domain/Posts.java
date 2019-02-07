package com.libedi.demo.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.envers.Audited;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Audited(withModifiedFlag = true)   // 변경이력을 추적할 Entity에 붙이는 애노테이션: Entity가 영속화 될 때마다 History 테이블이 자동으로 관리된다.
                                    // withModifiedFlag : 컬럼의 실제 변경여부를 위한 추가 컬럼이 생성. (default: _MOD)
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Setter
@ToString(callSuper = true)
public class Posts extends BaseAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    private LocalDateTime time;

    @Builder
    private Posts(String title, String content, String author, LocalDateTime time) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.time = time;
    }

}
