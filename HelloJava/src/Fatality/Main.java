package Fatality;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("データベース名を入力してください");
        String inputdb = scanner.nextLine();
        System.out.println("ユーザー名を入力してください");
        String inputuser = scanner.nextLine();
        System.out.println("パスワードを入力してください");
        String inputpassword = scanner.nextLine();

        String url = "jdbc:postgresql://localhost:5432/" + inputdb;
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

                    // テーブル一覧を取得
                    // getTables(catalog, schemaPattern, tableNamePattern, types)
                    // 各引数にnullを指定すると、すべてのカタログ/スキーマ/テーブル名が対象になる
                    try (ResultSet tables = metaData.getTables(null, null, "%", types)) {
                        System.out.println("--- MetaData ---");//実際のデータではなく、メタデータを表示
                        //メタデータはデータベースの構造や情報を取得するためのもの
                        while (tables.next()) {//tableが次の行にあるかどうかを確認
                            System.out.println("--- テーブル ---");
                            // スキーマ名とテーブル名を取得
                            String schemaName = tables.getString("TABLE_SCHEM");
                            String tableName = tables.getString("TABLE_NAME");
                            System.out.println("スキーマ: " + schemaName + ", テーブル: " + tableName);
                            try (ResultSet columns = metaData.getColumns(null, schemaName, tableName, "%")) {
                                System.out.println("--- カラム一覧 ---");
                                while (columns.next()) {
                                    String columnName = columns.getString("COLUMN_NAME");
                                    String columnType = columns.getString("TYPE_NAME");
                                    System.out.println("カラム: " + columnName + ", 型: " + columnType);
                                }
                            }
                            System.out.println("-----------------");
                        }
                    }
                    
                    //ResultSet tablesは一度使い切ったので、再度使う場合は新しいインスタンスを作成する必要がある   
                    try (ResultSet contentTables = metaData.getTables(null, null, "%", types)) {
                        while (contentTables.next()) {//tableが次の行にあるかどうかを確認
                            String schemaName = contentTables.getString("TABLE_SCHEM");
                            String tableName = contentTables.getString("TABLE_NAME");
                            String tableSql = "SELECT * FROM " + schemaName + "." + tableName;
                            System.out.println("--- " + schemaName + "." + tableName + " ---");
                            
                            // カラム情報を取得して一時リストに格納
                            List<String> columnNames = new ArrayList<>();
                            try (ResultSet contentColumns = metaData.getColumns(null, schemaName, tableName, "%")) {
                                while (contentColumns.next()) {
                                    columnNames.add(contentColumns.getString("COLUMN_NAME"));
                                }
                                try (ResultSet contentTable = conn.createStatement().executeQuery(tableSql)) {
                                    System.out.println("--- テーブル内容 ---");
                                    System.out.println(String.join(" | ", columnNames));
                                    System.out.println("-----------------------");
                                    while (contentTable.next()) {//contentTableの中身を一つずつ取り出す
                                        for (String columnName : columnNames) {//この処理はcolumnNamesの数だけ繰り返す
                                            System.out.print(contentTable.getString(columnName) + " | ");
                                        }
                                        System.out.println();
                                    }
                                }
                                System.out.println("-----------------");
                            }
                        }
                    }
                    
                    //SQLに変更を加える場合はここに入力
                    System.out.println("INSERT : DELETE : UPDATE");
                    System.out.println("(helpにて上記のSQL文の入力例の一覧が表示されます)");
                    System.out.println("(変更する場合)SQL文を入力してください");
                    String updateSql = scanner.hasNextLine() ? scanner.nextLine() : "";
                    while (updateSql.equals("help")) {
                        System.out.println("INSERT INTO テーブル名 (カラム名1, カラム名2, ...) VALUES (値1, 値2, ...)");
                        System.out.println("DELETE FROM テーブル名 WHERE カラム名 = 値");
                        System.out.println("UPDATE テーブル名 SET カラム名1 = 値1, カラム名2 = 値2, ... WHERE カラム名 = 値");
                        System.out.println("(変更する場合)SQL文を入力してください");
                        updateSql = scanner.hasNextLine() ? scanner.nextLine() : "";
                    }
                    if (!updateSql.equals("")) {
                        try {
                            Statement userInputStatement = conn.createStatement();
                            userInputStatement.executeUpdate(updateSql);
                            System.out.println("SQL文を実行しました");
                        } catch (SQLException e) {
                            System.out.println("SQL文の実行に失敗しました: " + e.getMessage());
                        }
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
}
