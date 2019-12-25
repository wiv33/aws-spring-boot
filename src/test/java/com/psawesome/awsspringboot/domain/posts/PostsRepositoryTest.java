package com.psawesome.awsspringboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * package: com.psawesome.awsspringboot.domain.posts
 * author: PS
 * DATE: 2019-12-25 수요일 16:11
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository repository;

    @After
    public void cleanup() {
        repository.deleteAll();
    }

    @Test
    public void 게시글_저장_불러오기() {
        // Given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        String author = "github.com/wiv33";
        Posts build = Posts.builder()
                .title(title).content(content)
                .author(author)
                .build();
        repository.save(build);

        // When
        List<Posts> list = repository.findAll();


        // Then
        Posts posts = list.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
        assertThat(posts.getAuthor()).isEqualTo(author);
    }
}