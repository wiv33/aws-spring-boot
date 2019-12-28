package com.psawesome.awsspringboot.config.auth.dto;

import com.psawesome.awsspringboot.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

/**
 * package: com.psawesome.awsspringboot.config.auth.dto
 * author: PS
 * DATE: 2019-12-28 토요일 00:01
 */
@Getter
public class SessionUser implements Serializable {

    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }

}
