package seka01;

public class Main {
    public static void main(String[] args) {
        Sub sub = new Sub();// ここで同一パッケージ内にあるsubクラスを持つものを呼び出してインスタンス化している
        sub.subprint();// Subクラスの関数subprintを呼び出している
    }
}
