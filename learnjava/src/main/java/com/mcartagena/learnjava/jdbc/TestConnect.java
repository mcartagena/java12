package com.mcartagena.learnjava.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnect {
    public static void main(String[] args) throws SQLException {

        try (Connection conn = DriverManager
                .getConnection("jdbc:postgresql://192.168.100.7:5432/java-11-certification"
                        , "postgres", "postgres-java")) {
            System.out.println(conn);

            var insertSql = "INSERT INTO exhibits VALUES(10, 'Deer', 3)";
            var updateSql = "UPDATE exhibits SET name = ''" +
                    "WHERE name = 'None'";
            var deleteSql = "DELETE FROM exhibits WHERE id = 10";

            try (var ps = conn.prepareStatement(insertSql)) {
                int result = ps.executeUpdate();
                System.out.println(result);
            }

            try (var ps = conn.prepareStatement(updateSql)) {
                int result = ps.executeUpdate();
                System.out.println(result);
            }

            try (var ps = conn.prepareStatement(deleteSql)) {
                int result = ps.executeUpdate();
                System.out.println(result);
            }
        }
    }
}