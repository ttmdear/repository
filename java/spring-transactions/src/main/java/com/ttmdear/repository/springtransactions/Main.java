package com.ttmdear.repository.springtransactions;

import com.ttmdear.repository.springtransactions.core.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component
public class Main implements CommandLineRunner {
    private TransactionA transactionA;

	public Main(TransactionA transactionA) {
		this.transactionA = transactionA;
	}

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	    transactionA.run();
	}
}
