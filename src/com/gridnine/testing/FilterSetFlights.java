package com.gridnine.testing;

import java.util.List;
import java.util.Set;
/**
 * фильтры выводов списка перелетов
 */
public interface FilterSetFlights {
    void getAllSegments(List<Flight> flights);
    Set<Flight> startFlyBeforeCurrentTime(List<Flight> flights);
    Set<Flight> segmentsStartFlyDateBeforeFinish(List<Flight> flights);
    Set<Flight> totalTimeSpentOnEarthExceedsTwoHours(List<Flight> flights);
}
