package org.example.bai_tap.controller;

import org.example.bai_tap.dto.BookLoanRequestDTO;
import org.example.bai_tap.entity.Book;
import org.example.bai_tap.entity.BookLoan;
import org.example.bai_tap.service.IBookLoanService;
import org.example.bai_tap.service.IBookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/books")
public class BookController {

    private final IBookService bookService;

    private final IBookLoanService bookLoanService;

    public BookController(IBookService bookService, IBookLoanService bookLoanService) {
        this.bookService = bookService;
        this.bookLoanService = bookLoanService;
    }

    @GetMapping("")
    public String listBooks(@RequestParam(name = "page", defaultValue = "0",required = false) int page,
                            @RequestParam(name = "search" , defaultValue = "",required = false) String search,
                            Model model
    ) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Book> books = bookService.findAll(pageable);
        model.addAttribute("books", books);
        return "books/list";
    }

    @GetMapping("/add")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "books/add";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute(name = "book") Book book) {
        bookService.addBook(book);
        return "redirect:/books";
    }

    @GetMapping("/bl/add")
    public String addBookLoanForm(Model model , @RequestParam("book_id") Long book_id){
        BookLoanRequestDTO bookLoan = new BookLoanRequestDTO();
        bookLoan.setBookId(book_id);
        model.addAttribute("bookLoan", bookLoan);

        return "books/add_bl";
    }

    @PostMapping("/bl/add")
    public String addBookLoan(@ModelAttribute(name = "bookLoan") BookLoanRequestDTO bookLoan) throws Exception {



        try {
            bookLoanService.addBooKLoan(bookLoan.getLoanId(), bookLoan.getBookId());
        }catch (Exception e){
            throw new Exception();
        }
        return "redirect:/books";
    }

    @GetMapping("/tra-sach/{book_id}")
    public String traSach(@PathVariable("book_id") Long book_id){
        return "redirect:/books";
    }
}
