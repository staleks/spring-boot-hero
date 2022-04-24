package com.example.demo.domain.cms;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
@Data
@NoArgsConstructor
public class Post {
    private Long id;
    private Long userId;
    private String title;
    private String body;
    private Set<PostComment> comments;

    private Post(final Long userId, final String title, final String body) {
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public static Post create(final Long userId, final String title, final String body) {
        return new Post(userId, title, body);
    }

    public void addComment(final PostComment comment) {
        if (comments == null) {
            this.comments = new HashSet<>();
        }
        this.comments.add(comment);
    }

}
