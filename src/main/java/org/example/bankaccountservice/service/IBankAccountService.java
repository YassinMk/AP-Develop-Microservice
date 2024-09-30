package org.example.bankaccountservice.service;

import org.example.bankaccountservice.dto.BankAccountRequestDto;
import org.example.bankaccountservice.dto.BankAccountResponseDto;
import org.example.bankaccountservice.exceptions.AccountNotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IBankAccountService {
    ResponseEntity<String> createBankAccount(BankAccountRequestDto bankAccountRequestDto);
    ResponseEntity<List<BankAccountResponseDto>>getAllBankAccounts();
    ResponseEntity<BankAccountResponseDto> getBankAccountById(String id) throws AccountNotFoundException;
    ResponseEntity<BankAccountResponseDto> updateBankAccount(String id, BankAccountRequestDto bankAccountRequestDto) throws AccountNotFoundException;

    ResponseEntity<String> deleteBankAccount(String id) throws AccountNotFoundException;



}
