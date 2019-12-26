package com.psawesome.awsspringboot.web;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

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
        Assertions.assertThat(body).contains("스프링 부트로 시작하는 웹 서비스");
    }


}
