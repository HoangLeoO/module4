package org.example.blog_serurity.controller;

import org.example.blog_serurity.entity.Blog;
import org.example.blog_serurity.service.blog.IBlogService;
import org.example.blog_serurity.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blogs/")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private IUserService userService;

    @GetMapping("create")
    public String showForm(Model model) {
        model.addAttribute("blog", new Blog());
        return "/blog/form-blog-user";
    }

    @GetMapping("detail/{id}")
    public String showDetail(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("blog", blogService.getById(id));
        return "blog/form-blog-user";
    }

    @PostMapping("create")
    public String save(@Validated @ModelAttribute Blog blog, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model, Authentication authentication) {
        String username = authentication.getName();
        if (bindingResult.hasErrors()){
            model.addAttribute("blog",blog);
            return "blog/form-blog-user";
        }
        if (blog.getStatus().equals("DRAFT")){
            redirectAttributes.addFlashAttribute("mess","Lưu nháp thành công!");
        }else {
            redirectAttributes.addFlashAttribute("mess","Đăng bài thành công!");
        }
        blog.setAuthor(userService.getById(username));
        blogService.save(blog);
        return "redirect:/blogs/detail/" + blog.getId();
    }

    @PostMapping("edit")
    public String edit(@Validated @ModelAttribute Blog blog, BindingResult bindingResult,RedirectAttributes redirectAttributes,Model model,Authentication authentication) {
        String username = authentication.getName();
        if (bindingResult.hasErrors()){
            model.addAttribute("blog",blog);
            return "blog/form-blog-user";
        }
        blog.setAuthor(userService.getById(username));
        blogService.update(blog);
        redirectAttributes.addFlashAttribute("mess","Chỉnh sửa thành công!");
        return "redirect:/blogs/detail/" + blog.getId();
    }

}
