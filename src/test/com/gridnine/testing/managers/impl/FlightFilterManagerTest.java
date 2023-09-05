package test.com.gridnine.testing.managers.impl;

import main.com.gridnine.testing.FlightBuilder;
import main.com.gridnine.testing.managers.FilterManager;
import main.com.gridnine.testing.managers.impl.FlightFilterManager;
import main.com.gridnine.testing.models.Flight;
import main.com.gridnine.testing.utils.ContextInitializer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FlightFilterManagerTest {
    ContextInitializer contextInitializer;
    FilterManager ffm;
    List<Flight> flights = FlightBuilder.createFlights();
    LocalDateTime threeDaysFromNow = LocalDateTime.now().plusDays(3);
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void beforeEach() {
        contextInitializer = new ContextInitializer();
        ffm = new FlightFilterManager(contextInitializer);
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void runFilterWithIncorrectCodeTest() {
        ffm.runFilter("123", flights);
        assertEquals("Code is not found\n", outContent.toString());
    }

    @Test
    void runFilterTest() {
        List<Flight> flightsAfterFilter = ffm.runFilter("DEPARTURE_DATE_TILL_NOW_FILTER", flights);
        assertEquals(flightsAfterFilter.size(), 1);
        assertEquals(flightsAfterFilter.get(0).getSegments().get(0).getDepartureDate().getHour(), threeDaysFromNow.getHour());
    }
}
