package com.psawesome.awsspringboot.service.posts;

import com.psawesome.awsspringboot.domain.posts.Posts;
import com.psawesome.awsspringboot.domain.posts.PostsRepository;
import com.psawesome.awsspringboot.web.dto.PostsResponseDto;
import com.psawesome.awsspringboot.web.dto.PostsSaveRequestDto;
import com.psawesome.awsspringboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * package: com.psawesome.awsspringboot.service.posts
 * author: PS
 * DATE: 2019-12-25 수요일 17:27
 */
@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository repository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return repository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto dto) {
        Posts posts = repository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
        posts.update(dto.getTitle(), dto.getContent(), dto.getAuthor());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = repository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
        return new PostsResponseDto(entity);
    }
}
