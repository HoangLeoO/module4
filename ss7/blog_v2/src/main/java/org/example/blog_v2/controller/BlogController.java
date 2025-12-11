package org.example.blog_v2.controller;

import org.example.blog_v2.dto.BlogDTO;
import org.example.blog_v2.entity.Blog;
import org.example.blog_v2.service.IBlogService;
import org.example.blog_v2.service.ICategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BlogController {
    private final IBlogService blogService;
    private final ICategoryService categoryService;

    public BlogController(IBlogService blogService, ICategoryService categoryService) {
        this.blogService = blogService;
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public String index(
            Model model,
            @RequestParam(defaultValue = "0",name = "page") Integer page){
        int size = 5;
//        Page<Blog> blogs = blogService.getAllBlogs(page, size, Sort.by("createTime").descending());
        Pageable pageable = PageRequest.of(page, size, Sort.by("createTime").descending());
        Page<BlogDTO> blogs1 = blogService.getAllBlogs("",1,pageable);
        model.addAttribute("blogs",blogs1);
        model.addAttribute("currentPage",page);
        model.addAttribute("totalPages",blogs1.getTotalPages());
        return "index";
    }

    @GetMapping("/create")
    public String add(Model model){
        model.addAttribute("blog",new Blog());
        model.addAttribute("categories",categoryService.getAllCategories());
        return "create";
    }
    @PostMapping("/create")
    public String saveAdd(@ModelAttribute Blog blog){
        blogService.saveBlog(blog);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") Integer id,Model model){
        model.addAttribute("blog",blogService.getBlogById(id));
        return "edit";
    }
    @PostMapping("/edit")
    public String saveEdit(@ModelAttribute Blog blog){
        blogService.updateBlog(blog);
        return "redirect:/";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") Integer id){
        blogService.deleteBlogById(id);
        return "redirect:/";
    }

}
