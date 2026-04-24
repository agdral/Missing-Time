package dev.agdral;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import org.junit.jupiter.api.Test;

class AppTest {

  // --- getHourInvert ---

  @Test
  void getHourInvert_medianoche_retorna23() {
    LocalDateTime t = LocalDateTime.of(2026, 4, 23, 0, 0);
    assertEquals("23", App.getHourInvert(t));
  }

  @Test
  void getHourInvert_mediodia_retorna11() {
    LocalDateTime t = LocalDateTime.of(2026, 4, 23, 12, 0);
    assertEquals("11", App.getHourInvert(t));
  }

  @Test
  void getHourInvert_hora23_retorna0() {
    LocalDateTime t = LocalDateTime.of(2026, 4, 23, 23, 0);
    assertEquals("0", App.getHourInvert(t));
  }

  // --- getMinuteInvert ---

  @Test
  void getMinuteInvert_minuto0_retorna59() {
    LocalDateTime t = LocalDateTime.of(2026, 4, 23, 10, 0);
    assertEquals("59", App.getMinuteInvert(t));
  }

  @Test
  void getMinuteInvert_minuto30_retorna29() {
    LocalDateTime t = LocalDateTime.of(2026, 4, 23, 10, 30);
    assertEquals("29", App.getMinuteInvert(t));
  }

  @Test
  void getMinuteInvert_minuto59_retorna0() {
    LocalDateTime t = LocalDateTime.of(2026, 4, 23, 10, 59);
    assertEquals("0", App.getMinuteInvert(t));
  }

  // --- logica de dateDead y Period ---

  @Test
  void dateDead_es_fechaNacimientoMasAnios() {
    LocalDate birth = LocalDate.of(2000, 12, 25);
    LocalDate expected = LocalDate.of(2080, 12, 25);
    assertEquals(expected, birth.plusYears(80));
  }

  @Test
  void period_entreFechaActualYMuerte_esPositivo() {
    // Asumimos que la fecha de muerte es en el futuro
    LocalDate today = LocalDate.of(2026, 4, 23);
    LocalDate dead = LocalDate.of(2080, 12, 25);
    Period p = Period.between(today, dead);
    assertTrue(p.getYears() > 0, "Deberian quedar años positivos");
  }

  @Test
  void period_formatoSalida_correcto() {
    LocalDate today = LocalDate.of(2026, 4, 23);
    LocalDate dead = LocalDate.of(2080, 12, 25);
    Period p = Period.between(today, dead);

    String result = p.getYears() + "y " + p.getMonths() + "m " + p.getDays() + "d";
    assertEquals("54y 8m 2d", result);
  }
}
