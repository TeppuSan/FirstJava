package seka02.improved;

/**
 * 学習用RPGキャラクター管理システム - 子クラス
 * 戦士クラスとして実装し、継承、オーバーライド、オーバーロードの概念を学習
 */
public class Sub extends Main {
    // 戦士固有の属性
    private int hp;
    private int attack;
    private int defense;
    private int speed;

    // 戦士の職業定数
    public static final String JOB_WARRIOR = "戦士";
    public static final String JOB_MAGE = "魔法使い";

    // デフォルトコンストラクタ
    public Sub() {
        super(); // 親クラスのコンストラクタを呼び出し
        this.name = "勇者";
        this.hp = 100;
        this.attack = 50;
        this.defense = 30;
        this.speed = 20;
        System.out.println("戦士キャラクターが作成されました");
    }

    // 名前指定コンストラクタ
    public Sub(String name) {
        super(name, 1); // 親クラスのコンストラクタを呼び出し
        this.hp = 100;
        this.attack = 50;
        this.defense = 30;
        this.speed = 20;
        System.out.println("戦士キャラクター " + name + " が作成されました");
    }

    // 完全カスタムコンストラクタ
    public Sub(String name, int level, int hp, int attack, int defense, int speed) {
        super(name, level); // 親クラスのコンストラクタを呼び出し
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        System.out.println("カスタム戦士キャラクター " + name + " が作成されました");
    }

    // ゲッターメソッド
    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpeed() {
        return speed;
    }

    // セッターメソッド（バリデーション付き）
    public void setHp(int hp) {
        if (hp >= 0) {
            this.hp = hp;
        } else {
            System.out.println("エラー: HPは0以上である必要があります");
        }
    }

    public void setAttack(int attack) {
        if (attack >= 0) {
            this.attack = attack;
        } else {
            System.out.println("エラー: 攻撃力は0以上である必要があります");
        }
    }

    // オーバーライド: 親クラスのメソッドを上書き
    @Override
    public void displayInfo() {
        super.displayInfo(); // 親クラスのメソッドを呼び出し
        System.out.println("HP: " + hp);
        System.out.println("攻撃力: " + attack);
        System.out.println("防御力: " + defense);
        System.out.println("素早さ: " + speed);
        System.out.println("==================");
    }

    // オーバーライド: 特別な行動を定義
    @Override
    public void specialAction() {
        System.out.println(name + "は剣技「スラッシュ」を繰り出しました！");
    }

    // オーバーロード: 引数の数が異なる同名メソッド
    public void attack() {
        System.out.println(name + "の通常攻撃！ダメージ: " + attack);
    }

    public void attack(String target) {
        System.out.println(name + "が" + target + "に攻撃！ダメージ: " + attack);
    }

    public void attack(String target, int power) {
        int damage = attack + power;
        System.out.println(name + "が" + target + "に強力攻撃！ダメージ: " + damage);
    }

    // レベルアップ機能
    public void levelUp() {
        level++;
        hp += 20;
        attack += 10;
        defense += 5;
        speed += 3;
        System.out.println(name + "がレベルアップ！レベル " + level + "になりました");
    }

    // 戦闘メソッド
    public void battle(Sub opponent) {
        System.out.println("=== 戦闘開始 ===");
        System.out.println(name + " vs " + opponent.getName());

        // 素早さで先攻を決定
        if (this.speed >= opponent.getSpeed()) {
            this.attack(opponent.getName());
            opponent.attack(this.name);
        } else {
            opponent.attack(this.name);
            this.attack(opponent.getName());
        }

        System.out.println("=== 戦闘終了 ===");
    }

    // ファイナルメソッドはオーバーライドできない（コンパイルエラーになる）
    // @Override
    // public void finalMethod() {
    // System.out.println("これはオーバーライドできません");
    // }
}