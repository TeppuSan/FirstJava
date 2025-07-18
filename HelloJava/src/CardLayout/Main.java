package CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;

public class Main extends JFrame {
    // インスタンス変数(classの中で使う変数)
    public JPanel cardPanel;
    public CardLayout cardLayout;

    // コンストラクタ
    public Main() {
        // CardLayoutを作成
        cardLayout = new CardLayout();
        // CardLayoutを使用するパネルを作成
        cardPanel = new JPanel(cardLayout);

        // パネルを作成(thisはMainクラスのインスタンスを渡すということ)
        TitlePanel titlePanel = new TitlePanel(this);
        GamePanel gamePanel = new GamePanel(this); // ローカル変数として作成
        ResultPanel resultPanel = new ResultPanel(this);

        // パネルを追加
        cardPanel.add(titlePanel, "TITLE");
        cardPanel.add(gamePanel, "GAME");
        cardPanel.add(resultPanel, "RESULT");

        add(cardPanel);
    }

    // Getterメソッド
    public CardLayout getCardLayout() { return cardLayout; }
    public JPanel getCardPanel() { return cardPanel; }
    
    // ゲームリセットメソッド
    public void resetGame() {
        GamePanel.count = 0;
        GamePanel.limitTime = 30;
        GamePanel.gameLabel.setText("ゲームパネル");
        GamePanel.limitTimeLabel.setText("残り時間：" + 30 + "秒");
        GamePanel.cntButton.setText("カウント");
    }
    
    // メインメソッド
    public static void main(String[] args) {
        Main frame = new Main();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 600, 400);
        frame.setTitle("カードレイアウトデモ");
        frame.setVisible(true);
        frame.cardLayout.show(frame.cardPanel, "TITLE");
    }
}
