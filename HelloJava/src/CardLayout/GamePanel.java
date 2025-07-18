package CardLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GamePanel extends JPanel implements ActionListener {
    private Main mainFrame;
    
    //publicとは、他のクラスからも参照できるようにするためのもの
    //privateとは、他のクラスから参照できないようにするためのもの

    //staticとは、クラス変数として扱うためのもの

    // 他クラスでも参照できるようにpublicにしている
    public static int count = 0;
    public static int highScore = 0; // public staticにすることで他のクラスからも参照できるようになる
    public int interval = 100;
    public static float limitTime = 30;
    public static JLabel gameLabel; // インスタンス変数として追加
    public static JLabel limitTimeLabel; // インスタンス変数として追加
    public static JButton cntButton; // インスタンス変数として追加
    public Timer countTimer;

    // コンストラクタ
    public GamePanel(Main mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());
        setBackground(Color.GREEN);
        countTimer = new Timer(interval, this); // thisを渡す
        


        gameLabel = new JLabel("ゲームパネル", SwingConstants.CENTER); // インスタンス変数に代入
        JLabel scoreLabel = new JLabel("最高得点：" + highScore, SwingConstants.CENTER);
        // 日本語フォントを指定
        gameLabel.setFont(new Font("メイリオ", Font.BOLD, 20));
        limitTimeLabel = new JLabel("残り時間：" + 30 + "秒", SwingConstants.CENTER);
        limitTimeLabel.setFont(new Font("メイリオ", Font.BOLD, 20));

        cntButton = new JButton("クリックしてください！"); // インスタンス変数に代入
        
        cntButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(count==0){
                    countTimer.start();
                }
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

        JButton retryButton = new JButton("retry"); // インスタンス変数に代入
        retryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cntButton.setEnabled(true);
                countTimer.stop();
                limitTime = 30;
                count = 0;
                limitTimeLabel.setText("残り時間：" + 30 + "秒");
                gameLabel.setText("ゲームパネル"); // ゲームラベルもリセット
                double yenAmount = count * 148.74;
                String formattedYen = String.format("%,.0f", yenAmount);
                System.out.println("2025/07/17時点の日本円換算で" + formattedYen + "円");
                cntButton.setText(String.valueOf(count) + "$");
                gameLabel.setText("日本円換算で" + formattedYen + "円");
            }
        });
        retryButton.setPreferredSize(new Dimension(100, 30));

        // 上部パネル（スコアと時間）
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(scoreLabel, BorderLayout.NORTH);
        topPanel.add(limitTimeLabel, BorderLayout.SOUTH);
        
        // 右側パネル（リトライボタン）
        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        rightPanel.setOpaque(false);
        rightPanel.add(retryButton);
        
        // 中央パネル（ゲームラベルとボタンを縦に配置）
        JPanel centerPanel = new JPanel();
        centerPanel.setOpaque(false);
        // centerPanel.setBackground(Color.RED);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        
        // 上部の固定空白
        centerPanel.add(Box.createVerticalStrut(50));
        
        // ゲームラベルを中央揃え
        gameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(gameLabel);
        
        centerPanel.add(Box.createVerticalStrut(10)); // 10ピクセルの間隔
        
        // ボタンを中央揃え
        cntButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(cntButton);
        
        // 下部の固定空白
        centerPanel.add(Box.createVerticalStrut(50));
        
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(rightPanel, BorderLayout.EAST);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // タイマー処理
        if (e.getSource() == countTimer) {
            // タイマーが発火した時の処理
            limitTime-=0.1;
            String formatteTime = String.format("%.1f", limitTime);
            limitTimeLabel.setText("残り時間：" + formatteTime + "秒");
            if (limitTime <= 0) {
                countTimer.stop();
                gameLabel.setText("時間切れです！");
                
                // 最終スコアをResultPanelに渡す
                ResultPanel.updateScore(count);
                mainFrame.cardLayout.show(mainFrame.cardPanel, "RESULT");
            }
        }
    }

    public void resetGame() {
        count = 0;
        limitTime = 30;
        limitTimeLabel.setText("残り時間：" + 30 + "秒");
        gameLabel.setText("ゲームパネル"); // ゲームラベルもリセット
    }
}