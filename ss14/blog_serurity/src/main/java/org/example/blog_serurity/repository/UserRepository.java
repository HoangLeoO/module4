package org.example.blog_serurity.repository;

import org.example.blog_serurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
   User findByUsername(String username);
}
