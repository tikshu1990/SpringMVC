package com.joona.spring.mvc.components;

import com.joona.spring.mvc.db.connector.DbConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository("postgres")
public class PostgresDAO implements EmpDao {

    private static final String POSTGRES_DRIVER = "org.postgresql.Driver";
    private static final String CONNECTION_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER_NAME = "localuser";
    private static final String PASSWORD = "passw0rd";
    private static final String QUERY = "select * from local_pg.emp;";
    private static final String SCHEMA = "local_pg;";

    private final DbConnector dbConnector;

    @Autowired
    public PostgresDAO(DbConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    @Override
    public boolean mailExists(String email) {
        return false;
    }

    @Override
    public Employee save(Employee empToSave) {
        empToSave.setEmpId(789);
        return empToSave;
    }

    @Override
    public List<Employee> getEmployees() {
        final ConnectionMetaData connectionInfo = ConnectionMetaData.builder()
            .driver(POSTGRES_DRIVER)
            .connectionURL(CONNECTION_URL)
            .userName(USER_NAME)
            .password(PASSWORD)
            .schema(SCHEMA)
            .build();
        List<Employee> employees = new ArrayList<>();
        try {
            System.out.println("Registering postgres driver " + POSTGRES_DRIVER);
            final Class<?> driverClass = Class.forName(POSTGRES_DRIVER);
            System.out.println("PostgreSQL JDBC Driver [ " + POSTGRES_DRIVER + " ] Registered!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("Class [ " + POSTGRES_DRIVER + " ]required is not found. Registration failed");
        }
        Connection connection = null;
        try {
            System.out.println("Initiating connection to postgres db : " + CONNECTION_URL);
            connection = DriverManager.getConnection(CONNECTION_URL, USER_NAME, PASSWORD);
            System.out.println("Connected to DB. Setting schema to " + SCHEMA);
            connection.setSchema(SCHEMA);
            Statement stmt = connection.createStatement();
            System.out.println("Executing the statement" + QUERY);
            ResultSet results = stmt.executeQuery(QUERY);
            System.out.println("Executed the statement ...." + results.getMetaData().getColumnCount());
            while (results.next()) {
                final Employee employee = new Employee();
                employee.setEmpId(results.getInt("e_id"));
                employee.setFirstName(results.getString("first_name"));
                employee.setLastName(results.getString("last_name"));
                employee.setEmailId(results.getString("email"));
                employee.setContactNo(results.getLong("contact_no"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("SQL Exception occurred , unable to execute the query ");
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.err.println("SQL Exception occurred while attempting to close the connection.");
                }
            }
        }

        return employees;
    }
}
