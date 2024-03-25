package com.wellymayara.blogmeshapi.controller;

import com.wellymayara.blogmeshapi.model.Author;
import com.wellymayara.blogmeshapi.model.Post;
import com.wellymayara.blogmeshapi.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/author")
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping
    public ResponseEntity<Author> createPost(@RequestBody Author author) {
        return ResponseEntity.ok(authorService.registerAuthor(author));
    }

    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors() {
        return  ResponseEntity.ok(authorService.getAllAuthors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Post>> getPostsByAuthor(@PathVariable long authorId) {
        return ResponseEntity.ok(authorService.getPostsByAuthor(authorId));
    }
}
