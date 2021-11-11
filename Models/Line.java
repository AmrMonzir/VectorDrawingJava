package Models;

import java.awt.Point;
import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Line2D;

public class Line extends Models.Shape {

    public Line(Color color, Point startPoint, Point endPoint) {
        super(color, true, startPoint, endPoint);
    }

    @Override
    public Shape castToGeomShape() {
        Line2D line = new Line2D.Double(this.points.get(0).getX(), this.points.get(0).getY(), this.points.get(1).getX(),
                this.points.get(1).getY());
        return line;
    }

}
