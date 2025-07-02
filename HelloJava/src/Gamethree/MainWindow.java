package Gamethree;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
// import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainWindow extends JFrame {
    private static final long serialVersionUID = 1L;

    ScreenMode screenMode = ScreenMode.MAIN;

    final int WIDTH = 800;
    final int HEIGHT = 800;

    CardLayout layout = new CardLayout();

    MainPanel mainPanel;
    TitlePanel titlePanel;

    MainWindow() {
        this.setTitle("タイトル設定");
        // ImageIcon icon = new
        // ImageIcon(getClass().getClassLoader().getResource("human.png"));
        ImageIcon icon = new ImageIcon(MainWindow.class.getResource("human.png"));
        this.setIconImage(icon.getImage());

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.green);
        this.setLayout(layout);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.pack();
        this.setLocationRelativeTo(null);
    }

    public void preparePanels() {
        titlePanel = new TitlePanel();
        titlePanel.prepareComponents();
        this.add(titlePanel, "メイン画面");

        mainPanel = new MainPanel();
        this.add(mainPanel, "ゲーム画面");

        this.pack(); // 1回だけで十分！
    }

    public void prepareComponents() {
        mainPanel.prepareComponents();
    }

    public void setFrontScreenAndFocus(ScreenMode s) {
        screenMode = s;
        switch (screenMode) {
            case MAIN:
                layout.show(this.getContentPane(), "メイン画面");
                titlePanel.setFocusable(true);
                titlePanel.requestFocusInWindow();
                break;
            case GAME:
                layout.show(this.getContentPane(), "ゲーム画面");
                mainPanel.setFocusable(true);
                mainPanel.requestFocusInWindow();
                break;

        }
    }
}
