package space.bum.junit.ch13.passen;

import java.util.Arrays;
import java.util.Locale;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import space.bum.junit.ch13.flight.Flight;

@Getter
@Setter
@ToString
public class Passenger {
  private String identifier;
  private String name;
  private String countryCode;
  
  private Flight flight;

  public void joinFlight(Flight flight) {
    Flight prev = this.flight;
    if (prev != null) {
      if (!prev.removePassenger(this)) {
        throw new RuntimeException("승객 제거 실패");
      }
    }
    setFlight(flight);
    if (flight != null) {
      if (!flight.addPassengers(this)) {
        throw new RuntimeException("항공편 승객 추가 실패");
      }
    }
  }

  public Passenger(String identifier, String name, String countryCode) {
    super();

    if (!Arrays.asList(Locale.getISOCountries()).contains(countryCode)) {
      throw new RuntimeException("국가 코드 오류");
    }
    this.identifier = identifier;
    this.name = name;
    this.countryCode = countryCode;
  }
}
