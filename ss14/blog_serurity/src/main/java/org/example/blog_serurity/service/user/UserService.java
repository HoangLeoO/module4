package org.example.blog_serurity.service.user;

import org.example.blog_serurity.entity.User;
import org.example.blog_serurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getById(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Page<User> getAllUser(Pageable pageable, String title) {
        return null;
    }

    @Override
    public boolean registerUser(User user) {
        if (user == null){
            return false;
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }
}
