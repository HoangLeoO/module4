package org.example.bai_tap_1.controller;

import org.example.bai_tap_1.model.Setting;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SettingController {

    @GetMapping("/home")
    public ModelAndView showFrom(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        modelAndView.addObject("setting", new Setting());
        modelAndView.addObject("languages",new String[]{"English", "Vietnamese", "Japanese", "Chinese"});
        modelAndView.addObject("size",new String[]{"5", "10", "15", "20"});

        return modelAndView;
    }

    @GetMapping("/about")
    public ModelAndView showAbout(@ModelAttribute("setting") Setting setting){
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("setting", setting);
        return modelAndView;
    }
}
