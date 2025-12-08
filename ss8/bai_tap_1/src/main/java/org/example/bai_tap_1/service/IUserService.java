package org.example.bai_tap_1.service;

import org.example.bai_tap_1.entity.User;

import java.util.List;

public interface IUserService {
    List<User> getAll();
    User save(User user);
}
