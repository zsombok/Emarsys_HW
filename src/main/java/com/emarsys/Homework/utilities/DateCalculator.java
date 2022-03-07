package com.emarsys.Homework.utilities;

import com.emarsys.Homework.exceptions.OutOfWorkingHoursException;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DateCalculator {

  private final DateTimeHandler dateTimeHandler;

  public DateCalculator(DateTimeHandler dateTimeHandler) {
    this.dateTimeHandler = dateTimeHandler;
  }

  public LocalDateTime CalculateDueDate(LocalDateTime submitDate, int turnaroundTime) throws OutOfWorkingHoursException, IllegalArgumentException {
    dateTimeHandler.validateWorkingHours(submitDate);
    dateTimeHandler.validateTurnaroundTime(turnaroundTime);
    return dateTimeHandler.addHoursToWorkDateTimeWhileSkippingWeekend(submitDate, turnaroundTime);
  }

}
