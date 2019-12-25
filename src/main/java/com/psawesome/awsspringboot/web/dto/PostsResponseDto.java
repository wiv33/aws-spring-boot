package com.psawesome.awsspringboot.web.dto;

import com.psawesome.awsspringboot.domain.posts.Posts;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * package: com.psawesome.awsspringboot.web
 * author: PS
 * DATE: 2019-12-25 수요일 18:41
 */

@Getter
@NoArgsConstructor
public class PostsResponseDto {

    private Long id;
    private String title, content, author;

    public PostsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
