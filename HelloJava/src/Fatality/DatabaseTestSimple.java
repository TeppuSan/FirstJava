package Fatality;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Scanner;

public class DatabaseTestSimple {
    
    public static void main(String[] args) {
        System.out.println("=== PostgreSQL Database Connection Test ===");
        
        // Database connection settings
        String url = "jdbc:postgresql://localhost:5432/d_test";
        
        // User input for authentication
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String user = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        
        try {
            // 1. Load PostgreSQL JDBC Driver
            System.out.println("1. Loading JDBC driver...");
            Class.forName("org.postgresql.Driver");
            System.out.println("   ✓ JDBC driver loaded successfully");
            
            // 2. Establish database connection
            System.out.println("2. Connecting to database...");
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("   ✓ Database connection successful");
            
            // 3. Display connection information
            System.out.println("3. Connection information:");
            System.out.println("   - Database: " + connection.getCatalog());
            System.out.println("   - User: " + connection.getMetaData().getUserName());
            System.out.println("   - PostgreSQL Version: " + connection.getMetaData().getDatabaseProductVersion());
            
            // 4. Execute test query
            System.out.println("4. Executing test query...");
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT version()");
            
            if (rs.next()) {
                System.out.println("   ✓ PostgreSQL Version: " + rs.getString(1));
            }
            
            // 5. Close resources
            rs.close();
            stmt.close();
            connection.close();
            System.out.println("5. Connection closed");
            
            System.out.println("\n=== Test completed ===");
            
        } catch (ClassNotFoundException e) {
            System.err.println("❌ JDBC Driver Error: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("❌ Database Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("❌ Unexpected Error: " + e.getMessage());
        }
    }
} 