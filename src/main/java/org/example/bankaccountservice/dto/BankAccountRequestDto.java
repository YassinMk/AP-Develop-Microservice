package org.example.bankaccountservice.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.bankaccountservice.enums.AccountType;

import java.util.Date;

@Data  @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccountRequestDto {
    private Date createdAt ;
    private double balance ;
    private String accurency ;
    private AccountType type ;
}
