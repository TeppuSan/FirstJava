package Gametwo;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
    private static final long serialVersionUID = 1L;

    JLabel gamLabel;

    GamePanel() {
        this.setLayout(null);
        this.setBackground(Color.yellow);
    }

    public void prepareComponents() {

        gamLabel = new JLabel();
        gamLabel.setText("ゲーム");
        gamLabel.setBounds(100, 200, 100, 30);
        this.add(gamLabel);
    }
}
