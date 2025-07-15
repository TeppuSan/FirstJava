package DeskGameApp;

import java.awt.Color;


import javax.swing.JTextArea;

/**
 * メイン画面に表示するカスタムテキストエリアクラス
 * 
 * このクラスは、JTextAreaを継承して、ゲームアプリケーション用の
 * カスタマイズされたテキストエリアを提供します。
 * 
 * 特徴：
 * - 青い背景色（海や空を表現）
 * - 黒い文字色（読みやすさを重視）
 * - 不透明な背景（背景色を確実に表示）
 * - テキスト入力・編集機能
 * 
 * 用途：
 * - ゲームのログ表示
 * - ユーザーからのテキスト入力
 * - デバッグ情報の表示
 * - 設定値の表示
 * 
 * 使用方法：
 * MainTextArea textArea = new MainTextArea();
 * frame.add(textArea);
 * 
 * カスタマイズ可能な要素：
 * - 背景色（setBackground）
 * - 文字色（setForeground）
 * - フォント（setFont）
 * - 行数・列数（setRows, setColumns）
 * - スクロール設定（setLineWrap, setWrapStyleWord）
 */
public class MainTextArea extends JTextArea {

    /**
     * デフォルトコンストラクタ
     * 
     * このコンストラクタは、MainTextAreaオブジェクトを作成し、
     * 青い背景に黒い文字のスタイリングを適用します。
     * 
     * 初期化の流れ：
     * 1. 親クラス（JTextArea）のコンストラクタを呼び出し
     * 2. 背景色を青に設定
     * 3. 文字色を黒に設定
     * 4. 不透明度を有効化
     * 5. 表示状態を有効化
     * 
     * 注意事項：
     * - テキストエリアは、ユーザーがテキストを入力・編集できます
     * - デフォルトでは空の状態で表示されます
     * - スクロール機能は自動的に提供されます
     */
    public MainTextArea() {
        // 親クラス（JTextArea）のコンストラクタを最初に呼び出す
        // super()は、必ずコンストラクタの最初に呼び出す必要があります
        // これにより、親クラスの初期化が確実に行われます
        super();

        // 背景色を設定（青い背景）
        // Color.BLUEは、RGB値(0, 0, 255)を表します
        // 青い背景で、海や空を連想させるデザインにしています
        setBackground(Color.BLUE);

        // 文字色を設定（黒い文字）
        // Color.BLACKは、RGB値(0, 0, 0)を表します
        // 青い背景に対して、読みやすい黒い文字を使用しています
        setForeground(Color.BLACK);

        // 不透明度を有効化（背景色を表示するために必要）
        // falseの場合、背景色が表示されません
        // trueにすることで、設定した背景色が確実に表示されます
        setOpaque(true);

        // テキストエリアを表示状態にする
        // trueにすることで、テキストエリアが画面に表示されます
        // デフォルトではtrueですが、明示的に設定することで確実性を高めます
        setVisible(true);
    }

    /**
     * テキストエリアにテキストを設定するメソッド
     * 
     * このメソッドを使用して、テキストエリアの内容を設定できます。
     * ゲームの初期メッセージや説明文を表示する際に使用します。
     * 
     * @param text 設定するテキスト内容
     * 
     *             使用例：
     *             textArea.setText("ゲームの説明文をここに表示します。");
     */
    public void setText(String text) {
        super.setText(text);
    }

    /**
     * テキストエリアにテキストを追加するメソッド
     * 
     * このメソッドを使用して、既存のテキストに新しいテキストを追加できます。
     * ゲームのログや進行状況を記録する際に使用します。
     * 
     * @param text 追加するテキスト内容
     * 
     *             使用例：
     *             textArea.append("新しいログメッセージ\n");
     */
    public void appendText(String text) {
        append(text);
    }

    /**
     * テキストエリアの文字色を変更するメソッド
     * 
     * このメソッドを使用して、テキストエリアの文字色を動的に変更できます。
     * ゲームの状態やユーザーの操作に応じて、色を変更できます。
     * 
     * @param color 新しい文字色（Colorオブジェクト）
     * 
     *              使用例：
     *              textArea.changeTextColor(Color.WHITE);
     *              textArea.changeTextColor(new Color(255, 255, 0)); // 黄色
     */
    public void changeTextColor(Color color) {
        setForeground(color);
    }

    /**
     * テキストエリアの背景色を変更するメソッド
     * 
     * このメソッドを使用して、テキストエリアの背景色を動的に変更できます。
     * ゲームの状態やユーザーの操作に応じて、背景色を変更できます。
     * 
     * @param color 新しい背景色（Colorオブジェクト）
     * 
     *              使用例：
     *              textArea.changeBackgroundColor(Color.DARK_GRAY);
     *              textArea.changeBackgroundColor(new Color(100, 100, 255)); // 薄い青
     */
    public void changeBackgroundColor(Color color) {
        setBackground(color);
    }

    /**
     * テキストエリアの内容をクリアするメソッド
     * 
     * このメソッドを使用して、テキストエリアの内容をすべて削除できます。
     * ゲームのリセットや新しいゲーム開始時に使用します。
     * 
     * 使用例：
     * textArea.clearText();
     */
    public void clearText() {
        setText("");
    }

    /**
     * テキストエリアのサイズを設定するメソッド
     * 
     * このメソッドを使用して、テキストエリアの行数と列数を設定できます。
     * 表示サイズを調整する際に使用します。
     * 
     * @param rows    行数
     * @param columns 列数
     * 
     *                使用例：
     *                textArea.setSize(10, 30); // 10行30列
     */
    public void setTextAreaSize(int rows, int columns) {
        setRows(rows);
        setColumns(columns);
    }
}
