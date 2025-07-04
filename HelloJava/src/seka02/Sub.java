package seka02;

/**
 * 学習用RPGキャラクター管理システム - 子クラス
 * Mainクラスを継承したキャラクタークラス
 * 継承、コンストラクタチェーン、オーバーロード、オーバーライドの概念を学習
 */
// Mainを継承したキャラクタークラス
public class Sub extends Main {
    // インスタンス変数: 各キャラクター固有の属性
    String name; // キャラクター名
    int hp, atk, def, spd; // ステータス値

    /**
     * デフォルトコンストラクタ: 引数なしで勇者キャラクターを作成
     * 全てのステータスを最高値で初期化
     */
    // デフォルトキャラ（勇者）
    Sub() {
        this.name = "勇者";
        this.hp = 999;
        this.atk = 999;
        this.def = 999;
        this.spd = 1;
    }

    /**
     * 名前指定コンストラクタ: 名前から高野豆腐キャラクターを作成
     * 親クラスのコンストラクタも呼び出してcountを変更
     */
    // 名前から生成＋パワフル版（高野豆腐）
    Sub(String name) {
        super(count); // 親クラスの count を上書き（デモ用）
        this.name = "高野" + name;
        this.hp = 30;
        this.def = 80;
        this.atk = 9999;
        this.spd = 9999;
    }

    /**
     * 完全カスタムコンストラクタ: HP/DEFも指定可能
     * コンストラクタチェーンの例: 他のコンストラクタを呼び出す
     */
    // さらにHP/DEF指定 → 共通のnameコンストラクタを呼び出すだけ
    Sub(String name, int hp, int def) {
        this(name); // Sub(String) を呼ぶ
    }

    /**
     * 通常ステータス出力メソッド
     * キャラクターの全情報を表示し、countをインクリメント
     */
    // 通常ステータス出力
    void stprint() {
        System.out.println("name: " + name);
        System.out.println("hp: " + hp);
        System.out.println("atk: " + atk);
        System.out.println("def: " + def);
        System.out.println("spd: " + spd);
        System.out.println("number: " + Main.count);
        Main.count++; // インクリメント（共通値）
        extendscheck(); // 親メソッドを呼び出し
    }

    /**
     * オーバーロード版: SPD引数付きステータス出力
     * 同じメソッド名で異なる引数を持つメソッド（オーバーロード）
     */
    // SPD引数つき（オーバーロードバージョン）
    void stprint(int spd) {
        System.out.println("name: " + name);
        System.out.println("hp: " + hp);
        System.out.println("atk: " + atk);
        System.out.println("def: " + def);
        System.out.println("this.spd: " + this.spd); // 現在のspd
        System.out.println("→spd: " + spd); // 仮想変更SPD
        System.out.println("number: " + Main.count);
        super.supercheck(); // 親メソッド確認用
        extendscheck(); // 継承メソッド呼び出し
    }

    /**
     * オーバーライドメソッド: 親クラスのメソッドを上書き
     * 
     * @Overrideアノテーションでオーバーライドであることを明示
     */
    // オーバーライドメソッド：親の処理＋子の追加出力
    @Override
    public void overridecheck() {
        super.overridecheck(); // 親のバージョンを呼ぶ
        System.out.println("オーバーライド確認用:これはsubです");
    }
}