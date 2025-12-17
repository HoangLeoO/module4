package org.example.blog_serurity.service;

import jakarta.transaction.Transactional;
import org.example.blog_serurity.entity.UserRole;
import org.example.blog_serurity.entity.User;
import org.example.blog_serurity.repository.UserRepository;
import org.example.blog_serurity.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);
        if (user == null){
            System.out.println("User not found " + username );
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }
        System.out.println("Found User: " + user);
        List<UserRole> userRoles = userRoleRepository.findByUser(user);

        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();

        if (userRoles != null) {
            for (UserRole userRole : userRoles) {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + userRole.getRole().getName());
                grantList.add(authority);
            }
        }
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), grantList);

        return userDetails;
    }
}
