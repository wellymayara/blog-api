package com.wellymayara.blogmeshapi.service;

import com.wellymayara.blogmeshapi.model.Author;
import com.wellymayara.blogmeshapi.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    Post createPost (Post post);
    List<Post> getPosts();

    Optional<Post> getPostById(Long id);

}
