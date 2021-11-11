package Models;

import java.awt.Point;
import java.awt.Color;
import java.awt.geom.Rectangle2D;

public class Rectangle extends Shape {

    public Rectangle(Color color, boolean isFilled, Point firstPoint, Point secondPoint) {
        super(color, isFilled, firstPoint, secondPoint);
    }

    @Override
    public Rectangle2D castToGeomShape() {
        Rectangle2D rectangle = new Rectangle2D.Double(this.points.get(0).getX(), this.points.get(0).getY(),
                this.points.get(1).getX() - this.points.get(0).getX(),
                this.points.get(1).getY() - this.points.get(0).getY());
        return rectangle;
    }

}
