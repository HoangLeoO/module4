package org.example.bai_tap_1.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;
import lombok.*;

// Dùng lại Custom Validator đã tạo cho genre

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SongFormDTO {

    // --- Các trường được ánh xạ trực tiếp (Đã có validation) ---
    @NotBlank(message = "Tên bài hát không được để trống.")
    @Size(max = 800, message = "Tên bài hát không được vượt quá 800 ký tự.")
    private String title;

    @NotBlank(message = "Nghệ sĩ thể hiện không được để trống.")
    @Size(max = 300, message = "Tên nghệ sĩ không được vượt quá 300 ký tự.")
    private String artist;

    // --- Trường Metadata được ánh xạ trực tiếp (Thêm vào DTO) ---
    @NotBlank(message = "Thể loại nhạc không được để trống.")
    @Size(max = 1000, message = "Thể loại nhạc không được vượt quá 1000 ký tự.")
    private String genre; // Trường genre lấy từ form

    // Thêm trường durationSec để dễ dàng validate
    @Min(value = 1, message = "Thời lượng phải lớn hơn 0.")
    private Integer durationSec;
}