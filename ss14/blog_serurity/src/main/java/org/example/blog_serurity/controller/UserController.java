package org.example.blog_serurity.controller;

import org.example.blog_serurity.entity.Blog;
import org.example.blog_serurity.service.blog.IBlogService;
import org.example.blog_serurity.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequestMapping("/users/")
public class UserController {
    @Autowired
    private IUserService userService;

    @Autowired
    private IBlogService blogService;

    @GetMapping("detail")
    public String showDetail(
            Principal principal,
            Model model,
            @RequestParam(name = "page" ,defaultValue = "0",required = false) int page,
            @RequestParam(name = "size" ,defaultValue = "2",required = false ) int size
            ){
        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by(Sort.Direction.DESC, "createdAt")
        );
        Long authorId = userService.getById(principal.getName()).getId();
        Page<Blog> blogs =  blogService.getAllBlogByAuthorId(authorId,pageable);
        model.addAttribute("blogs",blogs);
        model.addAttribute("user",userService.getById(principal.getName()));
        return "user/detail-user";
    }
}
