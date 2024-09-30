package org.example.bankaccountservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.*;
import org.example.bankaccountservice.enums.AccountType;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BankAccount {
    @Id
    private String id ;
    @DateTimeFormat(
            pattern = "dd-MM-yyyy"
    )
    private Date createdAt ;
    private double balance ;
    private String accurency ;
    @Enumerated(
            EnumType.STRING
    )
    private AccountType type ;
}
