package com.example.demo.component.controller;

import com.example.demo.component.service.LoanService;
import com.example.demo.programObject.dto.LoanDto;
import com.example.demo.programObject.dto.LoanInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/loan")
@RequiredArgsConstructor
public class LoanRestController {

    private final LoanService loanService;

    @PostMapping("/create")
    public ResponseEntity<LoanDto> createLoan(@Valid @RequestBody LoanDto loanDto) {
        return new ResponseEntity<>(loanService.createLoan(loanDto), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<LoanDto>> getAllLoans() {
        return new ResponseEntity<>(loanService.getAllLoans(), HttpStatus.OK);
    }

    @GetMapping("/getById")
    public ResponseEntity<LoanDto> getAllLoans(@Valid @RequestParam("loan_id") UUID id) {
        return new ResponseEntity<>(loanService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/info")
    public ResponseEntity<List<LoanInfoDto>> getAllLoanInfo() {
        return new ResponseEntity<>(loanService.getAllLoanInfo(), HttpStatus.OK);
    }
}
