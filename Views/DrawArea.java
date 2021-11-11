package Views;

import javax.swing.JPanel;

import Controllers.MainController;
import Controllers.MyMouseListener;
import Models.Shape;

import java.awt.Graphics;
import java.awt.RenderingHints;
import java.awt.Graphics2D;

public class DrawArea extends JPanel {

    private MainController controller;

    public DrawArea(MainController controller) {
        this.controller = controller;
        init();
    }

    private void init() {
        setAlignmentX(0);
        setAlignmentY(100);
        MyMouseListener mouseListener = new MyMouseListener(controller, this);
        addMouseListener(mouseListener);
        addMouseMotionListener(mouseListener);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for (Shape shape : controller.shapes) {
            g2d.setColor(shape.getColor());
            if (shape.isPolygon) {
                if (shape.isCompleted) {
                    g2d.drawPolygon(shape.castToPolygon());
                } else {
                    return;
                }
            } else if (shape.getLines() != null) {
                for (Shape line : shape.getLines()) {
                    g2d.draw(line.castToGeomShape());
                }
            } else {
                g2d.draw(shape.castToGeomShape());
            }
        }
    }
}
