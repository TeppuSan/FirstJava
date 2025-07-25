package CardLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ResultPanel extends JPanel {
    // 警告を無視するためのアノテーション
    @SuppressWarnings("unused")
    private Main mainFrame;
    public static JLabel scoreLabel;
    public static JLabel highScoreLabel;
    public static JLabel resultLabel;
    
    public ResultPanel(Main mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());
        setBackground(Color.ORANGE);


        resultLabel = new JLabel("結果画面", SwingConstants.CENTER);
        scoreLabel = new JLabel("結果：" + GamePanel.count, SwingConstants.CENTER);
        highScoreLabel = new JLabel("最高得点：" + GamePanel.highScore, SwingConstants.CENTER);
        resultLabel.setFont(new Font("メイリオ", Font.BOLD, 20));

        JButton backButton = new JButton("タイトルに戻る");
        backButton.setPreferredSize(new Dimension(150, 50));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.cardLayout.show(mainFrame.cardPanel, "TITLE");
            }
        });

        // 上部パネル（スコア表示）
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(highScoreLabel, BorderLayout.NORTH);
        topPanel.add(scoreLabel, BorderLayout.SOUTH);
        
        add(topPanel, BorderLayout.NORTH);
        add(resultLabel, BorderLayout.CENTER);
        add(backButton, BorderLayout.SOUTH);
    }
    
    public static void updateScore(int score) {
        scoreLabel.setText("結果：" + score);
        highScoreLabel.setText("最高得点：" + GamePanel.highScore);
        if(score < 1800){
            resultLabel.setText("結果：" + score + "【初級】まだまだ練習が必要ですね。頑張ってください！");
        }else if(score < 2400){
            resultLabel.setText("結果：" + score + "【中級】なかなか良い成績です。さらに上を目指しましょう！");
        }else if(score < 3000){
            resultLabel.setText("結果：" + score + "【上級】素晴らしい成績です！クリックの腕前が向上していますね！");
        }else if(score < 3600){
            resultLabel.setText("結果：" + score + "【エキスパート】驚異的なスピードです！あなたはクリックの達人です！");
        }else if(score < 4200){
            resultLabel.setText("結果：" + score + "【マスター】完璧なクリック技術です！最高レベルの実力ですね！");
        }else{
            resultLabel.setText("結果：" + score + "【伝説】信じられない記録です！あなたは伝説のクリッカーです！");
        }
    }
}

