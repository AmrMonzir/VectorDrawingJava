package Models;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.Color;
import java.util.ArrayList;

public class Triangle extends Models.Shape {

    public Triangle(Color color, boolean isFilled, ArrayList<Point> points) {
        super(color, isFilled, points, true, 3);
    }

    @Override
    public Polygon castToPolygon() {
        Polygon polygon = new Polygon();
        Point p0 = this.points.get(0);
        Point p1 = this.points.get(1);
        Point p2 = this.points.get(2);

        polygon.addPoint((int) p0.getX(), (int) p0.getY());
        polygon.addPoint((int) p1.getX(), (int) p1.getY());
        polygon.addPoint((int) p2.getX(), (int) p2.getY());
        polygon.addPoint((int) p0.getX(), (int) p0.getY());

        return polygon;

    }
}
