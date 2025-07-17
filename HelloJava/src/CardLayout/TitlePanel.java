package CardLayout;

import javax.swing.*;
import java.awt.*;

public class TitlePanel extends JPanel {
    public TitlePanel() {
        setLayout(new BorderLayout());
        setBackground(Color.BLUE);

        JLabel titleLabel = new JLabel("タイトル画面", SwingConstants.CENTER);
        titleLabel.setFont(new Font("メイリオ", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);

        add(titleLabel, BorderLayout.CENTER);
    }
}