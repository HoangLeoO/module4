package org.example.blog_serurity.service.user;


import org.example.blog_serurity.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {

    User getById(String username);

    Page<User> getAllUser(Pageable pageable, String title);

    boolean registerUser(User user);

}
