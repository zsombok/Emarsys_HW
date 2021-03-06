package com.emarsys.Homework;

import com.emarsys.Homework.exceptions.OutOfWorkingHoursException;
import com.emarsys.Homework.utilities.DateCalculator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

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
    try {
      LocalDateTime result = dateCalculator.CalculateDueDate(LocalDateTime.parse("2022-03-04T16:00"), 11);
      System.out.println(result);
    } catch (OutOfWorkingHoursException | IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }
}
