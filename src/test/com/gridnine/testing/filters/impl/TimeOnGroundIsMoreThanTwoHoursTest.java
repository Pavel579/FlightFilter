package test.com.gridnine.testing.filters.impl;

import main.com.gridnine.testing.FlightBuilder;
import main.com.gridnine.testing.filters.Filter;
import main.com.gridnine.testing.filters.impl.TimeOnGroundIsMoreThanTwoHours;
import main.com.gridnine.testing.models.Flight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeOnGroundIsMoreThanTwoHoursTest {
    Filter filter;
    List<Flight> flights = FlightBuilder.createFlights();
    LocalDateTime threeDaysFromNow = LocalDateTime.now().plusDays(3);

    @BeforeEach
    void beforeEach() {
        filter = new TimeOnGroundIsMoreThanTwoHours();
    }

    @Test
    void checkExecute() {
        List<Flight> flightsAfterFilter = filter.execute(flights);
        assertEquals(flightsAfterFilter.size(), 2);
        assertEquals(flightsAfterFilter.get(0).getSegments().get(1).getArrivalDate().getHour(),
                threeDaysFromNow.plusHours(6).getHour());
        assertEquals(flightsAfterFilter.get(1).getSegments().get(2).getArrivalDate().getHour(),
                threeDaysFromNow.plusHours(7).getHour());
    }
}
