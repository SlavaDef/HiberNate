package storage;

import entity.Client;
import entity.Planet;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionProvider {

    private List<Connection> connections;


    public ConnectionProvider() {
        connections = new ArrayList<>();
    }

    public Connection createConnection() throws SQLException {
        Connection result = DriverManager.getConnection(StorageConstants.CONNECTION_URL);

        connections.add(result);
        return result;
    }

    public void close() throws SQLException {
        for (Connection connection : connections) {
            if (connection.isClosed()) {
                continue;
            }
            connection.close();
        }
    }


}
