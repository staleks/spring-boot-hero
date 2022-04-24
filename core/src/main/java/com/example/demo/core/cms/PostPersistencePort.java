package com.example.demo.core.cms;

import com.example.demo.core.util.PagingRequest;
import com.example.demo.core.util.PagingResponse;
import com.example.demo.domain.cms.Post;

import java.util.Optional;

public interface PostPersistencePort {

    Optional<Post> findById(final Long postId);

    PagingResponse<Post> findAll(final PagingRequest pagingRequest);

    Post create(final Post country);

}
