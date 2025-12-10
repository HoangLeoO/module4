package org.example.bai_tap.controller;

import org.example.bai_tap.entity.Loan;
import org.example.bai_tap.service.IBookLoanService;
import org.example.bai_tap.service.IBookService;
import org.example.bai_tap.service.LoanService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/loans")
public class LoanController {

    private final LoanService loanService;

    private final IBookLoanService bookLoanService;

    private final IBookService bookService;

    public LoanController(LoanService loanService, IBookLoanService bookLoanService, IBookService bookService) {
        this.loanService = loanService;
        this.bookLoanService = bookLoanService;
        this.bookService = bookService;
    }

    @GetMapping("")
    public String listLoans(Model model){
        model.addAttribute("loans", loanService.findAll());
        return "loans/list";
    }

    @GetMapping("/add")
    public String addLoanForm(Model model){
        model.addAttribute("loan", new Loan());
        return "loans/add";
    }

    @PostMapping("/add")
    public String addLoan(Loan loan){
        loanService.addLoan(loan);
        return "redirect:/loans";
    }

    @GetMapping("/detail/{loan_id}")
    public String detailLoan(@PathVariable("loan_id") Long loan_id, Model model){
        model.addAttribute("loan_id",loan_id);
        model.addAttribute("loans",bookService.findByLoanId(loan_id));
        return "loans/detail";
    }


}
