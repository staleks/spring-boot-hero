package com.example.demo.web.endpoint.cms;

import com.example.demo.core.cms.PostQuery;
import com.example.demo.domain.cms.Post;
import com.example.demo.domain.geo.Country;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.notFound;


@RestController
@RequiredArgsConstructor
public class PostController {

    private static final String POSTS_ENDPOINT_FOR_ID = "/cms/posts/{postId}";

    private final PostQuery postQuery;

    @GetMapping(value = POSTS_ENDPOINT_FOR_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Post> handleGetOne(@PathVariable("postId") Long postId) {
        return postQuery.findById(postId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> notFound().build());
    }

}
