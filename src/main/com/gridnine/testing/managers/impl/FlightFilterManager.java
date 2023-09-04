package main.com.gridnine.testing.managers.impl;

import main.com.gridnine.testing.filters.Filter;
import main.com.gridnine.testing.managers.FilterManager;
import main.com.gridnine.testing.models.Flight;
import main.com.gridnine.testing.utils.ContextInitializer;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class FlightFilterManager implements FilterManager {
    private final Map<String, Filter> filters = new HashMap<>();

    public FlightFilterManager(ContextInitializer contextInitializer) {
        Set<Class> classes = contextInitializer.getContext();
        try {
            for (Class c : classes) {
                if (Filter.class.isAssignableFrom(c)) {
                    Filter filter = (Filter) c.getDeclaredConstructor().newInstance();
                    filters.put(filter.getCode(), filter);
                }
            }
        }catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            System.out.println("Fault during creating filter object");
        }
    }

    public void showAllFilters() {
        for (Map.Entry<String, Filter> entry : filters.entrySet() ) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getClass().getSimpleName());
        }
    }

    public List<Flight> runFilter(String code, List<Flight> flights) {
        try {
            return filters.get(code).execute(flights);
        } catch (NullPointerException e) {
            System.out.println("Code is not found");
        }
        return new ArrayList<>();
    }

    public void showFilteredData(String code, List<Flight> flights) {
        List<Flight> f = runFilter(code, flights);
        for (Flight fl : f) {
            System.out.println(fl);
        }
    }
}
