package org.example.blog_serurity.repository;

import org.example.blog_serurity.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
