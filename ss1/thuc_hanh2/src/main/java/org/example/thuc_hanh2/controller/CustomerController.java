package org.example.thuc_hanh2.controller;

import org.example.thuc_hanh2.entity.Customer;
import org.example.thuc_hanh2.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String showList(Model model) {
        List<Customer> customers = customerService.getAll();
        model.addAttribute("customers", customers);
        return "list";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String showAdd() {
        return "add";
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String showEdit(@RequestParam(value = "id") Integer id, Model model) {
        Customer customer = customerService.getById(id);
        model.addAttribute("customer", customer);
        return "edit";
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String showDelete() {
        return "delete";
    }

    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String showDetail(@RequestParam(value = "id") Integer id, Model model) {
        Customer customer = customerService.getById(id);
        model.addAttribute("customer", customer);
        return "detail";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(@ModelAttribute Customer customer) {
        if (customerService.add(customer)) {
            return "redirect:list";
        } else {
            return "add";
        }
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute Customer customer) {
        if (customerService.edit(customer)) {
            return "redirect:list";
        }else {
            return "edit";
        }
    }
}
