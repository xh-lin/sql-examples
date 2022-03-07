package com.perscholas.intro_to_jdbc;

import java.sql.*;

public class Main {

    private static final String URL = "jdbc:mariadb://localhost:3306/classicmodels";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String DRIVER_CLASS_NAME = "org.mariadb.jdbc.Driver";
    
    private static final String SELECT_EMPLOYEES_BY_OFFICECODE = 
        "SELECT * FROM employees WHERE officeCode IN (?, ?)";
    private static final String SELECT_ORDERDETAILS_BY_OFFICECODE = 
        "SELECT od.*, e.officeCode FROM orderdetails od " +
            "JOIN orders o ON od.orderNumber = o.orderNumber " + 
            "JOIN customers c ON o.customerNumber = c.customerNumber " +
            "JOIN employees e ON c.salesRepEmployeeNumber = e.employeeNumber " + 
        "WHERE e.officeCode IN (?, ?, ?)";
    private static final String UPDATE_EMPLOYEES_EXTENTION_NUMBER = 
        "UPDATE employees SET extension = ? WHERE officeCode = ?";
    private static final String SELECT_EMPLOYEES_BY_LAST_NAME = 
        "SELECT * FROM employees WHERE LENGTH(lastName) < ?";

    // Select all employees whose officecode is 1, 4
    private static void selectEmployeesByOfficeCode(Connection conn) throws Exception {
        PreparedStatement pstmt = conn.prepareStatement(SELECT_EMPLOYEES_BY_OFFICECODE);
        pstmt.setInt(1, 1);
        pstmt.setInt(2, 4);
        ResultSet rs = pstmt.executeQuery();

        System.out.println("employeeNumber | firstName | officeCode");

        while (rs.next()) {
            int empNum = rs.getInt("employeeNumber");
            String name = rs.getString("firstName");
            int officeCode = rs.getInt("officeCode");
            System.out.printf("%d | %s | %d%n", empNum, name, officeCode);
        }

        pstmt.close();
        rs.close();
    }

    // Select all orderdetails whose officecode is 1,4, and 6
    private static void selectOrderdetailsByOfficecode(Connection conn) throws Exception {
        PreparedStatement pstmt = conn.prepareStatement(SELECT_ORDERDETAILS_BY_OFFICECODE);
        pstmt.setInt(1, 1);
        pstmt.setInt(2, 4);
        pstmt.setInt(3, 6);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            int orderNum = rs.getInt("orderNumber");
            String prodCode = rs.getString("productCode");
            int quanOrdered = rs.getInt("quantityOrdered");
            int officeCode = rs.getInt("officeCode");
            System.out.printf("%d | %s | %d | %d%n", orderNum, prodCode, quanOrdered, officeCode);
        }

        pstmt.close();
        rs.close();
    }

    // Update the extension number of employees whose officecode is 2 
    // and new extension number will be "5698"
    private static void updateEmployeesExtentionNumber(Connection conn) throws Exception {
        PreparedStatement pstmt = conn.prepareStatement(UPDATE_EMPLOYEES_EXTENTION_NUMBER);
        pstmt.setString(1, "x5698");
        pstmt.setInt(2, 2);
        System.out.println(pstmt.executeUpdate() + " rows updated.");

        pstmt.close();
    }

    // Select all employees whose last name is less than 5 characters in length
    private static void selectEmployeesByLastName(Connection conn) throws Exception {
        PreparedStatement pstmt = conn.prepareStatement(SELECT_EMPLOYEES_BY_LAST_NAME);
        pstmt.setInt(1, 5);
        ResultSet rs = pstmt.executeQuery();

        System.out.println("employeeNumber | firstName | lastName");

        while (rs.next()) {
            int empNum = rs.getInt("employeeNumber");
            String firstName = rs.getString("firstName");
            String lastName = rs.getString("lastName");
            System.out.printf("%d | %s | %s%n", empNum, firstName, lastName);
        }

        pstmt.close();
        rs.close();
    }

    public static void main(String... param) throws Exception {
        Class.forName(DRIVER_CLASS_NAME);
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        
        selectEmployeesByOfficeCode(conn);
        selectOrderdetailsByOfficecode(conn);
        updateEmployeesExtentionNumber(conn);
        selectEmployeesByLastName(conn);

        conn.close();
    }

}