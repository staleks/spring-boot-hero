package com.example.demo.persistence.cms.adapter;

import com.example.demo.core.cms.PostPersistencePort;
import com.example.demo.core.util.PagingRequest;
import com.example.demo.core.util.PagingResponse;
import com.example.demo.domain.cms.Post;
import com.example.demo.persistence.cms.repository.JpaPostRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

import static com.example.demo.persistence.cms.mapper.PostMapper.POST_JPA_ADAPTER_MAPPER;

@RequiredArgsConstructor
public class PostPersistenceAdapter implements PostPersistencePort {

    private final JpaPostRepository jpaPostRepository;

    @Override
    public Optional<Post> findById(final Long postId) {
        var jpaPost = jpaPostRepository.findById(postId);
        if (jpaPost.isPresent()) {
            return Optional.of(POST_JPA_ADAPTER_MAPPER.entityToDomain(jpaPost.get()));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public PagingResponse<Post> findAll(final PagingRequest pagingRequest) {
        return null;
    }

    @Override
    public Post create(final Post country) {
        return null;
    }
}
