package com.example.demo.core.cms;

import com.example.demo.core.util.PagingRequest;
import com.example.demo.core.util.PagingResponse;
import com.example.demo.domain.cms.Post;

import java.util.Optional;

public interface PostQuery {
    Optional<Post> findById(final Long postId);
    PagingResponse<Post> findAll(PagingRequest pagingRequest);
}
