package main.com.gridnine.testing.filters.impl;

import main.com.gridnine.testing.filters.Filter;
import main.com.gridnine.testing.models.Flight;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Фильтр возвращает список, где имеются сегменты с датой прилёта раньше даты вылета
 */
public class SegmentsWithArrivalDateLessThanDepartureFilter implements Filter {
    private final String code = "SEGMENTS_WITH_ARRIVAL_DATE_LESS_THAN_DEPARTURE_FILTER";

    public String getCode() {
        return code;
    }

    @Override
    public List<Flight> execute(List<Flight> flights) {
        System.out.println("Имеются сегменты с датой прилёта раньше даты вылета");
        return flights.stream()
                .filter(flight -> flight.getSegments()
                        .stream()
                        .anyMatch(segment -> segment.getArrivalDate().isBefore(segment.getDepartureDate())))
                .collect(Collectors.toList());
    }
}
