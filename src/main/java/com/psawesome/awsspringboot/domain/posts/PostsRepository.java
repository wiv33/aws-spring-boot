package com.psawesome.awsspringboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * package: com.psawesome.awsspringboot.domain.posts
 * author: PS
 * DATE: 2019-12-25 수요일 16:10
 */
public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
