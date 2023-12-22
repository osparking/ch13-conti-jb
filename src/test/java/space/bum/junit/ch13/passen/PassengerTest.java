package space.bum.junit.ch13.passen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PassengerTest {

  @Test
  public void testPassengerCreation() {
    Passenger passenger = new Passenger("123-45-6789", "정석훈", "KR");
    assertNotNull(passenger);
  }

  @Test
  public void testInvalidCountryCode() {
    assertThrows(RuntimeException.class, () -> {
      new Passenger("900-45-6789", "성진호", "JB");
    });
  }

  @Test
  public void testPassengerToString() {
    Passenger passenger = new Passenger("123-45-6789", "정석훈", "KR");
    assertEquals("Passenger(identifier=123-45-6789, name=정석훈, countryCode=KR)",
        passenger.toString());
  }
}
