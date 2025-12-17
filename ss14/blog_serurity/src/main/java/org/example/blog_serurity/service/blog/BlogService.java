package org.example.blog_serurity.service.blog;

import org.example.blog_serurity.entity.Blog;
import org.example.blog_serurity.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements IBlogService{

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Blog getById(Long id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void update(Blog blog) {
        if (getById(blog.getId()) != null){
            blogRepository.save(blog);
        }
    }

    @Override
    public Page<Blog> getAllBlogByAuthorId(Long authorId, Pageable pageable) {
        return blogRepository.findBlogByAuthor_Id(authorId,pageable);
    }
}
