package com.example.demo.persistence.cms.adapter;

import com.example.demo.core.cms.PostPersistencePort;
import com.example.demo.core.util.PagingRequest;
import com.example.demo.core.util.PagingResponse;
import com.example.demo.domain.cms.Post;
import com.example.demo.domain.cms.PostComment;
import com.example.demo.persistence.cms.model.JpaPost;
import com.example.demo.persistence.cms.model.JpaPostComment;
import com.example.demo.persistence.cms.repository.JpaPostRepository;
import com.example.demo.persistence.util.PageRequestUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
public class PostPersistenceAdapter implements PostPersistencePort {

    private final JpaPostRepository jpaPostRepository;

    @Override
    public Optional<Post> findById(final Long postId) {
        var jpaPost = jpaPostRepository.findById(postId);
        if(jpaPost.isPresent()) {
            return Optional.of(mapPostToEntityDomain(jpaPost.get()));
        } else {
            return Optional.empty();
        }
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public PagingResponse<Post> findAll(final PagingRequest pagingRequest) {
        var dbPosts = jpaPostRepository.findAll(PageRequestUtil.fromPageRequestToPageable(pagingRequest));
        List<Post> postsList = new ArrayList<>();
        for(JpaPost jpaPostItem: dbPosts.getContent()) {
            postsList.add(mapPostToEntityDomain(jpaPostItem));
        }
        return new PagingResponse<>(postsList, dbPosts.getTotalPages(), pagingRequest.getPage(), pagingRequest.getSize());
    }

    @Override
    public Post create(final Post country) {
        return null;
    }

    private Post mapPostToEntityDomain(final JpaPost jpaPost) {
        Post post = new Post();
        post.setId(jpaPost.getId());
        post.setUserId(jpaPost.getUserId());
        post.setTitle(jpaPost.getTitle());
        post.setBody(jpaPost.getBody());
        for(JpaPostComment jpaPostCommentItem: jpaPost.getComments()) {
            post.addComment(mapPostCommentToEntityDomain(jpaPostCommentItem));
        }
        return post;
    }

    private PostComment mapPostCommentToEntityDomain(final JpaPostComment jpaPostComment) {
        PostComment postComment = new PostComment();
        postComment.setId(jpaPostComment.getId());
        postComment.setEmail(jpaPostComment.getEmail());
        postComment.setName(jpaPostComment.getName());
        postComment.setBody(jpaPostComment.getBody());
        return postComment;
    }

}
