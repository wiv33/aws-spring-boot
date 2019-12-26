package com.psawesome.awsspringboot.web;

import com.psawesome.awsspringboot.service.posts.PostsService;
import com.psawesome.awsspringboot.web.dto.PostsResponseDto;
import com.psawesome.awsspringboot.web.dto.PostsSaveRequestDto;
import com.psawesome.awsspringboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * package: com.psawesome.awsspringboot.web
 * author: PS
 * DATE: 2019-12-25 수요일 17:27
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/posts")
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {

        return postsService.save(requestDto);
    }

    @PutMapping("/{id}")
    public Long update(@PathVariable(name = "id") Long id, @RequestBody PostsUpdateRequestDto dto) {
        return postsService.update(id, dto);
    }

    @GetMapping("/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }
}
