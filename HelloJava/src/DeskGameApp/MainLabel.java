package DeskGameApp;

import java.awt.Color;
import javax.swing.JLabel;

public class MainLabel extends JLabel {

    public MainLabel() {
        super();

        setBackground(Color.BLACK);

        setOpaque(true);

        setText("Welcome to HELL!");

        setForeground(Color.RED);

        setVisible(true);
    }

    public void updateText(String newText) {
        setText(newText);
    }

    public void changeColor(Color color) {
        setForeground(color);
    }

    public void changeBackgroundColor(Color color) {
        setBackground(color);
    }
}
