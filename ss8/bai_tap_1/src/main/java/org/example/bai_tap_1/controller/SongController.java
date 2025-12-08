package org.example.bai_tap_1.controller;

import jakarta.validation.Valid;
import org.example.bai_tap_1.dto.SongFormDTO;
import org.example.bai_tap_1.entity.Song;
import org.example.bai_tap_1.service.ISongService;
import org.example.bai_tap_1.util.SongValidateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;

@Controller
public class SongController {

    private final ISongService songService;

    public SongController(ISongService songService) {
        this.songService = songService;
    }


    @GetMapping(value = "/song")
    public String song(Model model) {
        model.addAttribute("songs", songService.getAll());
        return "song";
    }
        @GetMapping(value = "/add-song")
        public String addSong(Model model) {
            model.addAttribute("song", new SongFormDTO());
            model.addAttribute("durationSec", 0);
            model.addAttribute("genre", "");
            return "add-song";
        }


//    @PostMapping(value = "/add-song")
//    public String saveSong(
//            @Valid @ModelAttribute("song") Song song,
//            BindingResult bindingResult,
//            RedirectAttributes redirectAttributes,
//            @ModelAttribute("durationSec") Integer durationSec,
//            @ModelAttribute("genre") String genre
//    ) {
//        new SongValidateUtil().validate(song, bindingResult);
//        if (bindingResult.hasErrors()) {
//            return "add-song";
//        }
//
//        Map<String, Object> metadata = new HashMap<>();
//        metadata.put("duration_sec", durationSec != null ? durationSec : 0);
//        metadata.put("genre", genre);
//        metadata.put("is_explicit", false);
//        song.setMetadata(metadata);
//
//        songService.save(song);
//        redirectAttributes.addFlashAttribute("successMessage", "Đã thêm bài hát '" + song.getTitle() + "' thành công!");
//
//        return "redirect:/song";
//    }

    @PostMapping(value = "/add-song")
    public String saveSong(
            @Valid @ModelAttribute("song") SongFormDTO dto, // Nhận DTO và Validation chạy trên DTO
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) {
        // --- 1. Validation tự động chạy trên DTO ---
        if (bindingResult.hasErrors()) {
            // Nếu có lỗi, trả lại form với DTO để hiển thị lỗi
            return "add-song";
        }

        // --- 2. CHUYỂN ĐỔI DTO SANG ENTITY VÀ GÁN METADATA ---

        Song song = new Song();
        song.setTitle(dto.getTitle());
        song.setArtist(dto.getArtist());

        // Tạo Map metadata từ dữ liệu đã được validate trong DTO
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("duration_sec", dto.getDurationSec());
        metadata.put("genre_text", dto.getGenre()); // Lưu genre vào metadata
        metadata.put("is_explicit", false);
        song.setMetadata(metadata);
        songService.save(song);

        redirectAttributes.addFlashAttribute("successMessage", "Đã thêm bài hát '" + dto.getTitle() + "' thành công!");

        return "redirect:/song";
    }
}
