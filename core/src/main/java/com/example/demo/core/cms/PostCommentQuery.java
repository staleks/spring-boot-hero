package com.example.demo.core.cms;

import com.example.demo.core.util.PagingRequest;
import com.example.demo.core.util.PagingResponse;
import com.example.demo.domain.cms.PostComment;

public interface PostCommentQuery {

    PagingResponse<PostComment> findAll(PagingRequest pagingRequest);

}
