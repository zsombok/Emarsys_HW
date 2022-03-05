package com.emarsys.Homework.utilities;

import com.emarsys.Homework.exceptions.OutOfWorkingHoursException;
import com.emarsys.Homework.models.DateTimeHandler;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

@Component
public class DateCalculator {

  private final DateTimeHandler dateTimeHandler;

  public DateCalculator(DateTimeHandler dateTimeHandler) {
    this.dateTimeHandler = dateTimeHandler;
  }

  public LocalDateTime CalculateDueDate(LocalDateTime submitDate, int turnaroundTime) {
    try {
      dateTimeHandler.validateWorkingHours(submitDate);
    } catch (OutOfWorkingHoursException e) {
      System.err.println(e.getMessage());
    }
    return dateTimeHandler.addHoursToWorkDateTimeWhileSkippingWeekend(submitDate, turnaroundTime);
  }

}
