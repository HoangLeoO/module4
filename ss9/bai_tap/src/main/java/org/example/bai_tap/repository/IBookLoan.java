package org.example.bai_tap.repository;

import org.example.bai_tap.entity.BookLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookLoan extends JpaRepository<BookLoan, Long> {
    List<BookLoan> findAllByLoanId(Long loanId);

    @Modifying
    @Query(value = "INSERT INTO book_loan(loan_id,book_id) values (:loanId,:bookId)",nativeQuery = true)
    void addBooKLoan(@Param("loanId") Long loanId,@Param("bookId") Long bookId);
}
