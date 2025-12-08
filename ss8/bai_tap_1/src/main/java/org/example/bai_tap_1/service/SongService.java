package org.example.bai_tap_1.service;

import org.example.bai_tap_1.entity.Song;
import org.example.bai_tap_1.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService{

    @Autowired
    private ISongRepository songRepository;

    @Override
    public List<Song> getAll() {
        return songRepository.findAll();
    }

    @Override
    public Song save(Song song) {
        return songRepository.save(song);
    }
}
