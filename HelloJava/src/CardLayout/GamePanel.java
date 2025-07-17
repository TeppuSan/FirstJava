package CardLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GamePanel extends JPanel implements ActionListener {

    // 他クラスでも参照できるようにpublicにしている
    public int count = 0;
    public static int highScore = 0; // staticに変更
    public int interval = 100;
    public int limitTime = 30;
    public JLabel gameLabel; // インスタンス変数として追加
    public JButton cntButton; // インスタンス変数として追加
    public Timer countTimer;

    // コンストラクタ
    public GamePanel() {
        setLayout(new BorderLayout());
        setBackground(Color.GREEN);
        countTimer = new Timer(interval, this); // thisを渡す

        gameLabel = new JLabel("ゲームパネル", SwingConstants.CENTER); // インスタンス変数に代入
        JLabel scoreLabel = new JLabel("最高得点：" + highScore, SwingConstants.CENTER);
        // 日本語フォントを指定
        gameLabel.setFont(new Font("メイリオ", Font.BOLD, 20));

        cntButton = new JButton("クリックしてください！"); // インスタンス変数に代入
        cntButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count += 10;
                double yenAmount = count * 148.74;
                String formattedYen = String.format("%,.0f", yenAmount);
                System.out.println("2025/07/17時点の日本円換算で" + formattedYen + "円");
                cntButton.setText(String.valueOf(count) + "$");
                gameLabel.setText("日本円換算で" + formattedYen + "円");
                if (count > highScore) {
                    highScore = count;
                    scoreLabel.setText("最高得点：" + highScore);
                }
            }
        });
        cntButton.setPreferredSize(new Dimension(200, 50));

        add(gameLabel, BorderLayout.CENTER);
        add(scoreLabel, BorderLayout.NORTH);
        add(cntButton, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // タイマー処理
        if (e.getSource() == countTimer) {
            // タイマーが発火した時の処理
            limitTime--;
            if (limitTime <= 0) {
                countTimer.stop();
                gameLabel.setText("時間切れです！");
                cntButton.setEnabled(false);
            }
        }
    }
}