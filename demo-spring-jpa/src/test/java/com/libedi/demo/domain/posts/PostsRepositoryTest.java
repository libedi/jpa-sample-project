package com.libedi.demo.domain.posts;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.After;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PostsRepositoryTest {

    @Autowired
    private PostsRepository postsRepository;

    @After
    public void cleanUp() {
        postsRepository.deleteAll();
    }

    @Test
    public void test01_saveAndFind() {
        // given : 테스트 기반 환경을 구축하는 단계
        postsRepository
                .save(Posts.builder().title("테스트 게시글").content("test content").author("libedi").build());

        // when : 테스트 하고자 하는 행위 선언
        List<Posts> postsList = postsRepository.findAll();

        // then : 테스트 결과 검증
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle(), is("테스트 게시글"));
        assertThat(posts.getContent(), is("test content"));
    }

    @Test
    public void test02_timeAuditting() {
        // given
        LocalDateTime now = LocalDateTime.now();
        postsRepository.save(Posts.builder().title("테스트 게시글").content("content").author("author").build());

        // when
        List<Posts> postsList = postsRepository.findAll();

        // then
        Posts posts = postsList.get(0);
        assertTrue(posts.getCreatedAt().isAfter(now));
        assertTrue(posts.getUpdatedAt().isAfter(now));
        assertNotNull(posts.getCreatedBy());
        assertNotNull(posts.getUpdatedBy());

        System.out.println(posts.toString());

        postsRepository.findById(posts.getId());
    }


}
