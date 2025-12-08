package org.example.bai_tap_1.service;

import org.example.bai_tap_1.entity.Song;

import java.util.List;

public interface ISongService {
    List<Song> getAll();
    Song save(Song song);
}
