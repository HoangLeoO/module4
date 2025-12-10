package org.example.bai_tap.service;

import org.example.bai_tap.entity.Loan;
import org.example.bai_tap.repository.ILoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService implements ILoanService{

    @Autowired
    private ILoanRepository loanRepository;

    @Override
    public List<Loan> findAll() {
        return loanRepository.findAll();
    }

    @Override
    public boolean addLoan(Loan loan) {
        return loanRepository.save(loan) != null;
    }
}
