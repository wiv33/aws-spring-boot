package com.psawesome.awsspringboot.web.dto;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * package: com.psawesome.awsspringboot.web.dto
 * author: PS
 * DATE: 2019-12-25 수요일 15:37
 */

public class HelloResponseDtoTest {

    @Test
    public void lombokTest() {
        // given
        String name = "test";
        int amount = 1000;

        // When
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        // Then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
