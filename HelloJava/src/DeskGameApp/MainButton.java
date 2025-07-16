package DeskGameApp;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;

public class MainButton extends JButton {

    private int buttonText = 0;

    public MainButton() {
        super();

        setBackground(Color.DARK_GRAY);

        setForeground(Color.WHITE);

        setOpaque(true);

        setAction(new AbstractAction("Click me!!") {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked!!");
                buttonText++;
                setText(String.valueOf(buttonText));
            }
        });

        setVisible(true);
    }

    public void updateText(String newText) {
        setText(newText);
    }

    public void changeTextColor(Color color) {
        setForeground(color);
    }

    public void changeBackgroundColor(Color color) {
        setBackground(color);
    }

    public void setButtonEnabled(boolean enabled) {
        setEnabled(enabled);
    }

    public void setButtonSize(int width, int height) {
        setSize(width, height);
        setPreferredSize(new java.awt.Dimension(width, height));
    }

    public int getButtonText() {
        return buttonText;
    }
}
