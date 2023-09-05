package test.com.gridnine.testing.filters.impl;

import main.com.gridnine.testing.FlightBuilder;
import main.com.gridnine.testing.filters.Filter;
import main.com.gridnine.testing.filters.impl.DepartureDateTillNowFilter;
import main.com.gridnine.testing.models.Flight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DepartureDateTillNowFilterTest {
    Filter filter;
    List<Flight> flights = FlightBuilder.createFlights();

    @BeforeEach
    void beforeEach() {
        filter = new DepartureDateTillNowFilter();
    }

    @Test
    void checkExecute() {
        List<Flight> flightsAfterFilter = filter.execute(flights);
        assertEquals(flightsAfterFilter.size(), 1);
        assertEquals(flightsAfterFilter.get(0).getSegments().get(0).getDepartureDate().getHour(), 15);
    }


}
