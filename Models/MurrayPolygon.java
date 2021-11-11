package Models;

import java.awt.Point;
import java.awt.Color;
import java.util.ArrayList;

public class MurrayPolygon extends Shape {

    public MurrayPolygon(Color color, boolean isFilled, ArrayList<Point> points, boolean isPolygon) {
        super(color, isFilled, points, false, 5); //TODO fix 5
    }

}
