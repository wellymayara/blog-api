package com.wellymayara.blogmeshapi.controller;

import com.wellymayara.blogmeshapi.exception.BadRequestException;
import com.wellymayara.blogmeshapi.model.Post;
import com.wellymayara.blogmeshapi.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        return ResponseEntity.ok(postService.createPost(post));
    }

    @GetMapping
    public ResponseEntity<Page<Post>> getAllPosts(Pageable pageable) {
        return ResponseEntity.ok(postService.getPosts(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        return ResponseEntity.ok(postService.getPostById(id)
                .orElseThrow(() -> new BadRequestException("Post not found")));
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Post>> getPostsByCategory(@PathVariable String category) {
        List<Post> posts = postService.getPostsByCategory(category)
                .orElseThrow(() -> new BadRequestException("Category not found"));
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/category")
    public ResponseEntity<List<String>> getCategories() {
        return ResponseEntity.ok(postService.getDistinctCategory());
    }
}
