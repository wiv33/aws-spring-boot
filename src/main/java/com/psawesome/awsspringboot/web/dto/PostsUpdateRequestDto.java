package com.psawesome.awsspringboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * package: com.psawesome.awsspringboot.web
 * author: PS
 * DATE: 2019-12-25 수요일 18:55
 */
@NoArgsConstructor
@Getter
public class PostsUpdateRequestDto {

    private String title, content, author;

    @Builder
    public PostsUpdateRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
