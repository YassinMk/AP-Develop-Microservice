package org.example.bankaccountservice;

import lombok.RequiredArgsConstructor;
import org.example.bankaccountservice.entities.BankAccount;
import org.example.bankaccountservice.enums.AccountType;
import org.example.bankaccountservice.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;


@SpringBootApplication
@RequiredArgsConstructor
public class BankAccountServiceApplication {
	private final BankAccountRepository bankAccountRepository;

	public static void main(String[] args) {
		SpringApplication.run(BankAccountServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(){
		return args -> {
			for (int i = 0; i < 10; i++) {
				BankAccount bankAccount = BankAccount.builder()
						.id(UUID.randomUUID().toString())
						.balance(1000 + Math.random()*1000)
						.accurency("USD")
						.createdAt(new Date())
						.type(Math.random()> 0.5 ? AccountType.CURRRENT_ACCOUNT : AccountType.SAVING_ACCOUNT)
						.build();
				bankAccountRepository.save(bankAccount);
			}

		};
	}
}
