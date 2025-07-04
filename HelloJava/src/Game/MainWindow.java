package Game;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
// import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainWindow extends JFrame {
    private static final long serialVersionUID = 1L;

    ScreenMode screenMode = ScreenMode.TITLE;

    final int WIDTH = 800;
    final int HEIGHT = 600;

    CardLayout layout = new CardLayout();

    TitlePanel titlePanel;
    GamePanel gamePanel;

    MainWindow() {
        this.setTitle("タイトル設定");

        // 画像読み込みの例外処理
        try {
            ImageIcon icon = new ImageIcon(MainWindow.class.getResource("human.png"));
            this.setIconImage(icon.getImage());
        } catch (Exception e) {
            System.err.println("アイコン画像の読み込みに失敗しました: " + e.getMessage());
            // アイコンなしで続行
        }

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.green);
        this.setLayout(layout);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.pack();
        this.setLocationRelativeTo(null);
    }

    public void preparePanels() {
        try {
            titlePanel = new TitlePanel();
            this.add(titlePanel, "タイトル画面");
            gamePanel = new GamePanel();
            this.add(gamePanel, "ゲーム画面");
            this.pack();
        } catch (Exception e) {
            System.err.println("パネルの初期化に失敗しました: " + e.getMessage());
            JOptionPane.showMessageDialog(this,
                    "ゲームの初期化に失敗しました。\n" + e.getMessage(),
                    "エラー",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    public void prepareComponents() {
        try {
            titlePanel.prepareComponents();
            gamePanel.prepareComponents();
        } catch (Exception e) {
            System.err.println("コンポーネントの準備に失敗しました: " + e.getMessage());
            JOptionPane.showMessageDialog(this,
                    "コンポーネントの準備に失敗しました。\n" + e.getMessage(),
                    "エラー",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setFrontScreenAndFocus(ScreenMode s) {
        try {
            screenMode = s;
            switch (screenMode) {
                case TITLE:
                    layout.show(this.getContentPane(), "タイトル画面");
                    titlePanel.requestFocus();
                    break;
                case GAME:
                    layout.show(this.getContentPane(), "ゲーム画面");
                    gamePanel.requestFocus();
                    break;
                default:
                    throw new IllegalArgumentException("無効な画面モード: " + s);
            }
        } catch (Exception e) {
            System.err.println("画面切り替えに失敗しました: " + e.getMessage());
            // デフォルトでタイトル画面に戻す
            try {
                layout.show(this.getContentPane(), "タイトル画面");
                titlePanel.requestFocus();
            } catch (Exception ex) {
                System.err.println("デフォルト画面への切り替えにも失敗しました: " + ex.getMessage());
            }
        }
    }
}
