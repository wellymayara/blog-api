package com.wellymayara.blogmeshapi.service.impl;

import com.wellymayara.blogmeshapi.exception.BadRequestException;
import com.wellymayara.blogmeshapi.model.Author;
import com.wellymayara.blogmeshapi.model.Post;
import com.wellymayara.blogmeshapi.repository.AuthorRepository;
import com.wellymayara.blogmeshapi.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    @Override
    public Author registerAuthor(Author author) {
        author.setRegisteredIn(LocalDateTime.now());
        return authorRepository.save(author);
    };
    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    };

    @Override
    public List<Post> getPostsByAuthor(Long authorId) {
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new BadRequestException("Author not found"));
        return author.getPosts();
    };
}
