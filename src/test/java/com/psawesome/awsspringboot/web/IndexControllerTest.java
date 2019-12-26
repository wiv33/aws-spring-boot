package com.psawesome.awsspringboot.web;

import com.psawesome.awsspringboot.domain.posts.PostsRepository;
import com.psawesome.awsspringboot.web.dto.PostsSaveRequestDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * package: com.psawesome.awsspringboot.web
 * author: PS
 * DATE: 2019-12-26 목요일 21:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IndexControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void 메인페이지_로딩() {
        // When
        String body = this.restTemplate.getForObject("/", String.class);

        // Then
        assertThat(body).contains("스프링 부트로 시작하는 웹 서비스 Ver.2");
    }


    @Test
    public void postsSavePageTest() {
        // When
        String body = restTemplate.getForObject("/posts/save", String.class);

        // Then
        assertThat(body).contains("게시글 등록");

    }

    @Test
    public void postsUpdatePageTest() {
        // Given
        PostsSaveRequestDto dto = PostsSaveRequestDto
                .builder()
                .title("Hello World")
                .content("My Body")
                .author("PS AS")
                .build();

        HttpEntity<PostsSaveRequestDto> entity = new HttpEntity<>(dto);
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity("/api/v1/posts", entity, Long.class);
        long valueId = responseEntity.getBody().longValue();

        // When
        String body = restTemplate.getForObject("/posts/update/ " + valueId, String.class);

        // Then
        assertThat(body).contains("게시글 수정");
    }


}
