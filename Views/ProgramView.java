package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.border.Border;
import javax.swing.plaf.metal.MetalBorders;

import Controllers.CloseListener;
import Controllers.MainController;

public class ProgramView extends JFrame implements PropertyChangeListener, ActionListener {

    private MainController controller;
    private JToolBar toolbar;
    private JButton color;
    private JButton undo;
    private JButton redo;
    private JButton move;
    private JButton line;
    private JButton rectangle;
    private JButton parallelogram;
    private JButton triangle;
    private JButton cross;
    private JButton ellipse;
    private JButton murrayPolygon;
    private JButton clear;

    private ArrayList<JButton> allButtons = new ArrayList<JButton>();

    public ProgramView() {
        setSize(1024, 768);
        controller = new MainController();
        addMenu();
        addPaintArea();
        addToolbarButtons();
        setVisible(true);
        addActionListenerForButtons(this);
    }

    private void addMenu() {
        JMenuBar menu = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(new CloseListener());
        file.add(exit);
        menu.add(file);
        this.setJMenuBar(menu);
    }

    private void addToolbarButtons() {
        toolbar = new JToolBar();
        color = new JButton("Colour");
        undo = new JButton("Undo");
        redo = new JButton("Redo");
        move = new JButton("Move");
        line = new JButton("Line");
        rectangle = new JButton("Rectangle");
        parallelogram = new JButton("Parallelogram");
        triangle = new JButton("Triangle");
        cross = new JButton("Cross");
        ellipse = new JButton("Ellipse");
        murrayPolygon = new JButton("Murray Polygon");
        clear = new JButton("Clear");

        allButtons.add(color);
        allButtons.add(undo);
        allButtons.add(redo);
        allButtons.add(move);
        allButtons.add(line);
        allButtons.add(rectangle);
        allButtons.add(parallelogram);
        allButtons.add(triangle);
        allButtons.add(cross);
        allButtons.add(ellipse);
        allButtons.add(murrayPolygon);
        allButtons.add(clear);

        for (JButton jButton : allButtons) {
            toolbar.add(jButton);
        }

        add(toolbar, BorderLayout.NORTH);
    }

    private void addPaintArea() {
        DrawArea panel = new DrawArea(controller);
        getContentPane().add(panel, BorderLayout.CENTER);
        // add(panel);
    }

    public void addActionListenerForButtons(ActionListener al) {
        color.addActionListener(al);
        undo.addActionListener(al);
        redo.addActionListener(al);
        move.addActionListener(al);
        line.addActionListener(al);
        rectangle.addActionListener(al);
        parallelogram.addActionListener(al);
        triangle.addActionListener(al);
        cross.addActionListener(al);
        ellipse.addActionListener(al);
        murrayPolygon.addActionListener(al);
        clear.addActionListener(al);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == color) {
            Color newColor = JColorChooser.showDialog(this, "Choose color", controller.getColor());
            controller.setColor(newColor);
        } else if (e.getSource() == undo) {
            controller.undo();
            repaint();
        } else if (e.getSource() == redo) {
            controller.redo();
            repaint();
        } else if (e.getSource() == move) {
            // controller.controlMultiply(valueField.getText());
        } else if (e.getSource() == line) {
            setBorderAndClearRest(line);
            controller.setCurrentSelectedShape("line");
        } else if (e.getSource() == rectangle) {
            setBorderAndClearRest(rectangle);
            controller.setCurrentSelectedShape("rectangle");
        } else if (e.getSource() == parallelogram) {
            setBorderAndClearRest(parallelogram);
            controller.setCurrentSelectedShape("parallelogram");
        } else if (e.getSource() == triangle) {
            setBorderAndClearRest(triangle);
            controller.setCurrentSelectedShape("triangle");
        } else if (e.getSource() == cross) {
            setBorderAndClearRest(cross);
            controller.setCurrentSelectedShape("cross");
        } else if (e.getSource() == ellipse) {
            setBorderAndClearRest(ellipse);
            controller.setCurrentSelectedShape("ellipse");
        } else if (e.getSource() == murrayPolygon) {
            setBorderAndClearRest(murrayPolygon);
            controller.setCurrentSelectedShape("murrayPolygon");
        } else if (e.getSource() == clear) {
            controller.setCurrentSelectedShape("");
            controller.setColor(Color.black);
            controller.shapes.clear();
            repaint();
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        repaint();
    }

    public void setBorderAndClearRest(JButton button) {

        Border loweredbevel = BorderFactory.createLoweredBevelBorder();

        Border normalBorder = BorderFactory.createCompoundBorder(new MetalBorders.ButtonBorder(),
                BorderFactory.createEmptyBorder(3, 3, 3, 3));

        for (JButton jButton : allButtons) {
            if (button != jButton) {
                jButton.setBorder(normalBorder);
            } else {
                button.setBorder(loweredbevel);
            }
        }
        repaint();
    }

}
