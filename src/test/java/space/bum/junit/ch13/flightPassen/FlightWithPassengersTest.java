package space.bum.junit.ch13.flightPassen;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import space.bum.junit.ch13.flight.Flight;
import space.bum.junit.ch13.passen.Passenger;

class FlightWithPassengersTest {
  private Flight flight = new Flight("AF1234", 1);

  @Test
  public void testPassengerJoinsFlight() {
    Passenger passenger = new Passenger("123-456-884", "김수미", "KR");
    Flight flight = new Flight("AF345", 100);
    passenger.joinFlight(flight);
    assertEquals(flight, passenger.getFlight());
    assertEquals(1, flight.getNumberOfPassengers());    
  }

  @Test
  void testAddRemovePassengers() throws IOException {
    Passenger passenger = new Passenger("123-456-789", "정다래", "KR");
    assertTrue(flight.addPassengers(passenger));
    assertEquals(1, flight.getNumberOfPassengers());

    assertTrue(flight.removePassenger(passenger));
    assertEquals(0, flight.getNumberOfPassengers());
  }

  @Test
  void testNumberOfSeats() throws IOException {
    Passenger passenger = new Passenger("123-456-789", "정다래", "KR");

    flight.addPassengers(passenger);
    assertEquals(1, flight.getNumberOfPassengers());

    Passenger passenger2 = new Passenger("230-456-789", "다나카", "JP");
    assertThrows(RuntimeException.class,
        () -> flight.addPassengers(passenger2));
  }
}
