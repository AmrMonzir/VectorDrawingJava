package Controllers;

import java.util.ArrayList;
import java.awt.Color;

import Models.Shape;

public class MainController {
    public ArrayList<Shape> shapes = new ArrayList<Shape>();
    private String currentSelectedShape = "";
    private Color color = Color.black;

    private ArrayList<Shape> toRedo = new ArrayList<Shape>();

    public Color getColor() {
        return this.color == null ? Color.black : this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getCurrentSelectedShape() {
        return currentSelectedShape;
    }

    public void setCurrentSelectedShape(String currentSelectedShape) {
        this.currentSelectedShape = currentSelectedShape;
    }

    public void undo() {
        if (shapes.size() > 0) {
            toRedo.add(shapes.get(shapes.size() - 1));
            shapes.remove(shapes.size() - 1);
        }
    }

    public void redo() {
        if (toRedo.size() > 0) {
            shapes.add(toRedo.get(toRedo.size() - 1));
            toRedo.remove(toRedo.size() - 1);
        }
    }

}
