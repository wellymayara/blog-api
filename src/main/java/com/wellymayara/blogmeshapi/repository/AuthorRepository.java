package com.wellymayara.blogmeshapi.repository;

import com.wellymayara.blogmeshapi.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
