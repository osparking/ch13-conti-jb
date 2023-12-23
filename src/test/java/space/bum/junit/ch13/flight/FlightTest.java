package space.bum.junit.ch13.flight;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FlightTest {

  @Test
  public void testFlightCreation() {
    Flight flight = new Flight("AA123", 100);
    assertNotNull(flight);
  }

  @Test
  public void testInvalidFlightNumber() {
    assertThrows(RuntimeException.class, () -> {
      new Flight("AA12", 100);
    });
  }
}
