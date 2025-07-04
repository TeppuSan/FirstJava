package Game;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements KeyListener {
    private static final long serialVersionUID = 1L;

    JLabel gamLabel;
    private int playerX = 100;
    private int playerY = 200;
    private boolean gameRunning = false;

    GamePanel() {
        this.setLayout(null);
        this.setBackground(Color.yellow);
        this.setFocusable(true);
        this.addKeyListener(this);
    }

    public void prepareComponents() {
        try {
            gamLabel = new JLabel();
            gamLabel.setText("ゲーム");
            gamLabel.setBounds(playerX, playerY, 100, 30);
            this.add(gamLabel);

            // ゲーム開始
            startGame();
        } catch (Exception e) {
            System.err.println("ゲームコンポーネントの準備に失敗しました: " + e.getMessage());
            JOptionPane.showMessageDialog(this,
                    "ゲームの準備に失敗しました。\n" + e.getMessage(),
                    "エラー",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void startGame() {
        try {
            gameRunning = true;
            System.out.println("ゲーム開始！");
        } catch (Exception e) {
            System.err.println("ゲーム開始に失敗しました: " + e.getMessage());
        }
    }

    public void stopGame() {
        try {
            gameRunning = false;
            System.out.println("ゲーム終了");
        } catch (Exception e) {
            System.err.println("ゲーム終了処理に失敗しました: " + e.getMessage());
        }
    }

    private void movePlayer(int dx, int dy) {
        try {
            if (!gameRunning) {
                return;
            }

            playerX += dx;
            playerY += dy;

            // 画面外に出ないように制限
            if (playerX < 0)
                playerX = 0;
            if (playerX > 700)
                playerX = 700;
            if (playerY < 0)
                playerY = 0;
            if (playerY > 570)
                playerY = 570;

            gamLabel.setBounds(playerX, playerY, 100, 30);
            repaint();
        } catch (Exception e) {
            System.err.println("プレイヤー移動に失敗しました: " + e.getMessage());
        }
    }

    // KeyListenerの実装
    @Override
    public void keyPressed(KeyEvent e) {
        try {
            if (!gameRunning) {
                return;
            }

            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    movePlayer(-10, 0);
                    break;
                case KeyEvent.VK_RIGHT:
                    movePlayer(10, 0);
                    break;
                case KeyEvent.VK_UP:
                    movePlayer(0, -10);
                    break;
                case KeyEvent.VK_DOWN:
                    movePlayer(0, 10);
                    break;
                case KeyEvent.VK_ESCAPE:
                    stopGame();
                    break;
                default:
                    // 無効なキーは無視
                    break;
            }
        } catch (Exception ex) {
            System.err.println("キーイベント処理に失敗しました: " + ex.getMessage());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // キーリリース時の処理（必要に応じて実装）
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // キータイプ時の処理（必要に応じて実装）
    }
}
