package com.gridnine.testing.managers.impl;

import com.gridnine.testing.filters.Filter;
import com.gridnine.testing.managers.FilterManager;
import com.gridnine.testing.models.Flight;
import com.gridnine.testing.utils.AccessingAllClassesInPackage;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FlightFilterManager implements FilterManager {
    private static int id = 0;
    private final Map<Integer, Filter> filters = new HashMap<>();

    public FlightFilterManager() {
        AccessingAllClassesInPackage instance = new AccessingAllClassesInPackage();

        Set<Class> classes = instance.findAllClassesUsingClassLoader(
                "com.gridnine.testing.filters.impl");
        try {
            for (Class c : classes) {
                if (Filter.class.isAssignableFrom(c)) {
                    filters.put(assignId(), (Filter) c.getDeclaredConstructor().newInstance());
                }
            }
        }catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            System.out.println("Fault during creating filter object");
        }

    }

    private static int assignId() {
        return ++id;
    }

    public void showAllFilters() {
        for (int i = 1; i <= filters.size(); i++) {
            System.out.println(i + " - " + filters.get(i).getClass().getSimpleName());
        }
    }

    public List<Flight> runFilter(int id, List<Flight> flights) {
        try {
            return filters.get(id).execute(flights);
        } catch (NullPointerException e) {
            System.out.println("id is not found");
        }
        return null;
    }

    public void showSortedFlights(int id, List<Flight> flights) {
        List<Flight> f = runFilter(id, flights);
        for (Flight fl : f) {
            System.out.println(fl);
        }
    }
}
