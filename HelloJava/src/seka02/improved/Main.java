package seka02.improved;

/**
 * 学習用RPGキャラクター管理システム - 親クラス
 * 継承、カプセル化、ポリモーフィズムの概念を学習するためのサンプル
 */
public class Main {
    // クラス変数（static）: 全インスタンスで共有
    private static int totalCharacters = 0;

    // インスタンス変数: 各インスタンス固有
    protected String name;
    protected int level;

    // デフォルトコンストラクタ
    public Main() {
        this.name = "無名";
        this.level = 1;
        totalCharacters++;
        System.out.println("新しいキャラクターが作成されました。総数: " + totalCharacters);
    }

    // 引数付きコンストラクタ
    public Main(String name, int level) {
        this.name = name;
        this.level = level;
        totalCharacters++;
        System.out.println("新しいキャラクターが作成されました。総数: " + totalCharacters);
    }

    // ゲッターメソッド（カプセル化の例）
    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    // セッターメソッド（バリデーション付き）
    public void setLevel(int level) {
        if (level > 0) {
            this.level = level;
        } else {
            System.out.println("エラー: レベルは1以上である必要があります");
        }
    }

    // オーバーライド可能なメソッド
    public void displayInfo() {
        System.out.println("=== キャラクター情報 ===");
        System.out.println("名前: " + name);
        System.out.println("レベル: " + level);
    }

    // 継承先でオーバーライドされるメソッド
    public void specialAction() {
        System.out.println(name + "は特別な行動をしました");
    }

    // クラスメソッド（static）
    public static int getTotalCharacters() {
        return totalCharacters;
    }

    // ファイナルメソッド（オーバーライド不可）
    public final void finalMethod() {
        System.out.println("このメソッドはオーバーライドできません");
    }
}