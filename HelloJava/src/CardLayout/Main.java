package CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;

public class Main extends JFrame {
    // インスタンス変数(classの中で使う変数)
    JPanel cardPanel;
    public CardLayout cardLayout;
    GamePanel gamePanel; // インスタンス変数として追加

    // コンストラクタ
    public Main() {
        // CardLayoutを作成
        cardLayout = new CardLayout();
        // CardLayoutを使用するパネルを作成
        cardPanel = new JPanel(cardLayout);

        // パネルを作成
        TitlePanel titlePanel = new TitlePanel();
        gamePanel = new GamePanel(); // インスタンス変数に代入
        ResultPanel resultPanel = new ResultPanel();

        // パネルを追加
        cardPanel.add(titlePanel, "TITLE");
        cardPanel.add(gamePanel, "GAME");
        cardPanel.add(resultPanel, "RESULT");

        add(cardPanel);
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
