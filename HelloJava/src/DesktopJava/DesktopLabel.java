package DesktopJava; // このクラスが属するパッケージ（フォルダ）名

// Swing GUI のために必要なクラスのインポート
import javax.swing.BorderFactory; // 枠線を生成するファクトリークラス
import javax.swing.ImageIcon; // 画像をアイコンとして扱うクラス
import javax.swing.JFrame; // ウィンドウ（フレーム）クラス
import javax.swing.JLabel; // テキストや画像を表示するラベルクラス
import javax.swing.border.Border; // 枠線のデータ型（インターフェース）

// AWTパッケージからのインポート（カラー・フォント・イメージ処理）
import java.awt.Color; // 色を定義するクラス
import java.awt.Font; // フォントを定義するクラス
//import java.awt.Image; // イメージデータ（今回は未使用）

public class DesktopLabel { // メインのクラス定義

    public static void main(String[] args) {
        // human.png という画像ファイルをクラスと同じパッケージから読み込む
        ImageIcon image = new ImageIcon(DesktopLabel.class.getResource("human.png"));
        // ↓Imageを使用する読み込み方(今回は未使用)
        // Image image = new ImageIcon("human.png").getImage().getScaledInstance(100,
        // 100, Image.SCALE_SMOOTH);
        // 緑色の線（太さ3ピクセル）でラベルに枠をつける
        Border border = BorderFactory.createLineBorder(Color.green, 3);

        // JLabelインスタンスの作成（画像や文字を表示できる）
        JLabel label = new JLabel();
        label.setText("すみませんよくわかりません"); // ラベルに表示するテキスト
        label.setFont(new Font("Serif", Font.PLAIN, 50)); // テキストのフォント設定（Serif書体、プレーン、50px）
        label.setIcon(image); // ラベルに画像を設定する
        // label.setVisible(true); // ラベルを表示対象にする（実際はadd()していれば不要）
        // ラベル上で画像とテキストの位置関係を設定
        label.setHorizontalTextPosition(JLabel.RIGHT); // 画像の右にテキストを表示
        label.setVerticalTextPosition(JLabel.TOP); // 画像の上にテキストを表示
        // 背景色と文字色の設定
        label.setBackground(Color.red); // ラベルの背景色（デフォルトでは透明）
        label.setForeground(new Color(23, 43, 49)); // テキストの色（ダークブルーグレー）
        label.setOpaque(true); // 不透明にして背景色を表示させるための設定
        label.setBorder(border); // 緑色のボーダーを設定
        // ラベル全体の位置（JFrame内での配置）
        label.setVerticalAlignment(JLabel.CENTER); // 垂直方向の中央に配置
        label.setHorizontalAlignment(JLabel.CENTER); // 水平方向の中央に配置

        // JFrame（ウィンドウ）の準備
        JFrame frame = new JFrame(); // ウィンドウの作成
        frame.setTitle("ここにタイトルを表示"); // タイトルバーの設定
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ウィンドウを閉じるとアプリも終了
        frame.setResizable(true); // ウィンドウサイズを変更可能にする
        frame.setSize(1280, 720); // ウィンドウの初期サイズ（横1280px, 縦720px）
        frame.getContentPane().setBackground(new Color(223, 88, 43)); // 背景色をオレンジ系に設定
        frame.add(label); // 作成したJLabelをウィンドウに追加
        frame.setVisible(true); // ウィンドウを表示（この行がないと画面が出ない）
    }

}