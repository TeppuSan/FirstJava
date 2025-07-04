package seka02.improved;

/**
 * 学習用テストクラス
 * 様々なJavaの概念を試すためのメインメソッド
 */
public class TestMain {
    public static void main(String[] args) {
        System.out.println("=== Java学習用RPGシステム テスト開始 ===\n");

        // 1. コンストラクタのテスト
        System.out.println("1. コンストラクタのテスト");
        System.out.println("------------------------");
        Sub warrior1 = new Sub(); // デフォルトコンストラクタ
        Sub warrior2 = new Sub("アーサー"); // 名前指定コンストラクタ
        Sub warrior3 = new Sub("ガイ", 5, 150, 80, 50, 30); // 完全カスタムコンストラクタ

        System.out.println("\n2. 情報表示のテスト");
        System.out.println("------------------");
        warrior1.displayInfo();
        warrior2.displayInfo();
        warrior3.displayInfo();

        // 3. オーバーロードのテスト
        System.out.println("3. オーバーロードのテスト");
        System.out.println("------------------------");
        warrior1.attack();
        warrior2.attack("ドラゴン");
        warrior3.attack("魔王", 50);

        // 4. オーバーライドのテスト
        System.out.println("\n4. オーバーライドのテスト");
        System.out.println("------------------------");
        Main baseChar = new Main("ベース", 1);
        baseChar.specialAction();
        warrior1.specialAction();

        // 5. ポリモーフィズムのテスト
        System.out.println("\n5. ポリモーフィズムのテスト");
        System.out.println("--------------------------");
        Main[] characters = { baseChar, warrior1, warrior2, warrior3 };
        for (Main character : characters) {
            character.displayInfo();
        }

        // 6. ゲッター・セッターのテスト
        System.out.println("6. ゲッター・セッターのテスト");
        System.out.println("----------------------------");
        System.out.println("戦士1の現在のHP: " + warrior1.getHp());
        warrior1.setHp(200);
        System.out.println("戦士1のHPを200に変更: " + warrior1.getHp());

        // バリデーションのテスト
        warrior1.setHp(-10); // エラーになるはず
        warrior1.setAttack(-5); // エラーになるはず

        // 7. レベルアップのテスト
        System.out.println("\n7. レベルアップのテスト");
        System.out.println("----------------------");
        warrior1.displayInfo();
        warrior1.levelUp();
        warrior1.displayInfo();

        // 8. 戦闘システムのテスト
        System.out.println("8. 戦闘システムのテスト");
        System.out.println("----------------------");
        warrior1.battle(warrior2);

        // 9. クラス変数（static）のテスト
        System.out.println("\n9. クラス変数のテスト");
        System.out.println("--------------------");
        System.out.println("作成されたキャラクター総数: " + Main.getTotalCharacters());

        // 10. ファイナルメソッドのテスト
        System.out.println("\n10. ファイナルメソッドのテスト");
        System.out.println("-----------------------------");
        baseChar.finalMethod();
        warrior1.finalMethod();

        System.out.println("\n=== テスト終了 ===");
    }
}