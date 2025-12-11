package org.example.blog_v2.service;


import org.example.blog_v2.dto.BlogDTO;
import org.example.blog_v2.entity.Blog;
import org.example.blog_v2.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BlogService implements IBlogService{

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Page<Blog> findAllByCategory_Id(Integer categoryId, Pageable pageable) {
        return blogRepository.findAllByCategory_Id(categoryId,pageable);
    }

    @Override
    public Page<Blog> getAllBlogs(int page, int size, Sort createTime) {
        Pageable pageable = PageRequest.of(page, size,createTime);
        return blogRepository.findAll(pageable);
    }

    @Override
    public void saveBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog getBlogById(Integer id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteBlogById(Integer id) {
        blogRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void updateBlog(Blog blog) {
        blogRepository.updateBlog(blog.getTitle(),blog.getContent(),blog.getId());
    }

    @Override
    public Page<BlogDTO> getAllBlogs(String nameBlog, int categoryId, Pageable pageable) {
        return blogRepository.getAllBlogs(nameBlog,categoryId,pageable);
    }
}
