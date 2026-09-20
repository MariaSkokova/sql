import java.sql.*;

public class Main {
    public static void main(String[] args) throws Exception {

        String url = "jdbc:postgresql://db:5432/testdb";
        String user = "postgres";
        String password = "password";

        System.out.println("Connecting to database...");

        Connection connection = DriverManager.getConnection(url, user, password);

        Statement statement = connection.createStatement();

        statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS test (id SERIAL PRIMARY KEY, message TEXT)"
        );

        statement.executeUpdate(
                "INSERT INTO test (message) VALUES ('Hello from Java!')"
        );

        ResultSet result = statement.executeQuery(
                "SELECT message FROM test ORDER BY id DESC LIMIT 1"
        );

        if (result.next()) {
            System.out.println("Database says: " + result.getString("message"));
        }

        connection.close();

        System.out.println("Done!");
    }
}

