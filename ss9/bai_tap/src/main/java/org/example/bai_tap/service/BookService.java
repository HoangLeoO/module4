package org.example.bai_tap.service;

import org.example.bai_tap.entity.Book;
import org.example.bai_tap.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService{
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public List<Book> findByLoanId(Long loanId) {
        return bookRepository.findByLoanId(loanId);
    }

    @Override
    public Page<Book> findByTitleContaining(String author, Pageable pageable) {
        return bookRepository.findByTitle(author, pageable);
    }

    @Override
    public boolean addBook(Book book) {
        return bookRepository.save(book) != null;
    }

    @Override
    public boolean updateBook(Book book) {
        return false;
    }

    @Override
    public boolean deleteBook(Long id) {
        return false;
    }

    @Override
    public void updateRemainingBook(Long id, Integer remainingBook) {
        bookRepository.updateRemainingBook(id,remainingBook);
    }

    @Override
    public Book getById(Long id) {
        return bookRepository.getById(id);
    }
}
