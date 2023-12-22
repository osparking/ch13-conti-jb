package space.bum.junit.ch13.passen;

import java.util.Arrays;
import java.util.Locale;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Passenger {
  private String identifier;
  private String name;
  private String countryCode;

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
