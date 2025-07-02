package Gametwo;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class MainPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    Color backgroundColor = Color.green;
    CatLabel catLabel;
    MyKeyListener myKeyListener;

    MainPanel() {
        this.setLayout(null);
        this.setBackground(Color.red);
    }

    public void prepareComponents() {
        catLabel = new CatLabel();
        this.add(catLabel);
        myKeyListener = new MyKeyListener(this);
    }

    private class MyKeyListener implements KeyListener {
        MainPanel panel;

        MyKeyListener(MainPanel p) {
            super();
            panel = p;
            p.addKeyListener(this);
        }

        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    if (catLabel.getY() > 0) {
                        catLabel.setLocation(catLabel.getX(), catLabel.getY() - 5);
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (catLabel.getY() + catLabel.catImage.getHeight(null) < panel.getHeight()) {
                        catLabel.setLocation(catLabel.getX(), catLabel.getY() + 5);
                    }
                    break;
                case KeyEvent.VK_LEFT:
                    if (catLabel.getX() > 0) {
                        catLabel.setLocation(catLabel.getX() - 5, catLabel.getY());
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (catLabel.getX() + catLabel.catImage.getWidth(null) < panel.getWidth()) {
                        catLabel.setLocation(catLabel.getX() + 5, catLabel.getY());
                    }
                    break;
                case KeyEvent.VK_ENTER:
                    if (backgroundColor == Color.green) {
                        backgroundColor = Color.blue;
                        panel.setBackground(backgroundColor);
                    } else if (backgroundColor == Color.blue) {
                        backgroundColor = Color.green;
                        panel.setBackground(backgroundColor);
                    }
                    break;
            }

        }

        public void keyReleased(KeyEvent e) {

        }
    }

}
