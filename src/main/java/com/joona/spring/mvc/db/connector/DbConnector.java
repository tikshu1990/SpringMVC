package com.joona.spring.mvc.db.connector;

import com.joona.spring.mvc.components.ConnectionMetaData;

import java.sql.Connection;
import java.sql.SQLException;

public interface DbConnector {
    Connection getConnection(ConnectionMetaData connectionMetaData) throws SQLException;
}
