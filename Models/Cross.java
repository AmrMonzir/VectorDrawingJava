package Models;

import java.awt.Point;
import java.awt.Color;

public class Cross extends Shape {

    private Line[] lines = new Line[2];

    public Cross(Color color, boolean isFilled, Point firstPoint, Point secondPoint) {
        super(color, isFilled, firstPoint, secondPoint);
        Point p1 = this.points.get(0);
        Point p2 = this.points.get(1);
        lines[0] = new Line(color, p1, p2);
        lines[1] = new Line(color, new Point((int) p2.getX(), (int) p1.getY()),
                new Point((int) p1.getX(), (int) p2.getY()));
    }

    @Override
    public Line[] getLines() {
        return lines;
    }

    // @Override
    // public Polygon castToPolygon() {
    // Polygon polygon = new Polygon();
    // Point p1 = this.points.get(0);
    // Point p2 = this.points.get(1);

    // polygon.addPoint((int) p1.getX(), (int) p1.getY());
    // polygon.addPoint((int) p2.getX(), (int) p2.getY());

    // polygon.addPoint((int) p2.getX(), (int) p1.getY());
    // polygon.addPoint((int) p1.getX(), (int) p2.getY());

    // return polygon;
    // }

}
