package com.ttmdear.repository.springautoconfigure;

import com.logi.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App implements CommandLineRunner {
	@Autowired
    private Printer printer;

	@Autowired
    @Qualifier("logiPrinter")
	private Printer logiPrinter;

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	    printer.print("Test 1");
	    logiPrinter.print("Test 2");

	    userService.print("Test 3");
	}
}
