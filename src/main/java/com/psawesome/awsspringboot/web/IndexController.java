package com.psawesome.awsspringboot.web;

import com.psawesome.awsspringboot.domain.posts.PostsRepository;
import com.psawesome.awsspringboot.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * package: com.psawesome.awsspringboot.web
 * author: PS
 * DATE: 2019-12-26 목요일 21:48
 */
@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }
}
