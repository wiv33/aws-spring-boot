package com.psawesome.awsspringboot.web.dto;

import com.psawesome.awsspringboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * package: com.psawesome.awsspringboot.web.dto
 * author: PS
 * DATE: 2019-12-25 수요일 17:27
 */
@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {

    private String title, content, author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
