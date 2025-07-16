package DeskGameApp;

import java.awt.Color;

import javax.swing.JTextArea;

public class MainTextArea extends JTextArea {

    public MainTextArea() {
        super();

        setBackground(Color.LIGHT_GRAY);

        setForeground(Color.CYAN);

        setOpaque(true);

        setVisible(true);
    }

    public void setText(String text) {
        super.setText(text);
    }

    public void appendText(String text) {
        append(text);
    }

    public void changeTextColor(Color color) {
        setForeground(color);
    }

    public void changeBackgroundColor(Color color) {
        setBackground(color);
    }

    public void clearText() {
        setText("");
    }

    public void setTextAreaSize(int rows, int columns) {
        setRows(rows);
        setColumns(columns);
    }
}
