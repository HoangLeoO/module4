package org.example.bai_tap_1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.bai_tap_1.converter.JsonToMapConverter;


import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String artist;

    // Lưu các thông tin mở rộng dạng JSON
    @Column(columnDefinition = "json")
    @Convert(converter = JsonToMapConverter.class)
    private Map<String, Object> metadata;
}
