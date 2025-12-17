package org.example.blog_serurity.controller;

import org.example.blog_serurity.entity.User;
import org.example.blog_serurity.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller()
public class AutherController {

    @Autowired
    private IUserService userService;



    @GetMapping("")
    public String index(Model model, Authentication authentication){
        String username = authentication.getName();
        String roles = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .reduce("", (a,b) -> a + " " + b);
        System.out.println(roles);
        return "index";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @GetMapping("register")
    public String registerPage(Model model){
        model.addAttribute("user",new User());
        return "register";
    }

    @PostMapping("register")
    public String saveUser(@Validated @ModelAttribute User user, RedirectAttributes redirectAttributes, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "register";
        }
        userService.registerUser(user);
        redirectAttributes.addFlashAttribute("messger","Đăng ký thành công!");
        return "redirect:/login";
    }
}
