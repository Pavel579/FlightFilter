package main.com.gridnine.testing.filters.impl;

import main.com.gridnine.testing.filters.Filter;
import main.com.gridnine.testing.models.Flight;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Фильтр возвращает список, где вылет до текущего момента времени
 */
public class DepartureDateTillNowFilter implements Filter {
    private final String code = "DEPARTURE_DATE_TILL_NOW_FILTER";

    public String getCode() {
        return code;
    }

    @Override
    public List<Flight> execute(List<Flight> flights) {
        System.out.println("Вылет до текущего момента времени");
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .anyMatch(segment -> segment.getDepartureDate().isBefore(LocalDateTime.now())))
                .collect(Collectors.toList());

    }
}
