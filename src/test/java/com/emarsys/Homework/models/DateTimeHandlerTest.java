package com.emarsys.Homework.models;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.emarsys.Homework.exceptions.OutOfWorkingHoursException;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class DateTimeHandlerTest {

  DateTimeHandler dateTimeHandler;

  @BeforeEach
  void setUp() {
    dateTimeHandler = new DateTimeHandler();
  }

  @Nested
  @DisplayName("Working hours validation")
  class ValidateWorkingHoursUseCases {

    @Test
    @DisplayName("Should throw exception when argument is out of working hours")
    void throwsOutOfWorkingHoursException_when_argumentIsOutOfWorkingHours() {
      OutOfWorkingHoursException exception = assertThrows(OutOfWorkingHoursException.class, () -> {
        dateTimeHandler.validateWorkingHours(LocalDateTime.parse("2022-03-04T17:00"));
      });
      assertTrue(exception.getMessage().contains("Submit date/time is out of working hours!"));
    }

    @Test
    @DisplayName("Should not throw exception when argument is in working hours")
    void throwsNothing_when_argumentIsInWorkingHours() {
      assertDoesNotThrow(() -> {
        dateTimeHandler.validateWorkingHours(LocalDateTime.parse("2022-03-04T12:00"));
      });
    }
  }

}