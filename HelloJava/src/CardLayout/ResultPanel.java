package CardLayout;

import javax.swing.*;
import java.awt.*;

public class ResultPanel extends JPanel {
    public ResultPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.ORANGE);

        JLabel resultLabel = new JLabel("結果画面", SwingConstants.CENTER);
        resultLabel.setFont(new Font("メイリオ", Font.BOLD, 20));

        JButton backButton = new JButton("戻る");
        backButton.setPreferredSize(new Dimension(150, 50));

        add(resultLabel, BorderLayout.CENTER);
        add(backButton, BorderLayout.SOUTH);
    }
}
