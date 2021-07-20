package com.mcartagena.learnjava.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestSQLException {
    public static void main(String[] args) throws SQLException {
        try (Connection conn = DriverManager
                .getConnection("jdbc:postgresql://192.168.100.7:5432/java-11-certification"
                        , "postgres", "postgres-java")) {
            var sql = "SELECT * FROM exhibits";
            try (var ps = conn.prepareStatement(sql)) {
                var result = ps.executeUpdate();
            }
        }
    }
}
