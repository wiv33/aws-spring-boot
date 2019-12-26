package com.psawesome.awsspringboot.web;

import com.psawesome.awsspringboot.domain.posts.Posts;
import com.psawesome.awsspringboot.domain.posts.PostsRepository;
import com.psawesome.awsspringboot.web.dto.PostsResponseDto;
import com.psawesome.awsspringboot.web.dto.PostsSaveRequestDto;
import com.psawesome.awsspringboot.web.dto.PostsUpdateRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * package: com.psawesome.awsspringboot.web
 * author: PS
 * DATE: 2019-12-25 수요일 17:33
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostsApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PostsRepository postsRepository;

    @After
    public void tearDown() {
        postsRepository.deleteAll();
    }

    @Test
    public void save() {
        // Given
        String title = "title";
        String content = "content";

        String author = "psAwesome";
        PostsSaveRequestDto requestDto = PostsSaveRequestDto.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();

        String url = "http://localhost:" + port + "/api/v1/posts";

        // When
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0);

        List<Posts> list = postsRepository.findAll();
        Posts posts = list.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void posts_update() {
        // Given
        Posts save = postsRepository.save(Posts.builder()
                .title("Hello Title")
                .content("My Content")
                .author("I'm Author")
                .build());

        Long updateId = save.getId();
        String expectedTitle = "updateTitle";
        String expectedContent = "updateContent";

        PostsUpdateRequestDto requestDto = PostsUpdateRequestDto.builder()
                .title(expectedTitle)
                .content(expectedContent)
                .build();

        String url =  "http://localhost:" + port + "/api/v1/posts" + "/" + updateId;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<PostsUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto, headers);

        // When
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);

        // Then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan("0");

        List<Posts> all = postsRepository.findAll();
        Posts posts = all.get(0);

        assertThat(posts.getTitle()).isEqualTo(expectedTitle);
        assertThat(posts.getContent()).isEqualTo(expectedContent);

    }

    @Test
    public void posts_get_one() {
        // Given
        String expectedTitle = "Hello World";
        String expectedContent = "My Body";
        String expectedAuthor = "PS AS";
        Posts posts = Posts.builder()
                .title(expectedTitle)
                .content(expectedContent)
                .author(expectedAuthor).build();
        Posts save = postsRepository.save(posts);

        // When
        String url = "http://localhost:" + port + "/api/v1/posts/" + save.getId();

        ResponseEntity<PostsResponseDto> response = restTemplate.exchange(url, HttpMethod.GET, null, PostsResponseDto.class);

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getTitle()).isEqualTo(expectedTitle);
        assertThat(response.getBody().getContent()).isEqualTo(expectedContent);
        assertThat(response.getBody().getAuthor()).isEqualTo(expectedAuthor);

    }

    @Test
    public void delete_posts() {

    }
}