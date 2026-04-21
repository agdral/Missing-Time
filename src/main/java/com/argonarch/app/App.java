package com.argonarch.app;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;

/**
 * Input String yearsNow, String yearsDead Output time life = years, months, days, hours, minutes
 */
public class App {
  public static void main(String[] args) {
    String minuteString = "";
    String hourString = "";
    Instant dateNow = Instant.now();
    LocalDateTime timeNow = LocalDateTime.ofInstant(dateNow, ZoneId.systemDefault());
    Integer hourInvert = (timeNow.getHour() - 23) * -1;
    Integer minuteInvert = (timeNow.getMinute() - 59) * -1;
    // Integer secondInvert = (timeNow.getSecond() - 60)*-1;
    if (minuteInvert >= 0 && minuteInvert <= 9) {
      minuteString = "0" + minuteInvert.toString();
    } else {
      minuteString = minuteInvert.toString();
    }
    if (hourInvert >= 0 && hourInvert <= 9) {
      hourString = "0" + hourInvert.toString();
    } else {
      hourString = hourInvert.toString();
    }
    String clockInvert = hourString + ":" + minuteString;
    LocalDate locaDeteNow = LocalDate.now();
    String dateDead = args[0];
    LocalDate date = LocalDate.parse(dateDead);
    Period p = Period.between(locaDeteNow, date);
    Integer yearInvert = p.getYears();
    Integer monthInvert = p.getMonths();
    Integer dayInvert = p.getDays();
    String dateInvert =
        yearInvert.toString() + "y " + monthInvert.toString() + "m " + dayInvert.toString() + "d";

    /* List<Integer> resultList = new ArrayList<Integer>();
    resultList.add(yearInvert);
    resultList.add(monthInvert);
    resultList.add(dayInvert);
    resultList.add(hourInvert);
    resultList.add(minuteInvert); */

    String result = dateInvert + "  " + clockInvert;
    System.out.println(result);
  }
}
