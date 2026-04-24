package dev.agdral;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

// Input: yearBirth(2000-12-25) YearDead(80)
// Output: (missing years)y (missing months)m (missing days)d -> (missing hours):(missing minutes)

public class App {
  public static void main(String[] args) {
    LocalDate dateBirth = LocalDate.parse(args[0]);
    Integer yearDead = Integer.parseInt(args[1]);
    LocalDateTime timeNow = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
    LocalDate dateDead = dateBirth.plusYears(yearDead);

    Period p = Period.between(timeNow.toLocalDate(), dateDead);
    String dateInvert = String.valueOf(p.getYears())
        + "y "
        + String.valueOf(p.getMonths())
        + "m "
        + String.valueOf(p.getDays())
        + "d";
    String clockInvert = getHourInvert(timeNow) + ":" + getMinuteInvert(timeNow);
    String result = dateInvert + " -> " + clockInvert;
    System.out.println(result);
  }

  public static String getHourInvert(LocalDateTime timeNow) {
    return String.valueOf(23 - timeNow.getHour());
  };

  public static String getMinuteInvert(LocalDateTime timeNow) {
    return String.valueOf(59 - timeNow.getMinute());
  };
}
