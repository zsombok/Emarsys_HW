package com.emarsys.Homework.models;

import com.emarsys.Homework.exceptions.OutOfWorkingHoursException;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

@Component
public class DateTimeHandler {

  public static final int WORKING_HOURS_START = 9;
  public static final int WORKING_HOURS_END = 17;
  public static final int WORKING_HOURS_DURATION = WORKING_HOURS_END - WORKING_HOURS_START;

  public void validateWorkingHours(LocalDateTime dateTime) throws OutOfWorkingHoursException {
    DayOfWeek day = dateTime.getDayOfWeek();
    int hour = dateTime.getHour();

    if (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY || hour < WORKING_HOURS_START || hour > WORKING_HOURS_END) {
      throw new OutOfWorkingHoursException();
    }
  }

  public LocalDateTime addHoursToWorkDateTimeWhileSkippingWeekend(LocalDateTime dateTime, int hours) {
    int wholeDaysToAdd = hours / WORKING_HOURS_DURATION;
    int hoursToAdd = hours % WORKING_HOURS_DURATION;
    int endHour = dateTime.getHour() + hoursToAdd;

    if (endHour >= WORKING_HOURS_END) {
      wholeDaysToAdd++;
      endHour = endHour - WORKING_HOURS_END + WORKING_HOURS_START;
    }

    int actuallyAddedDays = 0;
    while (actuallyAddedDays < wholeDaysToAdd) {
      dateTime = dateTime.plusDays(1);
      DayOfWeek day = dateTime.getDayOfWeek();
      if (day != DayOfWeek.SATURDAY && day != DayOfWeek.SUNDAY) {
        actuallyAddedDays++;
      }
    }

    return dateTime.withHour(endHour);

  }
}
