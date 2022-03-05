package com.emarsys.Homework.models;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class DateTimeHandler {

  public static final int WORKING_HOURS_START = 9;
  public static final int WORKING_HOURS_END = 17;

  public static boolean validateWorkingHours(LocalDateTime dateTime) {
    DayOfWeek day = dateTime.getDayOfWeek();
    int hour = dateTime.getHour();

    return day != DayOfWeek.SATURDAY && day != DayOfWeek.SUNDAY && hour >= WORKING_HOURS_START && hour <= WORKING_HOURS_END;
  }
}
