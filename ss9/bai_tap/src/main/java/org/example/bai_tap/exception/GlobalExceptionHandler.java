package org.example.bai_tap.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleAllExceptions(Exception ex) {
        ModelAndView modelAndView = new ModelAndView("errror");

        // Truyền thông báo lỗi vào View
        modelAndView.addObject("errorMessage", "Đã xảy ra lỗi không mong muốn trong quá trình xử lý: " + ex.getMessage());

        // Ghi log lỗi ra console để debug
        System.err.println("GLOBAL EXCEPTION CAUGHT: " + ex.getMessage());
        ex.printStackTrace();

        return modelAndView;
    }

}
