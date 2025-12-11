package org.example.blog_v2.controller;

import org.example.blog_v2.dto.BlogDTO;
import org.example.blog_v2.entity.Blog;
import org.example.blog_v2.entity.Category;
import org.example.blog_v2.service.IBlogService;
import org.example.blog_v2.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/blogs")
public class BlogRestController {

    private final IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    public BlogRestController(IBlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("")
    public ResponseEntity<Page<BlogDTO>> list(@RequestParam(defaultValue = "0", name = "page") Integer page) {
        int size = 5;
        Pageable pageable = PageRequest.of(page, size, Sort.by("createTime").descending());
        Page<BlogDTO> blogs1 = blogService.getAllBlogs("", 1, pageable);
        if (blogs1.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs1,HttpStatus.OK);
    }
    @GetMapping("/categorys")
    public ResponseEntity<List<Category>> listCategory(){
        List<Category> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories,HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Blog> getBlog(@PathVariable(name = "id") Integer id){
        Blog blog = blogService.getBlogById(id);
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }
}
