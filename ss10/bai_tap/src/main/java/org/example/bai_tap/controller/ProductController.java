package org.example.bai_tap.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.example.bai_tap.entity.Cart;
import org.example.bai_tap.entity.Product;
import org.example.bai_tap.serivce.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {

    // Tên của Cookie dùng để lưu số lượt xem
    private static final String VIEW_COUNT_COOKIE = "viewCount";

    // Cookie này sẽ tồn tại trong 30 ngày (tính bằng giây)
    private static final int COOKIE_MAX_AGE = 30 * 24 * 60 * 60;

    /**
     * Phương thức này xử lý logic đếm lượt xem:
     * 1. Đọc giá trị "viewCount" từ Cookie (nếu có).
     * 2. Tăng giá trị đếm lên 1.
     * 3. Thiết lập lại Cookie mới với giá trị đã tăng.
     */
    @GetMapping("/shop")
    public String viewCounter(
            // @CookieValue sẽ tìm Cookie "viewCount". Dùng Optional để xử lý trường hợp không tìm thấy.
            @CookieValue(value = VIEW_COUNT_COOKIE, required = false)
            Optional<String> viewCountCookieValue,
            HttpServletResponse response,
            Model model) {

        int currentCount = 0;

        // --- 1. ĐỌC COOKIE VÀ TÍNH TOÁN ---
        if (viewCountCookieValue.isPresent()) {
            try {
                // Lấy giá trị chuỗi từ Cookie và chuyển đổi sang số nguyên
                currentCount = Integer.parseInt(viewCountCookieValue.get());
            } catch (NumberFormatException e) {
                // Xử lý lỗi nếu giá trị Cookie không hợp lệ (ví dụ: bị chỉnh sửa)
                currentCount = 0;
            }
        }

        // --- 2. TĂNG GIÁ TRỊ ĐẾM ---
        currentCount++;

        // --- 3. TẠO VÀ GỬI COOKIE MỚI ---

        // Tạo Cookie mới với giá trị đã tăng
        Cookie viewCookie = new Cookie(VIEW_COUNT_COOKIE, String.valueOf(currentCount));

        // Thiết lập thời gian sống (30 ngày)
        viewCookie.setMaxAge(COOKIE_MAX_AGE);

        // Thiết lập phạm vi cho toàn bộ ứng dụng
        viewCookie.setPath("/");

        // Khuyến nghị bảo mật
        viewCookie.setHttpOnly(true);

        // Thêm Cookie vào Response để gửi về trình duyệt
        response.addCookie(viewCookie);

        // --- 4. TRẢ KẾT QUẢ VỀ VIEW ---
        model.addAttribute(VIEW_COUNT_COOKIE, currentCount);
        model.addAttribute("message", "Chào mừng! Đây là lần xem thứ " + currentCount + " của bạn trong 30 ngày qua.");
        model.addAttribute("products", productService.findAll());
        return "/shop"; // Trả về view có tên là view_page.html
    }



    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }


    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id,
                            @ModelAttribute(name = "cart") Cart cart,
                            @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error_404";
        }
        if (action.equals("show")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }
}