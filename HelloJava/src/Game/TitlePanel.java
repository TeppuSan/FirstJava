package Game;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TitlePanel extends JPanel implements KeyListener {

    private static final long serialVersionUID = 1L;
    JLabel titleLabel;
    private boolean titleReady = false;

    TitlePanel() {
        this.setLayout(null);
        this.setBackground(Color.red);
        this.setFocusable(true);
        this.addKeyListener(this);
    }

    public void prepareComponents() {
        try {
            titleLabel = new JLabel();
            titleLabel.setText("タイトル - スペースキーでゲーム開始");
            titleLabel.setBounds(100, 0, 300, 30);
            this.add(titleLabel);

            // タイトル画面準備完了
            titleReady = true;
            System.out.println("タイトル画面準備完了");
        } catch (Exception e) {
            System.err.println("タイトルコンポーネントの準備に失敗しました: " + e.getMessage());
            JOptionPane.showMessageDialog(this,
                    "タイトル画面の準備に失敗しました。\n" + e.getMessage(),
                    "エラー",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean isTitleReady() {
        return titleReady;
    }

    // KeyListenerの実装
    @Override
    public void keyPressed(KeyEvent e) {
        try {
            if (!titleReady) {
                return;
            }

            switch (e.getKeyCode()) {
                case KeyEvent.VK_SPACE:
                    // ゲーム画面への遷移はMainWindowで処理
                    System.out.println("スペースキーが押されました - ゲーム開始");
                    break;
                case KeyEvent.VK_ESCAPE:
                    System.out.println("ESCキーが押されました - 終了");
                    System.exit(0);
                    break;
                default:
                    // その他のキーは無視
                    break;
            }
        } catch (Exception ex) {
            System.err.println("タイトル画面のキーイベント処理に失敗しました: " + ex.getMessage());
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
