package com.gridnine.testing;

import java.util.List;
import java.util.stream.Collectors;

public class Flight {
    private final List<Segment> segments;
    private  final int  id;

    public Flight(final List<Segment> segs, int id) {
        segments = segs; this.id = id;
    }

    List<Segment> getSegments() {
        return segments;
    }
    public int getId(){return id;}

    @Override
    public String toString() {
        return segments.stream().map(Object::toString)
                .collect(Collectors.joining(" "));
    }
}
