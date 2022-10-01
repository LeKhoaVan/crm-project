package cybersoft.java18.crm.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {
    private final static String URL = "jdbc:mysql://localhost:3306/crm_app";
    private final static String USER = "root";
    private final static String PASSWORD = "1234";

    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(String.format("error while connection database: %s", e));
        }
    }
}
