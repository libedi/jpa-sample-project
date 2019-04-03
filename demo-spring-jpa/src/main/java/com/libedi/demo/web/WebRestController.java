package com.libedi.demo.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.libedi.demo.dto.PostsSaveRequestDto;
import com.libedi.demo.dto.TestDto;
import com.libedi.demo.repository.PostsRepository;
import com.libedi.demo.service.PostService;
import com.libedi.demo.service.TestService;
import com.libedi.demo.service.TxService;
import com.libedi.demo.transform.PostsTransformer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class WebRestController {

    private final PostService postService;

    private final PostsRepository postsRepository;

    private final TxService txService;

    private final TestService testService;

    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }

    @PostMapping("/posts")
    public void savePosts(final PostsSaveRequestDto dto) {
        log.info(dto.toString());
        postsRepository.save(PostsTransformer.transform(dto));
    }

    @PutMapping("/posts/{id}")
    public void updatePosts(@PathVariable final long id, @RequestBody final PostsSaveRequestDto dto) {
        dto.setId(id);
        log.info(dto.toString());
        postService.update(dto);
    }

    @GetMapping("/test/{idx}")
    public void transactionalTest(@PathVariable int idx) {
        switch(idx) {
            case 1:
                txService.readOnly();
                break;
            case 2:
                txService.notReadOnly();
                break;
        }

    }

    @PostMapping("/test/entity")
    public void saveTest(@RequestBody final TestDto dto) {
        testService.save(dto);
    }

    @GetMapping("/test-entity/{id}")
    public TestDto getTestEntity(@PathVariable long id) {
        return testService.getTestEntity(id);
    }

    @DeleteMapping("/test-entity/{id}")
    public void deleteTest(@PathVariable long id) {
        testService.delete(id);
    }

}
