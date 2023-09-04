import com.gridnine.testing.FlightBuilder;
import com.gridnine.testing.managers.FilterManager;
import com.gridnine.testing.managers.impl.FlightFilterManager;
import com.gridnine.testing.models.Flight;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        for (Flight f : flights) {
            System.out.println(f);
        }

        FilterManager ffm = new FlightFilterManager();

        ffm.showAllFilters();
        ffm.showSortedFlights(1, flights);
        ffm.showSortedFlights(2, flights);
        ffm.showSortedFlights(3, flights);

    }
}