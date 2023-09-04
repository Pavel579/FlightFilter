package com.gridnine.testing.filters.impl;

import com.gridnine.testing.filters.Filter;
import com.gridnine.testing.models.Flight;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Фильтр возвращает список, где вылет до текущего момента времени
 */
public class DepartureDateTillNowFilter implements Filter {
    @Override
    public List<Flight> execute(List<Flight> flights) {
        System.out.println("Вылет до текущего момента времени");
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .anyMatch(segment -> segment.getDepartureDate().isBefore(LocalDateTime.now())))
                .collect(Collectors.toList());
    }
}
