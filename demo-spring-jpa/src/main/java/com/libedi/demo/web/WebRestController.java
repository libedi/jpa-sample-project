package com.libedi.demo.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.libedi.demo.domain.Child;
import com.libedi.demo.domain.Parent;
import com.libedi.demo.dto.PostsSaveRequestDto;
import com.libedi.demo.dto.TestDto;
import com.libedi.demo.repository.ChildRepository;
import com.libedi.demo.repository.ParentRepository;
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

    private final ParentRepository parentRepository;

    private final ChildRepository childRepository;

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

    @PostMapping("/parent")
    public Parent saveParent() {
        return parentRepository.save(Parent.builder().name("parent name").build());
    }

    @PostMapping("/child/{parentId}")
    public Child saveChild(@PathVariable long parentId) {
        return childRepository.save(Child.builder().content("child content")
                .parent(parentRepository.findById(parentId).get()).build());
    }

    @GetMapping("/parent/{parentId}")
    public Parent getParent(@PathVariable long parentId) {
        return parentRepository.findById(parentId).get();
    }

    @PostMapping(value = "/test/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void upload(@RequestPart MultipartFile file, @RequestPart PostsSaveRequestDto dto, @RequestPart TestDto test) {
        System.out.println(dto.toString());
        System.out.println(test.toString());
        System.out.println(file.toString());
    }

}
