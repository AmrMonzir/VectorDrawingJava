package Models;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.Color;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public abstract class Shape {
    Color color;
    boolean isFilled;
    public ArrayList<Point> points;
    int numOfPoints;
    public boolean isPolygon;
    public boolean isCompleted = false;

    // private PropertyChangeSupport notifier; // tracks and notifies listeners

    public Shape(Color color, boolean isFilled, ArrayList<Point> points, boolean isPolygon, int numOfPoints) {
        this.color = color;
        this.isFilled = isFilled;
        this.points = points;
        this.isPolygon = isPolygon;
        this.numOfPoints = numOfPoints;
    }

    public Shape(Color color, boolean isFilled, Point startPoint, Point endPoint) {
        this.points = new ArrayList<Point>();
        this.color = color;
        this.isFilled = isFilled;
        this.points.add(startPoint);
        if (endPoint != null) {
            this.points.add(endPoint);
        }
        numOfPoints = 2;
        this.isCompleted = true;
    }

    public java.awt.Shape castToGeomShape() {
        return null;
    };

    public Polygon castToPolygon() {
        return null;
    };

    public Color getColor() {
        return this.color;
    }

    public Line[] getLines() {
        return null;
    }

    // /** Register a listener so it will be notified of any changes. */
    // public void addListener(PropertyChangeListener listener) {
    // notifier.addPropertyChangeListener(listener);
    // }

    // /** Broadcast most recent change to all listeners */
    // private void update(int oldPointNum, int newPointNum) {
    // notifier.firePropertyChange("points", oldPointNum, newPointNum);
    // }

    // /** Broadcast most recent change to all listeners */
    // private void update(Color oldColor, Color newColor) {
    // notifier.firePropertyChange("color", oldColor, newColor);
    // }

    public void addPointToShape(Point p) throws IllegalArgumentException {
        if (points.size() > this.numOfPoints) {
            throw new IllegalArgumentException("Max points reached");
        } else {
            this.points.add(p);
            if (this.points.size() >= numOfPoints) {
                this.isCompleted = true;
            }
            // update(points.size() - 1, points.size());
        }
    }

    public void removeTailPoint() throws IllegalArgumentException {
        if (this.points.size() > 1) {
            this.points.remove(this.points.size() - 1);
        }
    }

    public void colorChanged(Color color) throws IllegalArgumentException {
        Color oldColor = this.color;
        this.color = color;
        System.out.println("Color changed from " + oldColor.toString() + " to " + color.toString());
        // update(oldColor, color);
    }

}
