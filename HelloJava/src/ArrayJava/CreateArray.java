package ArrayJava;

public class CreateArray {
    static int[] num = new int[10];// メソッド外でも可能 staticにすることでクラス全体で共有することが可能に

    public static void main(String[] args) {
        int[] nun;
        nun = new int[10];// メソッド内のみ可能

        for (int i = 0; i < 10; i++) {
            num[i] = i + i * i + i * i * i;// 配列に値を入れている 変化が大きくわかりやすくなるように数字を置きくしている
        }
        nun = num;// nunをnumと紐づけている
        intout(nun);// nunの値を表示
        num[4] = 33;// num[4]に値を入れている
        System.out.println("---------");// 区切ることで分かりやすく
        intout(nun);// num[4]に値を入れてnun[4の値も変わっているのか確認]
        System.out.println("---------");// 区切ることで分かりやすく
        nun[2] = 999;// nun[2]に値を入れている
        intout(num);// nun[2]に値を入れてnum[2の値も変わっているのか確認]
    }

    static void intout(int[] nun) {
        for (int i = 0; i < 10; i++) {
            System.out.println(nun[i]);
        }
    }

}
