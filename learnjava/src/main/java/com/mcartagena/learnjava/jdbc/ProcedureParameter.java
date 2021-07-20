package com.mcartagena.learnjava.jdbc;

import java.sql.*;

public class ProcedureParameter {
    public static void main(String[] args) throws SQLException {

        try (Connection conn = DriverManager
                .getConnection("jdbc:postgresql://192.168.100.7:5432/java-11-certification"
                        , "postgres", "postgres-java")) {

            String sql = "{call read_e_names()}";

            try (CallableStatement cs = conn.prepareCall(sql);
                 ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    System.out.println(rs.getString(3));
                }
            }

            sql = "{call read_names_by_letter(?)}";
            try (var cs = conn.prepareCall(sql)) {
                cs.setString(1,"Z");
                try (var rs = cs.executeQuery()) {
                    while (rs.next()) {
                        System.out.println(rs.getString(3));
                    }
                }
            }

            sql = "{call magic_number(?) }";
            try (var cs = conn.prepareCall(sql)) {
                cs.registerOutParameter(1, Types.INTEGER);
                cs.execute();
                System.out.println(cs.getInt(1));
            }

            sql = "{call double_number(?)}";
            try (var cs = conn.prepareCall(sql)) {
                cs.setInt(1, 8);
                cs.registerOutParameter(1, Types.INTEGER);
                cs.execute();
                System.out.println(cs.getInt(1));
            }

        }


    }
}
