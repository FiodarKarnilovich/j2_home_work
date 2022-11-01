package my.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {

    public MySqlConnection() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/homesql?createDatabaseIfNotExist=true&serverTimezone=UTC",
                "root",
                "root"
        );
    }
}
