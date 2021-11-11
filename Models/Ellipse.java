package Models;

import java.awt.Point;
import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.Shape;

public class Ellipse extends Models.Shape {

    public Ellipse(Color color, boolean isFilled, Point firstPoint, Point secondPoint) {
        super(color, isFilled, firstPoint, secondPoint);
    }

    @Override
    public Shape castToGeomShape() {
        Ellipse2D.Double el = new Ellipse2D.Double(
                this.points.get(0).x > this.points.get(1).x ? this.points.get(1).x : this.points.get(0).x,
                this.points.get(0).y > this.points.get(1).y ? this.points.get(1).y : this.points.get(0).y,
                Math.abs(this.points.get(0).x - this.points.get(1).x),
                Math.abs(this.points.get(0).y - this.points.get(1).y));
        return el;
    }
}
