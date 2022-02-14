package cz.pettep.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection createConnection () throws SQLException {
     return   DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
    }
}
