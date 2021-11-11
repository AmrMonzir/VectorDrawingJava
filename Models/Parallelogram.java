package Models;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.Color;
import java.util.ArrayList;

public class Parallelogram extends Shape {

    private final int SLOPE = -5;

    public Parallelogram(Color color, boolean isFilled, ArrayList<Point> points) {
        super(color, isFilled, points, true, 2);
    }

    @Override
    public Polygon castToPolygon() {
        Polygon polygon = new Polygon();
        Point p0 = this.points.get(0);
        Point p1 = this.points.get(1);

        int x1 = (int) -(p1.getY() - p0.getY() - SLOPE * p1.getX()) / SLOPE;
        int x3 = (int) (p1.getY() - p0.getY() + SLOPE * p0.getX()) / SLOPE;

        polygon.addPoint((int) p0.getX(), (int) p0.getY());

        polygon.addPoint(x1, (int) p0.getY());

        polygon.addPoint((int) p1.getX(), (int) p1.getY());

        polygon.addPoint(x3, (int) p1.getY());

        return polygon;

    }

}
