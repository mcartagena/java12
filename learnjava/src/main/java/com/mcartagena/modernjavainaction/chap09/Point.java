package com.mcartagena.modernjavainaction.chap09;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Point {
    private final int x;
    private final int y;

    public Point moveRightBy(int x) {
        return new Point(this.x + x, this.y);
    }

    public final static Comparator<Point> compareByXAndThenY =
            comparing(Point::getX).thenComparing(Point::getY);

    public static List<Point> moveAllPointsRightBy(List<Point> points, int x) {
        return points.stream()
                .map(p -> new Point(p.getX() + x, p.getY()))
                .collect(toList());
    }

}
