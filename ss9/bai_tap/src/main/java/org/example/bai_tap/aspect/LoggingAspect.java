package org.example.bai_tap.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.example.bai_tap.dto.BookLoanRequestDTO;
import org.example.bai_tap.service.BookLoanService;
import org.example.bai_tap.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.print.Book;

@Aspect
@Component
public class LoggingAspect {

    private static int count = 0;

    @Autowired
    private IBookService bookService;


    @Pointcut("execution(* org.example.bai_tap.controller.*.*(..))")
    public void controllerLogging(){

    }

    @Pointcut("execution(* org.example.bai_tap.controller.BookController.addBookLoan(..))")
    public void afterSaveBookLoan(){
    }

    @Pointcut("execution(* org.example.bai_tap.controller.BookController.traSach(..))")
    public void afterTraSach(){
    }

    @Before("controllerLogging()")
    public void beforeControllerLogging(JoinPoint joinPoint){
        count++;
        System.out.println("view + " + count);
    }

    @AfterReturning(pointcut = "afterTraSach()")
    public void updateRemainingTraSach(JoinPoint joinPoint){
        System.out.println("==================================================");
        System.out.println("AOP: BẮT ĐẦU xử lý sau khi tạo Trả sách mượn thành công");


        Object[] args = joinPoint.getArgs();
        Long book_Id = null;
        for (Object arg : args) {
            if (arg instanceof Long) {
                book_Id = (Long) arg;
                break;
            }
        }

        if (book_Id != null) {
            Long bookId = book_Id;

            bookService.updateRemainingBook(bookId, +1); // Trừ 1 sách

            System.out.println("AOP LOG: Đã cộng số lượng sách còn lại cho ID: " + bookId);
        } else {
            System.out.println("AOP LOG: KHÔNG tìm thấy BookLoanRequestDTO trong tham số.");
        }
    }

        @AfterReturning("afterSaveBookLoan()")
    public void updateRemaining(JoinPoint joinPoint){ // Đổi tên phương thức cho rõ ràng hơn

        System.out.println("==================================================");
        System.out.println("AOP: BẮT ĐẦU xử lý sau khi tạo Phiếu mượn thành công");

        // 1. Lấy đối tượng DTO từ các tham số (Giả sử DTO là tham số đầu tiên)
        Object[] args = joinPoint.getArgs();
        BookLoanRequestDTO bookLoanRequestDTO = null;

        for (Object arg : args) {
            if (arg instanceof BookLoanRequestDTO) {
                bookLoanRequestDTO = (BookLoanRequestDTO) arg;
                break;
            }
        }

        if (bookLoanRequestDTO != null) {
            Long bookId = bookLoanRequestDTO.getBookId();

            bookService.updateRemainingBook(bookId, -1); // Trừ 1 sách

            System.out.println("AOP LOG: Đã trừ số lượng sách còn lại cho ID: " + bookId);
        } else {
            System.out.println("AOP LOG: KHÔNG tìm thấy BookLoanRequestDTO trong tham số.");
        }

        System.out.println("==================================================");
    }
}
