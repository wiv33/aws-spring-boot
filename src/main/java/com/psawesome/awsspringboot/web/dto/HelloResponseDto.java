package com.psawesome.awsspringboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * package: com.psawesome.awsspringboot.web.dto
 * author: PS
 * DATE: 2019-12-25 수요일 15:40
 */
@Getter
@RequiredArgsConstructor
public class HelloResponseDto {

    private Long id;

    private final String name;
    private final int amount;
}
