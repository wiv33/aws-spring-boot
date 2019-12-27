package com.psawesome.awsspringboot.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * package: com.psawesome.awsspringboot.domain.user
 * author: PS
 * DATE: 2019-12-27 금요일 23:19
 */
@Getter
@RequiredArgsConstructor
public enum Role {

    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER", "일반 사용자");

    private final String key;
    private final String title;
}
