package com.wellymayara.blogmeshapi.service.impl;

import com.wellymayara.blogmeshapi.model.Author;
import com.wellymayara.blogmeshapi.model.Post;
import com.wellymayara.blogmeshapi.repository.AuthorRepository;
import com.wellymayara.blogmeshapi.repository.PostRepository;
import com.wellymayara.blogmeshapi.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

     public Post createPost(Post post) {
        return  postRepository.save(post);
    };

     @Override
    public List<Post> getPosts() {
        return postRepository.findAll();
    };

     @Override
    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    };

}
