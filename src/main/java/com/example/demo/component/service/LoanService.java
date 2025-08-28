package com.example.demo.component.service;

import com.example.demo.programObject.dto.LoanDto;
import com.example.demo.programObject.dto.LoanInfoDto;
import com.example.demo.programObject.entity.BookEntity;
import com.example.demo.programObject.entity.ClientEntity;
import com.example.demo.programObject.entity.LoanEntity;
import com.example.demo.programObject.mapper.loanInfoMapper.InfoDtoMapper;
import com.example.demo.programObject.mapper.loanMapper.LoanDtoMapper;
import com.example.demo.programObject.mapper.loanMapper.LoanEntityMapper;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;
    private final ClientRepository clientRepository;

    private final LoanDtoMapper loanDtoMapper;
    private final LoanEntityMapper loanEntityMapper;
    private final InfoDtoMapper infoDtoMapper;


    public LoanDto createLoan(LoanDto loanDto) {

        Optional<BookEntity> bookOptional = bookRepository.findById(loanDto.getBookId());
        Optional<ClientEntity> clientOptional = clientRepository.findById(loanDto.getClientId());

        if (bookOptional.isPresent() && clientOptional.isPresent()) {

            LoanEntity loan = loanEntityMapper.toEntity(loanDto);

            loan.setBook(bookOptional.get());
            loan.setClient(clientOptional.get());

            if (loan.getLoanDate() == null) {
                loan.setLoanDate(LocalDate.now());
            }
            LoanEntity savedLoan = loanRepository.save(loan);
            return loanDtoMapper.toDto(savedLoan);
        } else {
            throw new RuntimeException();
        }
    }

    public List<LoanDto> getAllLoans() {

        List<LoanEntity> loans = new ArrayList<>();

        loans.addAll(loanRepository.findAll());
        return loanDtoMapper.toDtos(loans);

    }

    public LoanDto getById(UUID loanid) {

        Optional<LoanEntity> loanOptional = loanRepository.findById(loanid);

        if (loanOptional.isPresent()) {
            return loanDtoMapper.toDto(loanOptional.get());
        } else {
            throw new RuntimeException();
        }
    }

    public List<LoanInfoDto> getAllLoanInfo() {
        List<LoanEntity> loans = loanRepository.findAllWithClientAndBook();
        return infoDtoMapper.toLoanInfoDtos(loans);
    }

    public int getAllLoansSize() {
        return loanRepository.findAll().size();
    }
}
