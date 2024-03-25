package com.wellymayara.blogmeshapi.controller;

import com.wellymayara.blogmeshapi.exception.BadRequestException;
import com.wellymayara.blogmeshapi.model.Post;
import com.wellymayara.blogmeshapi.service.PostService;
import lombok.AllArgsConstructor;
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
    public ResponseEntity<List<Post>> getAllPosts() {
        return  ResponseEntity.ok(postService.getPosts());
    }

    @GetMapping("/:id")
    public ResponseEntity<Post> getPostById(Long id){
        return ResponseEntity.ok(postService.getPostById(id).orElseThrow(() -> new BadRequestException("post not found")));
    }



}
