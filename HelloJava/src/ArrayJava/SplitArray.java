package ArrayJava;

public class SplitArray {
    static int[] num = new int[5];

    public static void main(String[] args) {
        int arsi = num.length / 2;
        inputnum();

        int[] FirstArray = new int[arsi];
        int[] SecondArray;

        if (num.length % 2 == 0) {
            SecondArray = new int[arsi];
        } else {
            SecondArray = new int[arsi + 1];
        }
        System.out.println("-----First-----");
        for (int i = 0; i < arsi; i++) {
            FirstArray[i] = num[i];
            System.out.println(FirstArray[i]);
        }
        System.out.println("------Second-----");
        for (int i = arsi; i < num.length; i++) {
            SecondArray[i - arsi] = num[i];
            System.out.println(SecondArray[i - arsi]);
        }

    }

    public static void inputnum() {
        for (int i = 0; i < num.length; i++) {
            num[i] = (i + i * i) * i;
            System.out.println(num[i]);
        }
    }

}
