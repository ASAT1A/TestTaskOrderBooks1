package com.example.demo.programObject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanInfoDto {

    private String clientName;
    private LocalDate clientBirthdate;
    private String bookName;
    private String bookAuthor;
    private String bookIsbn;
    private LocalDate loanDate;
}
