package CardLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TitlePanel extends JPanel {
    // 警告を無視するためのアノテーション
    @SuppressWarnings("unused")
    private Main mainFrame;
    
    public TitlePanel(Main mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());
        setBackground(Color.BLUE);

        JLabel titleLabel = new JLabel("タイトル画面", SwingConstants.CENTER);
        titleLabel.setFont(new Font("メイリオ", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);

        JButton startButton = new JButton("スタート");
        startButton.setPreferredSize(new Dimension(150, 50));
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("スタートボタンがクリックされました！");
                mainFrame.resetGame();
                mainFrame.getCardLayout().show(mainFrame.getCardPanel(), "GAME");
            }
        });

        add(titleLabel, BorderLayout.CENTER);
        add(startButton, BorderLayout.SOUTH);
    }
}