package com.delisting.demo.service.posts;

import com.delisting.demo.domain.posts.Posts;
import com.delisting.demo.domain.posts.PostsRepository;
import com.delisting.demo.web.dto.PostsResponseDto;
import com.delisting.demo.web.dto.PostsSaveRequestDto;
import com.delisting.demo.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() ->
            new IllegalArgumentException("�ش� �Խñ��� �����ϴ�. id="+id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("�ش� �Խñ��� �����ϴ�. id="+id));

        return new PostsResponseDto(entity);
    }
}
