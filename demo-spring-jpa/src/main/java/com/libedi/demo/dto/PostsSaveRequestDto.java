package com.libedi.demo.dto;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@NoArgsConstructor
@ToString
public class PostsSaveRequestDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")    /* RequestBody일 경우 필요 */
    private LocalDateTime time;

    @DateTimeFormat
    private Date timestamp;

    @Builder
    private PostsSaveRequestDto(Long id, String title, String content, String author, LocalDateTime time) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.time = time;
    }

}
