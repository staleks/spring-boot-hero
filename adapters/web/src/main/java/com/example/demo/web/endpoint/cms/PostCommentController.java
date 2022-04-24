package com.example.demo.web.endpoint.cms;

import com.example.demo.core.cms.PostCommentQuery;
import com.example.demo.core.util.PagingRequest;
import com.example.demo.core.util.PagingResponse;
import com.example.demo.domain.cms.Post;
import com.example.demo.domain.cms.PostComment;
import com.example.demo.domain.geo.City;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.example.demo.core.util.PagingRequest.PAGE;
import static com.example.demo.core.util.PagingRequest.SIZE;
import static com.example.demo.core.util.PagingRequest.SORT;
import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
public class PostCommentController {
    private static final String POSTS_COMMENTS_ENDPOINT = "/cms/post-comments";
    private final PostCommentQuery postCommentQuery;

    @GetMapping(value = POSTS_COMMENTS_ENDPOINT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PagingResponse<PostComment>> handleGetAll(@RequestParam(value = PAGE, required = false) Integer page,
                                                             @RequestParam(value = SIZE, required = false) Integer size,
                                                             @RequestParam(value = SORT, required = false) String sort) {
        var postComments = postCommentQuery.findAll(PagingRequest.of(page, size, sort));
        return ok(new PagingResponse<PostComment>(postComments.getItems(), postComments.getTotalPages(), postComments.getPage(), postComments.getSize()));
    }

}
