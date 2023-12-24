package space.bum.junit.ch13.flight;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import space.bum.junit.ch13.passen.Passenger;

public class Flight {
  private String flightNumber;
  private int seats;
  private Set<Passenger> passengers = new HashSet<>();

  private static String flightNumberRegex = "^[A-Z]{2}\\d{3,4}$";
  private static Pattern pattern = Pattern.compile(flightNumberRegex);

  public Flight(String flightNumber, int seats) {
    super();
    Matcher matcher = pattern.matcher(flightNumber);
    if (!matcher.matches()) {
      throw new RuntimeException("잘못된 형식의 항공편 번호:" + flightNumber);
    }
    this.flightNumber = flightNumber;
    this.seats = seats;
  }

  public String getFlightNumber() {
    return flightNumber;
  }

  public int getNumberOfPassengers() {
    return passengers.size();
  }
  
  public boolean addPassengers(Passenger passenger) {
    if (getNumberOfPassengers() >= seats) {
      throw new RuntimeException("좌석이 부족한 항공편 번호: " + flightNumber);
    }
    passenger.setFlight(this);
    return passengers.add(passenger);
  }

  public boolean removePassenger(Passenger passenger) {
    return passengers.remove(passenger);
  }
}
