package org.example.blog_serurity.repository;

import org.example.blog_serurity.entity.User;
import org.example.blog_serurity.entity.UserRole;
import org.example.blog_serurity.entity.UserRoleId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRoleRepository extends JpaRepository<UserRole, UserRoleId> {
    List<UserRole> findByUser(User user);
}
