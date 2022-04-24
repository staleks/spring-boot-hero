package com.example.demo.core.cms;

import com.example.demo.core.util.PagingRequest;
import com.example.demo.core.util.PagingResponse;
import com.example.demo.domain.cms.Post;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class PostServiceQuery implements PostQuery {

    private final PostPersistencePort postPersistencePort;

    @Override
    public Optional<Post> findById(final Long postId) {
        return postPersistencePort.findById(postId);
    }

    @Override
    public PagingResponse<Post> findAll(final PagingRequest pagingRequest) {
        return postPersistencePort.findAll(pagingRequest);
    }

}
