package com.store.M2TestingIsmaelGonzalez;

import com.store.M2TestingIsmaelGonzalez.Repositories.EmployeeRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class M2TestingIsmaelGonzalezApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(M2TestingIsmaelGonzalez.class);

	@Autowired
	EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(M2TestingIsmaelGonzalezApplication.class, args);
		System.out.println("Run App");
	}

	@Override
	public void run(String... args) throws Exception {



	}
}
