package com.psawesome.awsspringboot.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.psawesome.awsspringboot.web.dto.PostsSaveRequestDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
            .build();
}

    @Test
    public void 메인페이지_로딩() {
        // When
        String body = this.restTemplate.getForObject("/", String.class);

        // Then
        assertThat(body).contains("스프링 부트로 시작하는 웹 서비스 Ver.2");
    }


    @Test
    @WithMockUser(roles = "USER")
    public void postsSavePageTest() throws Exception {
        // When
//        String body = restTemplate.getForObject("/posts/save", String.class);
        String url = "/posts/save";
        mvc.perform(get(url)
                .contentType(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
//                .andDo(print())
        .andExpect(result -> result.getResponse().getContentAsString().contains("게시글 등록"));

        // Then
//        assertThat(body).contains("게시글 등록");

    }

    @Test
    @WithMockUser(roles = "USER")
    public void postsUpdatePageTest() throws Exception {
        // Given
        PostsSaveRequestDto dto = PostsSaveRequestDto
                .builder()
                .title("Hello World")
                .content("My Body")
                .author("PS AS")
                .build();

        String url = "/api/v1/posts";

        MvcResult mvcResult = mvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(content().string("1"))
//                .andDo(print())
                .andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();
//
        url = "/posts/update/" + contentAsString;

        mvc.perform(get(url)
                .contentType(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
//                .andDo(print())
        ;

//        HttpEntity<PostsSaveRequestDto> entity = new HttpEntity<>(dto);
//        ResponseEntity<Long> responseEntity = restTemplate.postForEntity("/api/v1/posts", entity, Long.class);
//        long valueId = responseEntity.getBody().longValue();
//
//        // When
//        String body = restTemplate.getForObject("/posts/update/ " + valueId, String.class);
//
//        // Then
//        assertThat(body).contains("게시글 수정");
    }


}
