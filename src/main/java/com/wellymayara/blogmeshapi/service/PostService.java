package com.wellymayara.blogmeshapi.service;

import com.wellymayara.blogmeshapi.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PostService {
    Post createPost(Post post);
    List<Post> getPosts();
    Page<Post> getPosts(Pageable pageable);
    Optional<Post> getPostById(Long id);
    Optional<List<Post>> getPostsByCategory(String category);
    List<String> getDistinctCategory();
}
