package com.emarsys.Homework;

import com.emarsys.Homework.utilities.DateCalculator;
import java.time.LocalDateTime;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HomeworkApplication implements CommandLineRunner {

	private final DateCalculator dateCalculator;

	public HomeworkApplication(DateCalculator dateCalculator) {
		this.dateCalculator = dateCalculator;
	}

	public static void main(String[] args) {
		SpringApplication.run(HomeworkApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		dateCalculator.CalculateDueDate(LocalDateTime.parse("2022-03-02T10:17"
), 17);
	}
}
