package HELLOJAVA;

public class Output {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello," + "World!");
        cout();
    }

    public static void cout() {
        System.out.print("I wonder if I can achieve anything.");// 改行なし
        System.out.println("It seems impossible.");// 改行あり
        System.out.printf("My Life Feels %s\n", "Meaningless");// 書式設定可能
        System.err.println("A life full of problems ...");// error時の検証用
        throw new RuntimeException("Why do you intentionally create problems?");// 意図的なerror用
    }
}