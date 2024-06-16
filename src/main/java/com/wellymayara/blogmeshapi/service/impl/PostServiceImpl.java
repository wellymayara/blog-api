package com.wellymayara.blogmeshapi.service.impl;

import com.wellymayara.blogmeshapi.model.Post;
import com.wellymayara.blogmeshapi.repository.PostRepository;
import com.wellymayara.blogmeshapi.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Override
    public Post createPost(Post post) {
        post.setPublishDate(LocalDateTime.now());
        return postRepository.save(post);
    }

    @Override
    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    @Override
    public Page<Post> getPosts(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @Override
    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public Optional<List<Post>> getPostsByCategory(String category) {
        return postRepository.findByCategory(category);
    }

    @Override
    public List<String> getDistinctCategory() {
        return postRepository.findDistinctCategory();
    }
}
