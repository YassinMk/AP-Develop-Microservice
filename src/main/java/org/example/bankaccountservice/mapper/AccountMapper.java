package org.example.bankaccountservice.mapper;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.example.bankaccountservice.dto.BankAccountRequestDto;
import org.example.bankaccountservice.dto.BankAccountResponseDto;
import org.example.bankaccountservice.entities.BankAccount;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

public class AccountMapper {
    public BankAccountResponseDto toBankAccountRespDto (BankAccount bankAccount) {
        BankAccountResponseDto bankAccountResponseDto = new BankAccountResponseDto();
        BeanUtils.copyProperties(bankAccount, bankAccountResponseDto);
        return bankAccountResponseDto;
    }
    public BankAccountRequestDto toBankAccountReqDto (BankAccount bankAccount) {
        BankAccountRequestDto bankAccountRequestDto = new BankAccountRequestDto();
        BeanUtils.copyProperties(bankAccount, bankAccountRequestDto);
        return bankAccountRequestDto;
    }
    public BankAccount toBankAccount (BankAccountRequestDto bankAccountRequestDto) {
        BankAccount bankAccount = new BankAccount();
        BeanUtils.copyProperties(bankAccountRequestDto, bankAccount);
        return bankAccount;
    }


}
