package Gametwo;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
// import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainWindow extends JFrame {
    private static final long serialVersionUID = 1L;

    ScreenMode screenMode = ScreenMode.MAIN;

    final int WIDTH = 400;
    final int HEIGHT = 400;

    CardLayout layout = new CardLayout();

    MainPanel mainPanel;

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
        mainPanel = new MainPanel();
        this.add(mainPanel, "ゲーム画面");
        this.pack();
    }

    public void prepareComponents() {
        mainPanel.prepareComponents();
    }

    public void setFrontScreenAndFocus(ScreenMode s) {
        screenMode = s;
        switch (screenMode) {
            case MAIN:
                layout.show(this.getContentPane(), "メイン画面");
                mainPanel.requestFocus();
                break;
        }
    }
}
