package HELLOJAVA;

import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("What is your goal?");
        String goal = scanner.nextLine();
        if (goal == null || goal.isEmpty()) {
            System.out.println(goal + "Oh, nothing at all? How... impressive.");
            scanner.close();
            return;
        }
        System.out.println(goal + "? Oh, how very ambitious of you.");
        System.out.println("Truly inspiring... if only it were realistic.");
        scanner.close();
    }
}
