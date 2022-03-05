package com.emarsys.Homework.exceptions;

public class OutOfWorkingHoursException extends RuntimeException {

  public OutOfWorkingHoursException() {
    super("Submit date/time is out of working hours!");
  }
}
