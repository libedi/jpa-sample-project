package com.libedi.demo.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

/**
 * PostsRepository
 *
 * @author Sang-jun, Park (libedi@linecorp.com)
 * @since 2019. 02. 07
 */
public interface PostsRepository extends JpaRepository<Posts, Long>, RevisionRepository<Posts, Long, Integer> {

}
