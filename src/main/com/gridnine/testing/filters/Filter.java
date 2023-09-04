package main.com.gridnine.testing.filters;

import main.com.gridnine.testing.models.Flight;

import java.util.List;

public interface Filter {
    List<Flight> execute(List<Flight> flights);
    String getCode();
}
