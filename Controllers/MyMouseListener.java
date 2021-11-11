package Controllers;

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import Models.Cross;
import Models.Ellipse;
import Models.Line;
import Models.Parallelogram;
import Models.Rectangle;
import Models.Shape;
import Models.Triangle;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MyMouseListener implements MouseInputListener {
    private Point firstClick;
    private MainController controller;
    private JPanel panel;
    private Shape shape;

    public MyMouseListener(MainController controller, JPanel panel) {
        this.panel = panel;
        this.controller = controller;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("mouse clicked");
        Color color = controller.getColor();
        if (firstClick != null) {
            switch (controller.getCurrentSelectedShape()) {
            case "line":
                shape = new Line(color, firstClick, e.getPoint());
                break;
            case "rectangle":
                shape = new Rectangle(color, false, firstClick, e.getPoint());
                break;
            case "parallelogram":
            case "triangle":
                if (!shape.isCompleted) {
                    shape.addPointToShape(e.getPoint());
                }
                break;
            case "cross":
                shape = new Cross(color, false, firstClick, e.getPoint());
                break;
            case "ellipse":
                shape = new Ellipse(controller.getColor(), false, firstClick, e.getPoint());
                break;
            case "murrayPolygon":
                break;
            default:
                break;
            }
            if (shape != null && shape.isCompleted) {
                controller.shapes.add(shape);
                firstClick = null;
            }
            panel.repaint();
        } else {
            this.firstClick = e.getPoint();
            if (controller.getCurrentSelectedShape() == "parallelogram") { // check polygons
                ArrayList<Point> listOfPoints = new ArrayList<Point>();
                listOfPoints.add(e.getPoint());
                this.shape = new Parallelogram(color, false, listOfPoints);
            } else if (controller.getCurrentSelectedShape() == "triangle") {
                ArrayList<Point> listOfPoints = new ArrayList<Point>();
                listOfPoints.add(e.getPoint());
                this.shape = new Triangle(color, false, listOfPoints);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Color color = controller.getColor();
        if (firstClick != null) {
            switch (controller.getCurrentSelectedShape()) {
            case "line":
                shape = new Line(color, firstClick, e.getPoint());
                break;
            case "rectangle":
                shape = new Rectangle(color, false, firstClick, e.getPoint());
                break;
            case "parallelogram":
                shape.removeTailPoint();
                shape.addPointToShape(e.getPoint());
                break;
            case "triangle":
                if (shape.points.size() == 3) {
                    shape.removeTailPoint();
                }
                if (shape.points.size() == 2) {
                    shape.addPointToShape(e.getPoint());
                }
                break;
            case "cross":
                shape = new Cross(color, false, firstClick, e.getPoint());
                break;
            case "ellipse":
                shape = new Ellipse(controller.getColor(), false, firstClick, e.getPoint());
                break;
            case "murrayPolygon":
                break;
            default:
                break;
            }
            if (shape != null) {
                if (controller.shapes.size() > 0) {
                    controller.shapes.remove(controller.shapes.size() - 1);
                }
                controller.shapes.add(shape);
                panel.repaint();
            }
        }
    }

}