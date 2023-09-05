package main.com.gridnine.testing;

import main.com.gridnine.testing.managers.FilterManager;
import main.com.gridnine.testing.managers.impl.FlightFilterManager;
import main.com.gridnine.testing.models.Flight;
import main.com.gridnine.testing.utils.ContextInitializer;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();

        ContextInitializer contextInitializer = new ContextInitializer();
        FilterManager ffm = new FlightFilterManager(contextInitializer);

        ffm.showAllFilters();
        ffm.showFilteredData("DEPARTURE_DATE_TILL_NOW_FILTER", flights);
        ffm.showFilteredData("SEGMENTS_WITH_ARRIVAL_DATE_LESS_THAN_DEPARTURE_FILTER", flights);
        ffm.showFilteredData("TIME_ON_GROUND_IS_MORE_THAN_TWO_HOURS", flights);
        ffm.showFilteredData("123", flights);
    }
}