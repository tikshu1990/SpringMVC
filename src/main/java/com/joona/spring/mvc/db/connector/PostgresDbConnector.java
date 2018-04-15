package com.joona.spring.mvc.db.connector;

import com.joona.spring.mvc.components.ConnectionMetaData;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class PostgresDbConnector implements DbConnector {
    @Override
    public Connection getConnection(ConnectionMetaData metaData) throws SQLException {
        System.out.println("Connecting to DB ... ...");
        Connection connection = DriverManager.getConnection(metaData.getConnectionURL(), metaData.getUserName(), metaData.getPassword());
        connection.setSchema(metaData.getSchema());
        return connection;
    }
}
