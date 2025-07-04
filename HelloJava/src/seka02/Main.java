package seka02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * 学習用RPGキャラクター管理システム - 親クラス
 * 継承、static変数、オーバーライドの概念を学習するためのサンプル
 */
public class Main {
    // クラス変数（static）: 全インスタンスで共有される変数
    // キャラクターの総数を管理する共通カウンター
    static int count = 1;

    // デフォルトコンストラクタ: 引数なしでインスタンスを作成
    Main() {
        // 何も初期化しない（デフォルト値を使用）
    }

    // 引数付きコンストラクタ: countを変更するためのコンストラクタ
    Main(int count) {
        Main.count = 999; // クラス変数countを999に設定
    }

    /**
     * メインメソッド: プログラムの実行開始点
     * 様々なコンストラクタとメソッドの動作をテスト
     */
    public static void main(String[] args) {
        // 各コンストラクタの動作を試すためのインスタンス生成
        Sub sub = new Sub(); // 引数なし（勇者）
        Sub sub2 = new Sub("豆腐", 1, 1); // 名前＋ステータス（高野豆腐）
        Main conmain = new Main(); // Mainクラスの通常インスタンス
        int spd = 999;

        // 継承とポリモーフィズムの例: SubクラスのインスタンスをMain型の変数に代入（アップキャスト）
        Main main = sub;
        // Main型として扱われるが、実際はSubクラスのインスタンス
        main.check();

        try {
            FileInputStream fis = new FileInputStream("src/seka02/typing.csv"); // ファイルをバイト単位で開く（エンコーディング指定のため）
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8"); // バイトをUTF-8として文字に変換
            BufferedReader bufferedReader = new BufferedReader(isr); // 1行ずつ効率よく読み込む

            System.out.println(bufferedReader.readLine()); // ファイルの1行目を表示（UTF-8指定なので文字化けしない）

            bufferedReader.close(); // BufferedReaderを閉じる（リソース解放）
            isr.close(); // InputStreamReaderを閉じる
            fis.close(); // FileInputStreamを閉じる

            // fileReader.close(); // 以前のFileReader用。今は使っていないのでコメントアウト
        } catch (Exception e) {
            System.out.println("ファイルが見つかりません" + e); // ファイルが見つからない等のエラー時
        }

        // 各種メソッド呼び出し
        sub.stprint(); // 通常ステータス表示
        sub.stprint(spd); // SPD変更シミュレーション
        sub2.stprint(spd); // 別キャラ（sub2）の表示
        conmain.overridecheck(); // 親クラスのメソッド表示
        sub.overridecheck(); // オーバーライドされた子クラスのメソッド表示
    }

    /**
     * 継承確認用メソッド
     * 子クラスから呼び出されることを確認するためのメソッド
     */
    void extendscheck() {
        System.out.println("継承確認用:" + count);
    }

    /**
     * オーバーライド対象のメソッド
     * 子クラスでオーバーライドされることを想定したメソッド
     */
    public void overridecheck() {
        System.out.println("オーバーライド確認用:これはmainの物です");
    }

    /**
     * superで呼ばれる用の親メソッド
     * 子クラスからsuperキーワードで呼び出されるメソッド
     */
    void supercheck() {
        System.out.println("super:で呼び出しています");
    }

    // superで呼ばれる用の親メソッド
    void check() {
        System.out.println(":で呼び出しています");
    }
}