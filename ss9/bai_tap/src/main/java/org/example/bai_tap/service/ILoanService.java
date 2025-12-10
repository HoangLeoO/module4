package org.example.bai_tap.service;

import org.example.bai_tap.entity.Loan;

import java.util.List;

public interface ILoanService {
    List<Loan> findAll();
    boolean addLoan(Loan loan);
}
