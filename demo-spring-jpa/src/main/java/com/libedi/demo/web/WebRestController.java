package com.libedi.demo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libedi.demo.domain.posts.Posts;
import com.libedi.demo.domain.posts.PostsRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class WebRestController {

    private final PostsRepository postsRepository;

    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }

    @PostMapping("/posts")
    public void savePosts(final PostsSaveRequestDto dto) {
        log.info(dto.toString());
        Posts posts = postsRepository.save(dto.toEntity());
        posts.setTitle("수정된 타이틀");
        postsRepository.flush();
    }

}
