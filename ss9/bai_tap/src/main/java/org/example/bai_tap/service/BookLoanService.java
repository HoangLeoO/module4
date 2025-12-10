package org.example.bai_tap.service;

import org.example.bai_tap.entity.BookLoan;
import org.example.bai_tap.repository.IBookLoan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookLoanService implements IBookLoanService{

    @Autowired
    private IBookLoan bookLoanRepository;

    @Override
    public List<BookLoan> findAllByLoanId(Long loanId) {
        return bookLoanRepository.findAllByLoanId(loanId);
    }

    @Override
    @Transactional
    public boolean addBooKLoan(Long loanId, Long bookId) {
        try {
            bookLoanRepository.addBooKLoan(loanId,bookId);
        }catch (Exception e){
            throw new RuntimeException();
        }
        return true;
    }


}
