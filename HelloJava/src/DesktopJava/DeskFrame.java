package DesktopJava; // ← このクラスが属するパッケージ名（名前空間のような役割）

import javax.swing.JFrame; // ← JavaのSwingライブラリのウィンドウ（フレーム）を扱うクラス
import java.awt.Color; // ← RGBで色を指定するためのクラス（AWTパッケージ）

public class DeskFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame(); // JFrameのインスタンスを生成（ウィンドウの本体）

        frame.setTitle("うおおおおおおおおおおお"); // ウィンドウタイトルを設定（タイトルバーに表示される）

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ウィンドウを閉じる際、アプリケーションも終了するように設定

        frame.setResizable(true); // ウィンドウサイズをユーザーが変更できるようにする（falseにすると固定）

        frame.setSize(1280, 720); // ウィンドウの初期サイズを幅1280px × 高さ720pxに設定

        frame.setVisible(true); // ウィンドウを画面に表示（この呼び出しを忘れると画面に出ない）

        frame.getContentPane().setBackground(new Color(223, 88, 43)); // ウィンドウの背景色をカスタムカラー（深緑系）で設定
    }
}
