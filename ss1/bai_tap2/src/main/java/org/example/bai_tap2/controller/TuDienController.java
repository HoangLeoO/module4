package org.example.bai_tap2.controller;

import org.example.bai_tap2.service.ITuDienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TuDienController {

    private final ITuDienService tuDienService;

    public TuDienController(ITuDienService tuDienService) {
        this.tuDienService = tuDienService;
    }
    @RequestMapping(value = "/home",method = RequestMethod.GET )
    public String search(@RequestParam(value = "str" ,defaultValue = "") String str , Model model){
        model.addAttribute("str",str);
        model.addAttribute("result",tuDienService.search(str));
        return "home";
    }

}
