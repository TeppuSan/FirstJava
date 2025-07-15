package DeskGameApp;

import java.awt.Color;
import javax.swing.JLabel;

/**
 * メイン画面に表示するカスタムラベルクラス
 * 
 * このクラスは、JLabelを継承して、ゲームアプリケーション用の
 * カスタマイズされたラベルを提供します。
 * 
 * 特徴：
 * - 黒い背景色（地獄の闇を表現）
 * - 赤い文字色（地獄の炎を表現）
 * - 不透明な背景（背景色を確実に表示）
 * - 地獄テーマのメッセージ
 * 
 * 使用方法：
 * MainLabel label = new MainLabel();
 * frame.add(label);
 * 
 * カスタマイズ可能な要素：
 * - 背景色（setBackground）
 * - 文字色（setForeground）
 * - テキスト内容（setText）
 * - フォント（setFont）
 * - 配置（setHorizontalAlignment, setVerticalAlignment）
 */
public class MainLabel extends JLabel {

    /**
     * デフォルトコンストラクタ
     * 
     * このコンストラクタは、MainLabelオブジェクトを作成し、
     * 地獄テーマのスタイリングを適用します。
     * 
     * 初期化の流れ：
     * 1. 親クラス（JLabel）のコンストラクタを呼び出し
     * 2. 背景色を黒に設定
     * 3. 不透明度を有効化
     * 4. テキストを設定
     * 5. 文字色を赤に設定
     * 6. 表示状態を有効化
     */
    public MainLabel() {
        // 親クラス（JLabel）のコンストラクタを最初に呼び出す
        // super()は、必ずコンストラクタの最初に呼び出す必要があります
        // これにより、親クラスの初期化が確実に行われます
        super();

        // 背景色を設定（地獄の闇）
        // Color.BLACKは、RGB値(0, 0, 0)を表します
        // 完全な黒色で、地獄の暗闇を表現します
        setBackground(Color.BLACK);

        // 不透明度を有効化（背景色を表示するために必要）
        // falseの場合、背景色が表示されません
        // trueにすることで、設定した背景色が確実に表示されます
        setOpaque(true);

        // テキストを設定（地獄への招待）
        // 地獄テーマに合わせたメッセージを表示します
        // このテキストは、ユーザーへの最初のメッセージとして機能します
        setText("Welcome to HELL!");

        // テキストの色を設定（地獄の炎）
        // Color.REDは、RGB値(255, 0, 0)を表します
        // 鮮やかな赤色で、地獄の炎を表現します
        // 黒い背景とのコントラストにより、視認性が向上します
        setForeground(Color.RED);

        // ラベルを表示状態にする
        // trueにすることで、ラベルが画面に表示されます
        // デフォルトではtrueですが、明示的に設定することで確実性を高めます
        setVisible(true);
    }

    /**
     * ラベルのテキストを変更するメソッド
     * 
     * このメソッドを使用して、ラベルのテキストを動的に変更できます。
     * ゲームの進行状況やユーザーの操作に応じて、メッセージを更新できます。
     * 
     * @param newText 新しいテキスト内容
     * 
     *                使用例：
     *                label.updateText("新しいメッセージ");
     */
    public void updateText(String newText) {
        setText(newText);
    }

    /**
     * ラベルの文字色を変更するメソッド
     * 
     * このメソッドを使用して、ラベルの文字色を動的に変更できます。
     * ゲームの状態やユーザーの操作に応じて、色を変更できます。
     * 
     * @param color 新しい文字色（Colorオブジェクト）
     * 
     *              使用例：
     *              label.changeColor(Color.GREEN);
     *              label.changeColor(new Color(255, 100, 100)); // カスタム色
     */
    public void changeColor(Color color) {
        setForeground(color);
    }

    /**
     * ラベルの背景色を変更するメソッド
     * 
     * このメソッドを使用して、ラベルの背景色を動的に変更できます。
     * ゲームの状態やユーザーの操作に応じて、背景色を変更できます。
     * 
     * @param color 新しい背景色（Colorオブジェクト）
     * 
     *              使用例：
     *              label.changeBackgroundColor(Color.DARK_GRAY);
     *              label.changeBackgroundColor(new Color(50, 50, 50)); // カスタム色
     */
    public void changeBackgroundColor(Color color) {
        setBackground(color);
    }
}
