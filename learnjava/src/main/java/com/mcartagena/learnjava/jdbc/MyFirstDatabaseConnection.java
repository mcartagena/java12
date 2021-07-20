package com.mcartagena.learnjava.jdbc;

import java.sql.*;

public class MyFirstDatabaseConnection {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://192.168.100.7:5432/java-11-certification";
        try(Connection conn = DriverManager.getConnection(url,"postgres","postgres-java");
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT name FROM exhibits"
            );
            ResultSet rs = ps.executeQuery()){
            while (rs.next()){
                System.out.println(rs.getString(1));
            }
        }

    }
}
