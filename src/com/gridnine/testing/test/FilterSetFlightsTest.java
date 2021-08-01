package com.gridnine.testing.test;

import com.gridnine.testing.FilterSetFlights;
import com.gridnine.testing.FilterSetFlightsImpl;
import com.gridnine.testing.Flight;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FilterSetFlightsTest {
    private FlightBuilderCopyForTest flightBuilder = new FlightBuilderCopyForTest();
    private List<Flight> flights = flightBuilder.createFlights();
    private FilterSetFlights filterSetFlights = new FilterSetFlightsImpl();
    @Test
    public void startFlyBeforeCurrentTime() {
        Assert.assertNotNull(flights);
        Assert.assertEquals(1, filterSetFlights.startFlyBeforeCurrentTime(flights).size() );
    }
    @Test
    public void segmentsStartFlyDateBeforeFinish() {
        Assert.assertNotNull(flights);
        Assert.assertEquals(5, filterSetFlights.segmentsStartFlyDateBeforeFinish(flights).size() );
    }
    @Test
    public void totalTimeSpentOnEarthExceedsTwoHours() {
        Assert.assertNotNull(flights);
        Assert.assertEquals(1, filterSetFlights.totalTimeSpentOnEarthExceedsTwoHours(flights).size() );
    }
}
