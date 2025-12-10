package org.example.bai_tap.repository;

import org.example.bai_tap.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILoanRepository extends JpaRepository<Loan, Long> {
}
