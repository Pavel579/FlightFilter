package com.gridnine.testing.managers;

import com.gridnine.testing.models.Flight;

import java.util.List;

public interface FilterManager {
    void showAllFilters();
    List<Flight> runFilter(int id, List<Flight> flights);
    void showSortedFlights(int id, List<Flight> flights);
}
