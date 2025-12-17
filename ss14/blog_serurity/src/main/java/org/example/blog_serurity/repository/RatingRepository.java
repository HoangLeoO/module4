package org.example.blog_serurity.repository;

import org.example.blog_serurity.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating,Long> {
}
