package org.example.bai_tap.service;

import org.example.bai_tap.entity.BookLoan;

import java.util.List;

public interface IBookLoanService {
    List<BookLoan> findAllByLoanId(Long loanId);

    boolean addBooKLoan(Long loanId,Long bookId);
}
