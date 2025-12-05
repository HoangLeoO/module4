package org.example.blog_v2.service;



import org.example.blog_v2.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface IBlogService {
    Page<Blog> findAllByCategory_Id(Integer categoryId, Pageable pageable);
    Page<Blog> getAllBlogs(int page, int size, Sort createTime);
    void saveBlog(Blog blog);
    Blog getBlogById(Integer id);
    void deleteBlogById(Integer id);
    void updateBlog(Blog blog);
}
