package com.gridnine.testing.filters.impl;

import com.gridnine.testing.filters.Filter;
import com.gridnine.testing.models.Flight;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Фильтр возвращает список, где общее время, проведённое на земле превышает два часа
 */
public class TimeOnGroundIsMoreThanTwoHours implements Filter {
    @Override
    public List<Flight> execute(List<Flight> flights) {
        System.out.println("Общее время, проведённое на земле превышает два часа");
        return flights.stream()
                .filter(flight -> {
                    if (flight.getSegments().size() > 1) {
                        long sum = 0;
                        for (int i = 0; i < flight.getSegments().size() - 1; i++) {
                            sum = sum + Duration.between(flight.getSegments().get(i).getArrivalDate(),
                                    flight.getSegments().get(i + 1).getDepartureDate()).toHours();
                            if (sum > 2) {
                                return true;
                            }
                        }
                    }
                    return false;
                })
                .collect(Collectors.toList());
    }
}
