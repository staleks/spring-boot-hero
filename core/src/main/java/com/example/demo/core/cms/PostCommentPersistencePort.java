package com.example.demo.core.cms;

import com.example.demo.core.util.PagingRequest;
import com.example.demo.core.util.PagingResponse;
import com.example.demo.domain.cms.PostComment;

public interface PostCommentPersistencePort {

    PagingResponse<PostComment> findAll(final PagingRequest pagingRequest);
}
