package org.example.blog_serurity.service.blog;

import org.example.blog_serurity.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {

    Blog getById(Long id);

    void save(Blog blog);

    void update(Blog blog);

    Page<Blog> getAllBlogByAuthorId(Long authorId, Pageable pageable);
}
