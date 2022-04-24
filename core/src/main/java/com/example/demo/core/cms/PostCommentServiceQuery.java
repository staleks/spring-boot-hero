package com.example.demo.core.cms;

import com.example.demo.core.util.PagingRequest;
import com.example.demo.core.util.PagingResponse;
import com.example.demo.domain.cms.PostComment;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PostCommentServiceQuery implements PostCommentQuery {

    private final PostCommentPersistencePort postCommentPersistencePort;

    @Override
    public PagingResponse<PostComment> findAll(final PagingRequest pagingRequest) {
        return postCommentPersistencePort.findAll(pagingRequest);
    }

}
