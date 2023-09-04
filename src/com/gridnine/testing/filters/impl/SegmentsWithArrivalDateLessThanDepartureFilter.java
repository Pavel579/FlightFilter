package com.gridnine.testing.filters.impl;

import com.gridnine.testing.filters.Filter;
import com.gridnine.testing.models.Flight;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Фильтр возвращает список, где имеются сегменты с датой прилёта раньше даты вылета
 */
public class SegmentsWithArrivalDateLessThanDepartureFilter implements Filter {
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
