package HELLOJAVA;

import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);// scannerを開いて後で入力措置をとれるようにしている
        System.out.print("What is your goal?");// 目標を聞く
        String goal = scanner.nextLine();// String型に値を入力する
        if (goal == null || goal.isEmpty()) {// null又は[]入力の際の処理
            System.out.println(goal + "Oh, nothing at all? How... impressive.");// わざとgoal+を入れることでより厭味ったらしく
            scanner.close();// 開いたscannerを閉じる
            return;
        }
        System.out.println(goal + "? Oh, how very ambitious of you.");// 厭味ったらしく
        System.out.println("Truly inspiring... if only it were realistic.");// 厭味ったらしく
        scanner.close();// 開いたscannerを閉じる
    }
}
