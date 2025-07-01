package MethodJava;

import java.util.Scanner;

public class SplitMethod {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);// scannerを開いて後で入力措置をとれるようにしている
        System.out.print("What is your goal?");// 目標を聞く
        String goal = scanner.nextLine();// String型に値を入力する
        if (goal == null || goal.isEmpty()) {// null又は[]入力の際の処理
            nogoal(goal);
        } else {
            havegoal(goal);
        }
        scanner.close();// 開いたscannerを閉じる
    }

    static void nogoal(String goal) {
        System.out.println("Oh, nothing at all? How... impressive.");// 厭味ったらしく
    }

    static void havegoal(String goal) {
        System.out.println(goal + "? Oh, how very ambitious of you.");// 厭味ったらしく
        System.out.println("Truly inspiring... if only it were realistic.");// 厭味ったらしく
    }

}
