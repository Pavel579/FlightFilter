package main.com.gridnine.testing.managers;

import main.com.gridnine.testing.models.Flight;

import java.util.List;

public interface FilterManager {
    void showAllFilters();

    List<Flight> runFilter(String code, List<Flight> flights);

    void showFilteredData(String code, List<Flight> flights);
}
