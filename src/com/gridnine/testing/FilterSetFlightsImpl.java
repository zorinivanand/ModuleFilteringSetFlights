package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * реализация фильтров
 */
public class FilterSetFlightsImpl implements FilterSetFlights {
    private DateTimeFormatter getDateFormatter() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
    }
    public void getAllSegments(List<Flight> flights) {
        for (Flight flight : flights ) {
            System.out.println("Flight number: " + flight.getId());
            for(int i = 0; i < flight.getSegments().size(); i++) {
                System.out.println(" Segment number: " + flight.getSegments().get(i).getID() + flight.getSegments().get(i));
            }
        }
    }
    public Set<Flight> startFlyBeforeCurrentTime(List<Flight> flights) {
        Set<Flight> resultSet = new HashSet<>();
        List<Segment> split = new ArrayList<>();
        for (Flight flight : flights ) {
            split.addAll(flight.getSegments());
            while (split.size() > 0) {
                LocalDateTime departureTime = split.get(0).getDepartureDate();
                LocalDateTime arrivalTime = split.remove(0).getArrivalDate();
                if(arrivalTime.isBefore(departureTime)) {
                    showRightFLight(flight, departureTime, arrivalTime);
                    resultSet.add(flight);
                }
            }

        }
        return resultSet;
    }
    public Set<Flight> segmentsStartFlyDateBeforeFinish(List<Flight> flights) {
        LocalDateTime timeNow = LocalDateTime.now();
        Set<Flight> resultSet = new HashSet<>();
        List<Segment> split = new ArrayList<>();
        for (Flight flight : flights ) {
            split.addAll(flight.getSegments());
            while (split.size() > 0) {
                LocalDateTime departureTime = (split.get(0).getDepartureDate());
                LocalDateTime arrivalTime = (split.remove(0).getArrivalDate());
                if(departureTime.isAfter(timeNow)) {
                    showRightFLight(flight, departureTime, arrivalTime);
                    resultSet.add(flight);
                }
            }

        }
        return resultSet;
    }
    public Set<Flight> totalTimeSpentOnEarthExceedsTwoHours(List<Flight> flights) {
        Set<Flight> resultSet = new HashSet<>();
        List<Segment> split = new ArrayList<>();
        for (Flight flight : flights ) {
            split.addAll(flight.getSegments());
            if (split.size() > 2) {
                while (split.size() > 2) {
                    LocalDateTime arrivalTime = split.remove(1).getArrivalDate();
                    LocalDateTime departureTime = split.remove(1).getDepartureDate();
                    if(departureTime.isAfter(arrivalTime.plusHours(2))) {
                        showTransfer(flight, arrivalTime, departureTime);
                        resultSet.add(flight);
                    }
                }
            }
        }
        return resultSet;
    }
    private void showRightFLight(Flight flight, LocalDateTime departureTime, LocalDateTime arrivalTime) {
        DateTimeFormatter dateTimeFormatter = getDateFormatter();
        System.out.println( "Flight number: " + flight.getId()  + " Start Fly: " + dateTimeFormatter.format(departureTime) +  " Finish Fly: " + dateTimeFormatter.format(arrivalTime) + "\n" );
    }
    private void showTransfer(Flight flight, LocalDateTime arrivalTime, LocalDateTime departureTime) {
        DateTimeFormatter dateTimeFormatter = getDateFormatter();
        System.out.println( "Flight number: " + flight.getId()  + " Finish Fly: " + dateTimeFormatter.format(arrivalTime) + " Start Fly: " + dateTimeFormatter.format(departureTime) + "\n"  );
    }
}

