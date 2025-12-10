package org.example.bai_tap.repository;

import jakarta.transaction.Transactional;
import org.example.bai_tap.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookRepository extends JpaRepository<Book, Long> {

    Page<Book> findByTitle(String author, Pageable pageable);

    Page<Book> findAll(Pageable pageable);

//    void updateRemainingBook(Long id,Integer remainingBook);
    Book getById(Long id);

    @Modifying // Bắt buộc phải có vì đây là lệnh thay đổi dữ liệu (UPDATE)
    @Transactional // Đảm bảo việc cập nhật chạy trong Transaction
    @Query("UPDATE Book b SET b.remaining = b.remaining + :amount WHERE b.id = :bookId")
        // ^^^ Sử dụng JPQL: "Book" là tên Entity, "remaining" là tên trường trong Entity
    void updateRemainingBook(@Param("bookId") Long id, @Param("amount")Integer remainingBook);

    @Query(value = "SELECT b.* FROM books b join book_loan bl on b.id = bl.book_id where bl.loan_id = :id ",nativeQuery = true)
    List<Book> findByLoanId(@Param("id") Long loanId);
}
