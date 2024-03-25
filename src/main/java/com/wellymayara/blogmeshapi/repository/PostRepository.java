package com.wellymayara.blogmeshapi.repository;

import com.wellymayara.blogmeshapi.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
