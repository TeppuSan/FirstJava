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
            resultLabel.setText("結果：" + score + "【指の化石】その指は恐竜時代から眠っていた化石か！？クリックする気がないなら、指を切断して博物館に寄贈しろ！🦕💀");
        }else if(score < 2400){
            resultLabel.setText("結果：" + score + "【カタツムリ級】カタツムリがスマホを操作した方が速い！その指は進化の過程で迷子になったのか！？🐌📱");
        }else if(score < 3000){
            resultLabel.setText("結果：" + score + "【人間の証】やっと人間らしくなった！でも、まだまだだ！その指は眠りから覚めたばかりの赤ちゃんか！？👶✨");
        }else if(score < 3600){
            resultLabel.setText("結果：" + score + "【クリックマスター】おお！その指は伝説のクリックマスターの血を引いている！でも、まだ伝説には遠い！🔥⚡");
        }else if(score < 4200){
            resultLabel.setText("結果：" + score + "【神の指】神様、その指は神様です！宇宙の法則を超越したクリック！でも、まだ神様の中では見習いレベル！👑🌟");
        }else{
            resultLabel.setText("結果：" + score + "ルールを守って楽しくクリックしよう！");
        }
    }
}

