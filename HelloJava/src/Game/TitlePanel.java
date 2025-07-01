package Game;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TitlePanel extends JPanel {

    private static final long serialVersionUID = 1L;
    JLabel titleLabel;

    TitlePanel() {
        this.setLayout(null);
        this.setBackground(Color.red);
    }

    public void prepareComponents() {
        titleLabel = new JLabel();
        titleLabel.setText("タイトル");
        titleLabel.setBounds(100, 0, 100, 30);
        this.add(titleLabel);
    }

}
