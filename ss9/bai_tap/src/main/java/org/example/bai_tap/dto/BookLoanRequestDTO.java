package org.example.bai_tap.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookLoanRequestDTO {

    @NotBlank(message = "khong duoc de trong")
    private Long bookId;

    @NotBlank(message = "khong duoc de trong")
    private Long loanId;
}
