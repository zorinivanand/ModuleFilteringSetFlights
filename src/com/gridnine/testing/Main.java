package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FlightBuilder flightBuilder = new FlightBuilder();
        List<Flight> flights = flightBuilder.createFlights();
        FilterSetFlights filterSetFlights = new FilterSetFlightsImpl();
        System.out.println("Все сегменты,без фильтров ->");
        filterSetFlights.getAllSegments(flights);
        System.out.println("1. вылет до текущего момента времени ->");
        filterSetFlights.startFlyBeforeCurrentTime(flights);
        System.out.println("2. имеются сегменты с датой прилёта раньше даты вылета ->");
        filterSetFlights.segmentsStartFlyDateBeforeFinish(flights);
        System.out.println("3. общее время, проведённое на земле превышает два часа ->");
        filterSetFlights.totalTimeSpentOnEarthExceedsTwoHours(flights);

    }
}

