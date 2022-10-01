package cybersoft.java18.crm.repository;

import cybersoft.java18.crm.jdbc.JdbcExecute;
import cybersoft.java18.crm.jdbc.MysqlConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class AbstractRepository<T> {
    public List<T> executeQuery(JdbcExecute<List<T>> process) {
        try {
            Connection connection = MysqlConnection.getConnection();
            return process.processor(connection);
        } catch (Exception e) {
            throw new RuntimeException("Error connect database:" + e);
        }
    }

    public Integer executeDeleteAndUpdate(JdbcExecute<Integer> process) {
        try {
            Connection connection = MysqlConnection.getConnection();
            return process.processor(connection);
        } catch (SQLException e) {
            throw new RuntimeException("Error connect database");
        }
    }
}
