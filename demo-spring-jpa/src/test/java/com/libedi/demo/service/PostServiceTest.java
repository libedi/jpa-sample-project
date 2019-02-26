package com.libedi.demo.service;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.libedi.demo.dto.PostsSaveRequestDto;
import com.libedi.demo.repository.PostsRepository;
import com.libedi.demo.transform.PostsTransformer;

/**
 * PostsService
 *
 * @author Sang-jun, Park
 * @since 2019. 02. 08
 */
@RunWith(MockitoJUnitRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PostServiceTest {

    @Mock
    private PostsRepository postsRepository;

    @InjectMocks
    private PostService postService;

    @Test
    public void testUpdate() {
        // given
        Long id = 1L;
        PostsSaveRequestDto dto =
                PostsSaveRequestDto.builder().id(id).author("update author").content("update content").build();
        when(postsRepository.findById(id)).thenReturn(Optional.of(PostsTransformer.transform(dto)));
        // when-then
        postService.update(dto);
    }

}
