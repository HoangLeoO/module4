package org.example.bai_tap_1.controller;

import jakarta.validation.Valid;
import org.example.bai_tap_1.entity.User;
import org.example.bai_tap_1.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/home")
    public String home(Model model) {
        model.addAttribute("users", userService.getAll());
        return "home";
    }

    @GetMapping(value = "/add")
    public String add(Model model) {
        model.addAttribute("user", new User());
        return "add";
    }

    @PostMapping(value = "/add")
    public String add(@Valid @ModelAttribute(name = "user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add";
        }
        userService.save(user);
        return "redirect:/home";
    }
}
