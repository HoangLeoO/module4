package org.example.demo_fire_base.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageInfoRepository extends JpaRepository<ImageInfo, Long> {
}