package org.example.bai_tap_1.util;



import org.example.bai_tap_1.entity.Song;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Map;

public class SongValidateUtil implements Validator {

    private static final int MIN_DURATION_SECONDS = 30;
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Song song = (Song) target;
        if (song.getTitle() == null || song.getTitle().isEmpty()) {
            errors.rejectValue("title", "title.empty", "Tiêu đề bài hát không được để trống.");
        }

        if (song.getArtist() == null || song.getArtist().isEmpty()) {
            errors.rejectValue("artist", "artist.empty", "Tên nghệ sĩ không được để trống.");
        }

        // --- 2. Validation cho trường Metadata (JSON) ---
        Map<String, Object> metadata = song.getMetadata();

        if (metadata != null && metadata.containsKey("duration_sec")) {
            Object durationValue = metadata.get("duration_sec");

            try {
                // Kiểm tra xem giá trị có phải là số nguyên (hoặc có thể ép kiểu thành số) không
                int duration = ((Number) durationValue).intValue();
                // Quy tắc nghiệp vụ: Thời lượng phải lớn hơn MIN_DURATION_SECONDS
                if (duration < MIN_DURATION_SECONDS) {
                    errors.rejectValue("metadata", null,
                            "Thời lượng bài hát (" + duration + "s) phải lớn hơn " + MIN_DURATION_SECONDS + " giây.");
                }
            } catch (ClassCastException | NullPointerException e) {
                // Xử lý nếu giá trị 'duration_sec' không phải là số hoặc null
                errors.rejectValue("metadata", null, "Thời lượng bài hát phải là một giá trị số hợp lệ.");
            }
        }

    }
}
