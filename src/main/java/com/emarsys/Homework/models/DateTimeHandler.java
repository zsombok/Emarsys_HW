package com.emarsys.Homework.models;

import com.emarsys.Homework.exceptions.OutOfWorkingHoursException;
import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class DateTimeHandler {

  public static final int WORKING_HOURS_START = 9;
  public static final int WORKING_HOURS_END = 17;
  public static final int WORKING_HOURS_DURATION = WORKING_HOURS_END - WORKING_HOURS_START;

  public static void validateWorkingHours(LocalDateTime dateTime) throws OutOfWorkingHoursException {
    DayOfWeek day = dateTime.getDayOfWeek();
    int hour = dateTime.getHour();

    if (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY || hour < WORKING_HOURS_START || hour > WORKING_HOURS_END) {
      throw new OutOfWorkingHoursException();
    }
  }
}
