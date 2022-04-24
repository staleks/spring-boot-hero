package com.example.demo.domain.cms;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostComment {

    private Long id;
    private Post post;
    private String name;
    private String email;
    private String body;

    private PostComment(final String name, final String email, final String body, final Post post) {
        this.name = name;
        this.email = email;
        this.body = body;
        this.post = post;
    }

    public static PostComment create(final String name, final String email, final String body, final Post post) {
        return new PostComment(name, email, body, post);
    }

}
