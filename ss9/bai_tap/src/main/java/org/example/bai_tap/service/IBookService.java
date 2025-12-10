package org.example.bai_tap.service;

import org.example.bai_tap.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBookService {
    Page<Book> findAll(Pageable pageable);

    List<Book> findByLoanId(Long loanId);

    Page<Book> findByTitleContaining(String author, Pageable pageable);

    boolean addBook(Book book);

    boolean updateBook(Book book);

    boolean deleteBook(Long id);

    void updateRemainingBook(Long id,Integer remainingBook);
    Book getById(Long id);
}
