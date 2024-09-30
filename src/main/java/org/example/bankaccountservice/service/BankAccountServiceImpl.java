package org.example.bankaccountservice.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.bankaccountservice.dto.BankAccountRequestDto;
import org.example.bankaccountservice.dto.BankAccountResponseDto;
import org.example.bankaccountservice.entities.BankAccount;
import org.example.bankaccountservice.exceptions.AccountNotFoundException;
import org.example.bankaccountservice.mapper.AccountMapper;
import org.example.bankaccountservice.repository.BankAccountRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class BankAccountServiceImpl implements IBankAccountService{
    private final BankAccountRepository bankAccountRepository;


    @Override
    public ResponseEntity<String> createBankAccount(BankAccountRequestDto bankAccountRequestDto) {
        AccountMapper accountMapper = new AccountMapper();
        BankAccount bankAccount = accountMapper.toBankAccount(bankAccountRequestDto);
        bankAccount.setId(UUID.randomUUID().toString());
        bankAccountRepository.save(bankAccount);
        return ResponseEntity.status(201).body("Account created successfully");
    }

    @Override
    public ResponseEntity<List<BankAccountResponseDto>> getAllBankAccounts() {
        List<BankAccountResponseDto> bankAccountResponseDtoList=  bankAccountRepository.findAll().stream().map(bankAccount -> {
            AccountMapper accountMapper = new AccountMapper();
            BankAccountResponseDto bankAccountResponseDto  = accountMapper.toBankAccountRespDto(bankAccount);
            return bankAccountResponseDto;

        }).collect(Collectors.toList());
        return ResponseEntity.ok(bankAccountResponseDtoList);
    }

    @Override
    public ResponseEntity<BankAccountResponseDto> getBankAccountById(String id) throws AccountNotFoundException {
        BankAccount bankAccount = bankAccountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException("Account not found"));
        AccountMapper accountMapper = new AccountMapper();
        BankAccountResponseDto bankAccountRespDto =accountMapper.toBankAccountRespDto(bankAccount);
        return ResponseEntity.ok(bankAccountRespDto);
    }

    @Override
    public ResponseEntity<BankAccountResponseDto> updateBankAccount(String id, BankAccountRequestDto bankAccountRequestDto) throws AccountNotFoundException {
        // Fetch the existing bank account
        BankAccount updatedBankAccount = bankAccountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account not found"));

        // Use the mapper or manually update only the fields from the request DTO
        AccountMapper accountMapper = new AccountMapper();

        //set all properties of the existing bank account to the new bank account
        BeanUtils.copyProperties(bankAccountRequestDto, updatedBankAccount);

        // Save the updated bank account (ID remains the same)
        bankAccountRepository.save(updatedBankAccount);

        // Convert the updated bank account to the response DTO
        BankAccountResponseDto bankAccountResponseDto = accountMapper.toBankAccountRespDto(updatedBankAccount);

        return ResponseEntity.ok(bankAccountResponseDto);
    }

    @Override
    public ResponseEntity<String> deleteBankAccount(String id) throws AccountNotFoundException {
        BankAccount bankAccount = bankAccountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException("Account not found"));
        bankAccountRepository.delete(bankAccount);
        return ResponseEntity.status(200).body("Account deleted successfully");
    }
}
