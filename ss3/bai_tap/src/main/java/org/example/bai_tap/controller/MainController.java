package org.example.bai_tap.controller;

import org.example.bai_tap.model.Product;
import org.example.bai_tap.service.IService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {
    private  final IService service;

    public MainController(IService service) {
        this.service = service;
    }

    @GetMapping("/products")
    public String products(Model model) {
        model.addAttribute("list",service.getAll());
        return "products";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product",new Product());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute(name = "product") Product product, RedirectAttributes redirectAttributes) {
        service.save(product);
        redirectAttributes.addFlashAttribute("mess","Create success");
        return "redirect:/products";
    }


    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") int id, Model model) {
        model.addAttribute("product",service.getById(id));
        return "update";
    }

    @PostMapping("/edit")
    public String save(@ModelAttribute(name = "product") Product product, RedirectAttributes redirectAttributes){
        service.update(product.getId(),product);
        redirectAttributes.addFlashAttribute("mess","Update success");
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") int id,RedirectAttributes redirectAttributes) {
        service.remove(id);
        redirectAttributes.addFlashAttribute("mess","Delete success");
        return "redirect:/products";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable(name = "id") int id,Model model) {
        model.addAttribute("product",service.getById(id));
        return "view";
    }
}
