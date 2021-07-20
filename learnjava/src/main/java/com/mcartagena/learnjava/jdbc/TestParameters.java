package com.mcartagena.learnjava.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestParameters {

    public static void main(String[] args) throws SQLException {
        int key = 10;
        String name = "Deer";
        int type = 3;

        try (Connection conn = DriverManager
                .getConnection("jdbc:postgresql://192.168.100.7:5432/java-11-certification"
                        , "postgres", "postgres-java")) {
            System.out.println(conn);

            var insertSql = "INSERT INTO exhibits VALUES(?, ?, ?)";
            var updateSql = "UPDATE exhibits SET name = ?" +
                    "WHERE name = ?";
            var deleteSql = "DELETE FROM exhibits WHERE id = ?";

            try (var ps = conn.prepareStatement(insertSql)) {
                ps.setInt(1, key);
                ps.setInt(3, type);
                ps.setString(2, name);
                int result = ps.executeUpdate();
                System.out.println(result);
            }

            try (var ps = conn.prepareStatement(updateSql)) {
                ps.setString(1, "");
                ps.setString(2, "None");
                int result = ps.executeUpdate();
                System.out.println(result);
            }

            try (var ps = conn.prepareStatement(deleteSql)) {
                ps.setInt(1, 10);
                int result = ps.executeUpdate();
                System.out.println(result);
            }

            var sql = "INSERT INTO names VALUES(?, ?, ?)";

            try (var ps = conn.prepareStatement(sql)) {

                ps.setInt(1, 20);
                ps.setInt(2, 1);
                ps.setString(3, "Ester");
                ps.executeUpdate();

                ps.setInt(1, 21);
                ps.setString(3, "Elias");
                ps.executeUpdate();
            }

        }
    }
}
