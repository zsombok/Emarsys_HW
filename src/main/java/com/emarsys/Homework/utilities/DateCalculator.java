package com.emarsys.Homework.utilities;

import com.emarsys.Homework.exceptions.OutOfWorkingHoursException;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

@Component
public class DateCalculator {

  private final DateTimeHandler dateTimeHandler;

  public DateCalculator(DateTimeHandler dateTimeHandler) {
    this.dateTimeHandler = dateTimeHandler;
  }

  public LocalDateTime CalculateDueDate(LocalDateTime submitDate, int turnaroundTime) throws OutOfWorkingHoursException {
    dateTimeHandler.validateWorkingHours(submitDate);
    return dateTimeHandler.addHoursToWorkDateTimeWhileSkippingWeekend(submitDate, turnaroundTime);
  }

}
