package com.psawesome.awsspringboot.service.posts;

import com.psawesome.awsspringboot.domain.posts.Posts;
import com.psawesome.awsspringboot.web.dto.PostsResponseDto;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * package: com.psawesome.awsspringboot.service.posts
 * author: PS
 * DATE: 2019-12-26 목요일 22:38
 */
@Getter
public class PostsListResponseDto {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;

    public PostsListResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifyDate();
    }
}
