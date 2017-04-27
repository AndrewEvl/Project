package connection;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by entity.User on 06.04.2017.
 */
public class ConnectionManager {
    private static final String URL = "jdbc:mysql://localhost:3306/project?autoReconnect=true&useSSL=false&characterEncoding=UTF-8";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static DataSource dataSource;

    static {
        PoolProperties poolProperties = new PoolProperties();
        poolProperties.setDriverClassName("com.mysql.jdbc.Driver");
        poolProperties.setUrl(URL);
        poolProperties.setUsername(USERNAME);
        poolProperties.setPassword(PASSWORD);
        dataSource = new DataSource(poolProperties) {
        };
    }
    private ConnectionManager(){}

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}

