package Fatality;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Scanner;


/**
 * PostgreSQLデータベース接続テストクラス
 * 
 * このクラスは以下の内容をテストします：
 * 1. JDBCドライバーの読み込み
 * 2. データベースへの接続
 * 3. 接続情報の取得
 * 4. 簡単なSQLクエリの実行
 * 5. リソースの適切な解放
 */
public class DatabaseTest {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("=== PostgreSQL データベース接続テスト ===");
        
        // データベース接続情報の設定
        // jdbc:postgresql://ホスト名:ポート番号/データベース名
        String url = "jdbc:postgresql://localhost:5432/d_test";
        System.out.print("ユーザー名を入力してください: ");
        String user = scanner.nextLine();
        
        System.out.print("パスワードを入力してください: ");
        String password = scanner.nextLine();
        
        try {
            // 1. PostgreSQL JDBCドライバーの読み込み
            // Class.forName()でドライバークラスを動的に読み込み
            // これによりJDBCドライバーがDriverManagerに登録される
            System.out.println("1. JDBCドライバーの読み込み中...");
            Class.forName("org.postgresql.Driver");
            System.out.println("   ✓ JDBCドライバーの読み込み成功");
            
            // 2. データベース接続の確立
            
            // DriverManager.getConnection()でデータベースに接続
            // 接続が成功するとConnectionオブジェクトが返される
            System.out.println("2. データベースに接続中...");
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("   ✓ データベース接続成功");
            
            // 3. 接続情報の確認
            // Connectionオブジェクトからメタデータを取得して接続情報を表示
            System.out.println("3. 接続情報:");
            System.out.println("   - データベース: " + connection.getCatalog());  // 現在のデータベース名
            System.out.println("   - ユーザー: " + connection.getMetaData().getUserName());  // 接続ユーザー名
            System.out.println("   - PostgreSQL バージョン: " + connection.getMetaData().getDatabaseProductVersion());  // DBバージョン
            
            // 4. 簡単なテストクエリの実行
            // Statementオブジェクトを作成してSQLクエリを実行
            // ResultSetで結果を取得
            System.out.println("4. テストクエリ実行中...");
            Statement stmt = connection.createStatement();  // SQL文を実行するためのStatementオブジェクト作成
            ResultSet rs = stmt.executeQuery("SELECT version()");  // PostgreSQLのバージョン情報を取得するクエリ実行
            
            // 結果セットからデータを取得
            // rs.next()で次の行に移動（最初の行を取得）
            if (rs.next()) {
                System.out.println("   ✓ PostgreSQL バージョン: " + rs.getString(1));  // 1番目のカラム（version()の結果）を取得
            }
            
            // 5. リソースの解放
            // データベース接続で使用したリソースを適切に解放
            // メモリリークを防ぎ、接続プールを効率的に使用するため
            rs.close();        // ResultSetを閉じる
            stmt.close();      // Statementを閉じる
            connection.close(); // Connectionを閉じる
            System.out.println("5. 接続を閉じました");
            
            System.out.println("\n=== テスト完了 ===");
            
        } catch (ClassNotFoundException e) {
            // JDBCドライバーが見つからない場合のエラー
            // 通常はJARファイルがクラスパスに含まれていない場合に発生
            System.err.println("❌ JDBCドライバーエラー: " + e.getMessage());
            System.err.println("   解決方法: PostgreSQL JDBCドライバーのJARファイルをクラスパスに追加してください");
            
        } catch (SQLException e) {
            // データベース関連のエラー
            // 接続エラー、権限エラー、SQL文エラーなど
            System.err.println("❌ データベースエラー: " + e.getMessage());
            System.err.println("   確認事項:");
            System.err.println("   - PostgreSQLサーバーが起動しているか");
            System.err.println("   - 接続情報（URL、ユーザー名、パスワード）が正しいか");
            System.err.println("   - データベースが存在するか");
            System.err.println("   - ユーザーに適切な権限があるか");
            
        } catch (Exception e) {
            // その他の予期しないエラー
            System.err.println("❌ 予期しないエラー: " + e.getMessage());
            e.printStackTrace();  // スタックトレースを出力してデバッグ情報を表示
        }
    }
} 