package DeskGameApp;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;

/**
 * メイン画面に表示するカスタムボタンクラス
 * 
 * このクラスは、JButtonを継承して、ゲームアプリケーション用の
 * カスタマイズされたボタンを提供します。
 * 
 * 特徴：
 * - 濃いグレーの背景色（モダンなデザイン）
 * - 白い文字色（視認性を重視）
 * - 不透明な背景（背景色を確実に表示）
 * - マウスホールド時の視覚的フィードバック
 * - Actionインターフェースによるイベント処理
 * 
 * 機能：
 * - クリック時のアクション実行
 * - マウスホールド時の色変更
 * - テキストの動的変更
 * - 視覚的フィードバック
 * 
 * 使用方法：
 * MainButton button = new MainButton();
 * frame.add(button);
 * 
 * カスタマイズ可能な要素：
 * - 背景色（setBackground）
 * - 文字色（setForeground）
 * - テキスト内容（setText）
 * - フォント（setFont）
 * - イベント処理（Action、MouseListener）
 */
public class MainButton extends JButton {

    /**
     * デフォルトコンストラクタ
     * 
     * このコンストラクタは、MainButtonオブジェクトを作成し、
     * モダンなスタイリングとインタラクティブな機能を適用します。
     * 
     * 初期化の流れ：
     * 1. 親クラス（JButton）のコンストラクタを呼び出し
     * 2. 背景色を濃いグレーに設定
     * 3. 文字色を白に設定
     * 4. 不透明度を有効化
     * 5. Actionインターフェースを設定
     * 6. マウスイベントリスナーを追加
     * 7. 表示状態を有効化
     * 
     * イベント処理：
     * - Actionイベント：ボタンクリック時の処理
     * - Mouseイベント：マウスホールド時の視覚的フィードバック
     */
    public MainButton() {
        // 親クラス（JButton）のコンストラクタを最初に呼び出す
        // super()は、必ずコンストラクタの最初に呼び出す必要があります
        // これにより、親クラスの初期化が確実に行われます
        super();

        // 背景色を設定（濃いグレー）
        // Color.DARK_GRAYは、RGB値(64, 64, 64)を表します
        // モダンで洗練された印象を与える色です
        setBackground(Color.DARK_GRAY);

        // 文字色を設定（白い文字）
        // Color.WHITEは、RGB値(255, 255, 255)を表します
        // 濃いグレーの背景に対して、視認性の高い白い文字を使用しています
        setForeground(Color.WHITE);

        // 不透明度を有効化（背景色を表示するために必要）
        // falseの場合、背景色が表示されません
        // trueにすることで、設定した背景色が確実に表示されます
        setOpaque(true);

        // Actionインターフェースでテキストとアクションを設定
        // AbstractActionのコンストラクタでテキストを指定
        // actionPerformedメソッドでクリック時の処理を定義
        setAction(new AbstractAction("Click me!!") {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ボタンクリック時の処理
                // コンソールにメッセージを出力
                System.out.println("Button clicked!!");

                // ここに追加の処理を記述できます
                // 例：ゲームの状態変更、画面遷移、データ更新など
            }
        });

        // マウスホールド時の処理を追加
        // MouseAdapterを使用して、マウスイベントを処理します
        // ユーザーに視覚的フィードバックを提供します
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // マウスを押した時の処理
                // ボタンを押している間、テキストと色を変更
                setText("HOLDING!!");
                setBackground(Color.RED);

                // 視覚的フィードバックにより、ユーザーはボタンが
                // 押されていることを明確に認識できます
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // マウスを離した時の処理
                // ボタンを離すと、元のテキストと色に戻る
                setText("Click me!!");
                setBackground(Color.DARK_GRAY);

                // 元の状態に戻すことで、ボタンの状態が
                // リセットされたことをユーザーに示します
            }
        });

        // ボタンを表示状態にする
        // trueにすることで、ボタンが画面に表示されます
        // デフォルトではtrueですが、明示的に設定することで確実性を高めます
        setVisible(true);
    }

    /**
     * ボタンのテキストを変更するメソッド
     * 
     * このメソッドを使用して、ボタンのテキストを動的に変更できます。
     * ゲームの状態やユーザーの操作に応じて、ボタンの表示を更新できます。
     * 
     * @param newText 新しいテキスト内容
     * 
     *                使用例：
     *                button.updateText("新しいボタンテキスト");
     */
    public void updateText(String newText) {
        setText(newText);
    }

    /**
     * ボタンの文字色を変更するメソッド
     * 
     * このメソッドを使用して、ボタンの文字色を動的に変更できます。
     * ゲームの状態やユーザーの操作に応じて、色を変更できます。
     * 
     * @param color 新しい文字色（Colorオブジェクト）
     * 
     *              使用例：
     *              button.changeTextColor(Color.YELLOW);
     *              button.changeTextColor(new Color(255, 255, 0)); // 黄色
     */
    public void changeTextColor(Color color) {
        setForeground(color);
    }

    /**
     * ボタンの背景色を変更するメソッド
     * 
     * このメソッドを使用して、ボタンの背景色を動的に変更できます。
     * ゲームの状態やユーザーの操作に応じて、背景色を変更できます。
     * 
     * @param color 新しい背景色（Colorオブジェクト）
     * 
     *              使用例：
     *              button.changeBackgroundColor(Color.GREEN);
     *              button.changeBackgroundColor(new Color(0, 255, 0)); // 緑色
     */
    public void changeBackgroundColor(Color color) {
        setBackground(color);
    }

    /**
     * ボタンの有効/無効状態を切り替えるメソッド
     * 
     * このメソッドを使用して、ボタンの有効/無効状態を切り替えることができます。
     * ゲームの状態に応じて、ボタンの操作可否を制御できます。
     * 
     * @param enabled trueで有効、falseで無効
     * 
     *                使用例：
     *                button.setEnabled(false); // ボタンを無効化
     *                button.setEnabled(true); // ボタンを有効化
     */
    public void setButtonEnabled(boolean enabled) {
        setEnabled(enabled);
    }

    /**
     * ボタンのサイズを設定するメソッド
     * 
     * このメソッドを使用して、ボタンの幅と高さを設定できます。
     * レイアウトに応じて、ボタンのサイズを調整できます。
     * 
     * @param width  幅（ピクセル）
     * @param height 高さ（ピクセル）
     * 
     *               使用例：
     *               button.setButtonSize(100, 50); // 幅100px、高さ50px
     */
    public void setButtonSize(int width, int height) {
        setSize(width, height);
        setPreferredSize(new java.awt.Dimension(width, height));
    }
}
