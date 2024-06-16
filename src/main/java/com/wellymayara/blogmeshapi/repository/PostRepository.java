package com.wellymayara.blogmeshapi.repository;

import com.wellymayara.blogmeshapi.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<List<Post>> findByCategory(String category);

    @Query("SELECT DISTINCT p.category FROM Post p")
    List<String> findDistinctCategory();
}
