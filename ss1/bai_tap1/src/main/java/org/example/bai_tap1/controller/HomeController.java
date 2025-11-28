package org.example.bai_tap1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model) {
        // Khởi tạo giá trị mặc định (tuỳ ý)
        model.addAttribute("rate", "");
        model.addAttribute("usd", "");
        model.addAttribute("error", "");
        return "home";
    }

    @PostMapping("/convert")
    public String convert(@RequestParam("rate") String rateStr,
                          @RequestParam("usd") String usdStr,
                          Model model) {
        try {
            BigDecimal rate = new BigDecimal(rateStr.trim());
            BigDecimal usd = new BigDecimal(usdStr.trim());
            BigDecimal vnd = usd.multiply(rate);

            model.addAttribute("rate", rate);
            model.addAttribute("usd", usd);
            model.addAttribute("vnd", vnd);
            model.addAttribute("error", "");
            return "result";
        } catch (Exception e) {
            model.addAttribute("error", "Giá trị không hợp lệ. Vui lòng nhập số hợp lệ.");
            model.addAttribute("rate", rateStr);
            model.addAttribute("usd", usdStr);
            return "home";
        }
    }
}
