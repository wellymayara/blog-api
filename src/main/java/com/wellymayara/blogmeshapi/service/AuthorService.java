package com.wellymayara.blogmeshapi.service;

import com.wellymayara.blogmeshapi.model.Author;
import com.wellymayara.blogmeshapi.model.Post;

import java.util.List;

public interface AuthorService {
    Author registerAuthor(Author author);
    List<Author> getAllAuthors();

    List<Post> getPostsByAuthor(Long authorId);
}
