package org.example.bai_tap_1.repository;

import org.example.bai_tap_1.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISongRepository extends JpaRepository<Song, Long> {
}
