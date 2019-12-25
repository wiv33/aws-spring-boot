package com.psawesome.awsspringboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * package: com.psawesome.awsspringboot.domain.posts
 * author: PS
 * DATE: 2019-12-25 수요일 16:10
 */
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
