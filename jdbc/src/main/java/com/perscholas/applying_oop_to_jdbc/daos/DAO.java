package com.perscholas.applying_oop_to_jdbc.daos;

import java.sql.*;

import com.perscholas.applying_oop_to_jdbc.exceptions.SQLConnectionException;

public abstract class DAO {
    
    private static final String URL = "jdbc:mariadb://localhost:3306/customer_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String DRIVER_CLASS_NAME = "org.mariadb.jdbc.Driver";

    protected Connection conn;
    protected PreparedStatement ps;
    protected ResultSet rs;

    public void connect() throws SQLConnectionException {
        try {
            Class.forName(DRIVER_CLASS_NAME);
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            throw new SQLConnectionException(e.getMessage(), URL, USERNAME, PASSWORD);
        }
    }

    public void dispose() {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (ps != null && !ps.isClosed()) {
                ps.close();
            }
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) { }
    }
}
