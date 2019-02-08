package com.libedi.demo.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.libedi.demo.domain.Posts;

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

    public Posts toEntity() {
        return Posts.builder().title(title).content(content).author(author).time(time).build();
    }

}
