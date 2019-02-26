package com.libedi.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.libedi.demo.dto.PostsSaveRequestDto;
import com.libedi.demo.repository.PostsRepository;
import com.libedi.demo.util.OptionalSupport;
import com.libedi.demo.util.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;

/**
 * PostService
 *
 * @author Sang-jun, Park
 * @since 2019. 02. 08
 */
@Service
@RequiredArgsConstructor
public class PostService {

    private final PostsRepository postsRepository;

    /**
     * @param dto
     */
    @Transactional
    public void update(PostsSaveRequestDto dto) {
        OptionalSupport.of(postsRepository.findById(dto.getId())).ifPresentOrElse(p -> {
            p.setTitle(dto.getTitle());
            p.setAuthor(dto.getAuthor());
            p.setContent(dto.getContent());
            p.setTime(dto.getTime());
            // transaction 종료시 자동으로 update 된다.
//            postsRepository.save(p);
        }, () -> {
            throw new ResourceNotFoundException();
        });
    }

}
