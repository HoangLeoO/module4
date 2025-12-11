package org.example.blog_v2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.blog_v2.entity.Category;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BlogDTO {
    private Integer id;
    private String title;
    private String content;
    private Instant createTime;
    private String categoryName;
}
