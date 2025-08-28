package com.example.demo.programObject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanDto {

    private UUID id;
    private LocalDate loanDate;
    private UUID bookId;
    private UUID clientId;
}
