package com.example.demo.persistence.cms.adapter;

import com.example.demo.core.cms.PostCommentPersistencePort;
import com.example.demo.core.util.PagingRequest;
import com.example.demo.core.util.PagingResponse;
import com.example.demo.domain.cms.PostComment;
import com.example.demo.persistence.cms.repository.JpaPostCommentRepository;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class PostCommentPersistenceAdapter implements PostCommentPersistencePort {

    private final JpaPostCommentRepository jpaPostCommentRepository;

    @Override
    public PagingResponse<PostComment> findAll(final PagingRequest pagingRequest) {
        return null;
    }

}
