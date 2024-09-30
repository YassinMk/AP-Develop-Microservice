package org.example.bankaccountservice.controllers;

import lombok.RequiredArgsConstructor;
import org.example.bankaccountservice.dto.BankAccountRequestDto;
import org.example.bankaccountservice.dto.BankAccountResponseDto;
import org.example.bankaccountservice.repository.BankAccountRepository;
import org.example.bankaccountservice.service.IBankAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bank-accounts")
@RequiredArgsConstructor
public class BankAccountController {
    private  final BankAccountRepository bankAccountRepository;
    private final IBankAccountService bankAccountService;

    @GetMapping("")
    public ResponseEntity<List<BankAccountResponseDto>> getAllBankAccounts(){
        return bankAccountService.getAllBankAccounts();
    }
    @GetMapping("/{id}")
    public ResponseEntity<BankAccountResponseDto> getBankAccountById(@PathVariable String id){
        return bankAccountService.getBankAccountById(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBankAccount(@PathVariable String id){
        return bankAccountService.deleteBankAccount(id);
    }
    @PostMapping("/create")
    public ResponseEntity<String> createBankAccount(@RequestBody BankAccountRequestDto bankAccountRequestDto){
        return bankAccountService.createBankAccount(bankAccountRequestDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BankAccountResponseDto> updateBankAccount(@PathVariable String id, @RequestBody BankAccountRequestDto bankAccountRequestDto){
        return bankAccountService.updateBankAccount(id, bankAccountRequestDto);
    }

}
