package org.example.bankaccountservice.controllers;

import lombok.RequiredArgsConstructor;
import org.example.bankaccountservice.dto.BankAccountRequestDto;
import org.example.bankaccountservice.dto.BankAccountResponseDto;
import org.example.bankaccountservice.repository.BankAccountRepository;
import org.example.bankaccountservice.service.IBankAccountService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BankAccountGraphQLController {
    private  final IBankAccountService bankAccountService;
    // Query to get all bank accounts
    @QueryMapping
    public List<BankAccountResponseDto> getAllBankAccounts() {
        return bankAccountService.getAllBankAccounts().getBody();
    }
    // Query to get a bank account by id
    @QueryMapping
    public BankAccountResponseDto getBankAccountById( @Argument  String id) {
        return bankAccountService.getBankAccountById(id).getBody();
    }

    @MutationMapping
    public String createBankAccount(@Argument BankAccountRequestDto bankAccountRequestDto) {
        return bankAccountService.createBankAccount(bankAccountRequestDto).getBody();
    }

    @MutationMapping
    public String deleteBankAccount(@Argument String id) {
        return bankAccountService.deleteBankAccount(id).getBody();
    }

    @MutationMapping
    public BankAccountResponseDto updateBankAccount(@Argument String id, @Argument BankAccountRequestDto bankAccountRequestDto) {
        return bankAccountService.updateBankAccount(id, bankAccountRequestDto).getBody();
    }

}
