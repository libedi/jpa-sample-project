package com.libedi.demo.transform;

import com.libedi.demo.domain.Posts;
import com.libedi.demo.dto.PostsSaveRequestDto;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

/**
 * PostsTransformer
 *
 * @author Sang-jun, Park
 * @since 2019. 02. 08
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class PostsTransformer {

    /**
     * transform DTO to Entity
     * @param dto
     * @return
     */
    public static Posts transform(PostsSaveRequestDto dto) {
        return Posts.builder()
                .title(dto.getTitle())
                .author(dto.getAuthor())
                .content(dto.getContent())
                .time(dto.getTime())
                .build();
    }

    /**
     * transform Entity to DTO
     * @param entity
     * @return
     */
    public static PostsSaveRequestDto transform(Posts entity) {
        return PostsSaveRequestDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .author(entity.getAuthor())
                .content(entity.getContent())
                .time(entity.getTime())
                .build();
    }

}
