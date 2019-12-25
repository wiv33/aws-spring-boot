package com.psawesome.awsspringboot.web;

import com.psawesome.awsspringboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * package: com.psawesome.awsspringboot.web
 * author: PS
 * DATE: 2019-12-25 수요일 15:04
 */

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto getHelloResponseDto(@RequestParam String name, @RequestParam int amount) {
        return new HelloResponseDto(name, amount);
    }
}
