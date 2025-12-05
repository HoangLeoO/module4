package org.example.blog_v2.repository;

import org.example.blog_v2.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    Page<Blog> findAllByCategory_Id(Integer categoryId, Pageable pageable);

    @Modifying
    @Query(value = "update blog as b set b.title = :title , b.content = :content where b.id = :id" ,nativeQuery = true)
    void updateBlog(@Param("title") String title,@Param("content") String content,@Param("id") Integer id );
}
