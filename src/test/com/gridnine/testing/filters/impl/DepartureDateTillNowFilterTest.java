package test.com.gridnine.testing.filters.impl;

import main.com.gridnine.testing.FlightBuilder;
import main.com.gridnine.testing.filters.Filter;
import main.com.gridnine.testing.filters.impl.DepartureDateTillNowFilter;
import main.com.gridnine.testing.models.Flight;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

public class DepartureDateTillNowFilterTest {
    Filter filter;
    List<Flight> flights = FlightBuilder.createFlights();
    @BeforeEach
    void beforeEach() {
        filter = new DepartureDateTillNowFilter();
    }


}
