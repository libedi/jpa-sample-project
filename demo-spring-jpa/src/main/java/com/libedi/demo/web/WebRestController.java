package com.libedi.demo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.libedi.demo.dto.PostsSaveRequestDto;
import com.libedi.demo.repository.PostsRepository;
import com.libedi.demo.transform.PostsTransformer;
import com.libedi.demo.util.OptionalSupport;
import com.libedi.demo.util.ResourceNotFoundException;

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
    public void savePosts(@RequestBody final PostsSaveRequestDto dto) {
        log.info(dto.toString());
        postsRepository.save(PostsTransformer.transform(dto));
    }

    @PutMapping("/posts/{id}")
    public void updatePosts(@PathVariable final long id, @RequestBody final PostsSaveRequestDto dto) {
        dto.setId(id);
        log.info(dto.toString());
        OptionalSupport.of(postsRepository.findById(id)).ifPresentOrElse(p -> {
            p.setTitle(dto.getTitle());
            p.setAuthor(dto.getAuthor());
            p.setContent(dto.getContent());
            p.setTime(dto.getTime());
            postsRepository.save(p);
        }, () -> {
            throw new ResourceNotFoundException();
        });
    }

}
