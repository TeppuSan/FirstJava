package SutraViewerCli;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.Console;

public class Main {

    public static void main(String[] args) {
        printSutraViewerAsciiArt();  // アプリケーション開始時に表示
        
        Scanner scanner = new Scanner(System.in);
        Console console = System.console();
        
        System.out.println("ユーザー名を入力してください");
        String inputuser = scanner.nextLine();
        String inputpassword;
        if (console != null) {
            char[] passwordChars = console.readPassword("パスワードを入力してください: ");
            inputpassword = new String(passwordChars);
            // パスワードは使い終わったらクリアすることが推奨されます
            Arrays.fill(passwordChars, ' ');
        } else {
            System.out.println("パスワードを入力してください（隠されません）: ");
            inputpassword = scanner.nextLine();
        }

        String url = "jdbc:postgresql://localhost:5432/d_kyouten";
        String user = inputuser;
        String password = inputpassword;

        int i = 1;
        
        while (i == 1) {
            try {
                Class.forName("org.postgresql.Driver");
                try (Connection conn = DriverManager.getConnection(url, user, password)) {
                    System.out.println("Success");
                    DatabaseMetaData metaData = conn.getMetaData();
                    System.out.println("Database: " + metaData.getDatabaseProductName());
                    System.out.println("User: " + metaData.getUserName());
                    String[] types = {"TABLE"};

                    
                    
                    //ResultSet tablesは一度使い切ったので、再度使う場合は新しいインスタンスを作成する必要がある   
                    try (ResultSet contentTables = metaData.getTables(null, null, "%", types)) {
                        String tableSql = "SELECT * FROM t_kyos ORDER BY 1";
                        
                        try (ResultSet contentColumns = metaData.getColumns(null, null, "t_kyos", "%")) {
                            try (ResultSet contentTable = conn.createStatement().executeQuery(tableSql)) {
                                System.out.println("--- テーブル内容 ---");
                                System.out.println("-----------------------");
                                while (contentTable.next()) {//contentTableの中身を一つずつ取り出す
                                    System.out.println("ID    :"+contentTable.getString(1));
                                    System.out.println("経名  :"+contentTable.getString(2));
                                    System.out.println("補足  :"+contentTable.getString(3));  
                                    System.out.println("--------------------------------");
                                }
                            }
                        }
                    }
                    System.out.println("読経する経典のIDを入力してください");
                    String inputId = scanner.nextLine();
                    
                    try {
                        int kyoId = Integer.parseInt(inputId);
                        String inputIdSql = "SELECT * FROM t_verses WHERE kyo_id = ? ORDER BY verses_order";
                        try (var pstmt = conn.prepareStatement(inputIdSql)) {
                            pstmt.setInt(1, kyoId);
                            try (ResultSet inputIdTable = pstmt.executeQuery()) {
                                while (inputIdTable.next()) {
                                    // System.out.print("ID   :"+inputIdTable.getString(3));
                                    System.out.println("読み  :"+inputIdTable.getString(5));
                                    System.out.println("漢字  :"+inputIdTable.getString(4));
                                    String notes = inputIdTable.getString(8);
                                    if (notes != null && !notes.trim().isEmpty()) {
                                        System.out.println("補足  :"+notes);  
                                    }
                                    System.out.println("--------------------------------");
                                    delay(3000);
                                }
                            }
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("IDが不正:"+e.getMessage());
                    }

                    System.out.println("-----------------");
                }
            } catch (ClassNotFoundException e) {
                System.out.println("Driver Error: " + e.getMessage());
            } catch (SQLException e) {
                System.out.println("Connection Error: " + e.getMessage());
            }

            System.out.println("終了する場合はexitを入力してください");
            String inputEnd = scanner.hasNextLine() ? scanner.nextLine() : "";
            if (inputEnd.equals("exit")) {
                i = 0;
            }
        }

        scanner.close();
    }



    public static void printSutraViewerAsciiArt() {String banner = """
        \u001B[36m====================================================================
                     ______  _    _  _______  ____        _
                    / ____/ | |  | ||__   __||  _ \\      /  \\
                   | (___   | |  | |   | |   | |_) )    / /\\ \\
                    \\___ \\  | |  | |   | |   |  _  /   / ____ \\
                    ____) | | |__| |   | |   | | \\ \\  / /    \\ \\
                   |_____/   \\____/    |_|   |_|  \\_\\/_/      \\_\\
        ====================================================================
                            ~ 御経の智慧を、あなたの手に ~
        ====================================================================\u001B[0m
        """;
        System.out.println(banner);
    }

    // 遅延メソッド
    public static void delay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
