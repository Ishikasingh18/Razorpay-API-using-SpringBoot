package com.Bank.IFSC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankIfscApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankIfscApplication.class, args);
		System.out.println("Connected....");
	}

}
