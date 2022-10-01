package cybersoft.java18.crm.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public interface JdbcExecute<T> {
    T processor(Connection connection) throws SQLException;
}
