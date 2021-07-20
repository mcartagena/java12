package com.mcartagena.learnjava.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ReadResulSet {
    public static void main(String[] args) throws SQLException {

        try (Connection conn = DriverManager
                .getConnection("jdbc:postgresql://192.168.100.7:5432/java-11-certification"
                        , "postgres", "postgres-java")) {
            String sql = "SELECT id, name FROM exhibits";

            Map<Integer, String> idToNameMap = new HashMap<>();

            try (var ps = conn.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {
/*                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    idToNameMap.put(id, name);
                }*/
                while (rs.next()) {
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    idToNameMap.put(id, name);
                }
                System.out.println(idToNameMap);
            }

            sql = "SELECT count(*) FROM exhibits";

            try (var ps = conn.prepareStatement(sql);
                 var rs = ps.executeQuery()) {

                if (rs.next()) {
                    int count = rs.getInt(1);
                    System.out.println(count);
                }
            }

            sql = "SELECT count(*) AS count FROM exhibits";

            try (var ps = conn.prepareStatement(sql);
                 var rs = ps.executeQuery()) {

                if (rs.next()) {
                    var count = rs.getInt("count");
                    System.out.println(count);
                }
            }

/*            try (var ps = conn.prepareStatement(sql);
                 var rs = ps.executeQuery()) {

                if (rs.next()) {
                    var count = rs.getInt("total");
                    System.out.println(count);
                }
            }*/

/*            sql = "SELECT * FROM exhibits where name='Not in table'";

            try (var ps = conn.prepareStatement(sql);
                 var rs = ps.executeQuery()) {

                rs.next();
                rs.getInt(1); // SQLException
            }*/

            sql = "SELECT count(*) FROM exhibits";

/*            try (var ps = conn.prepareStatement(sql);
                 var rs = ps.executeQuery()) {

                rs.getInt(1); // SQLException
            }*/

/*            try (var ps = conn.prepareStatement(sql);
                 var rs = ps.executeQuery()) {

                if (rs.next())
                    rs.getInt(0); // SQLException the resultset start in 1
            }*/

            sql = "SELECT name FROM exhibits";

/*            try (var ps = conn.prepareStatement(sql);
                 var rs = ps.executeQuery()) {

                if (rs.next())
                    rs.getInt("badColumn"); // SQLException
            }*/

            sql = "SELECT id, name FROM exhibits";

            try (var ps = conn.prepareStatement(sql);
                 var rs = ps.executeQuery()) {

                while (rs.next()) {
                    Object idField = rs.getObject("id");
                    Object nameField = rs.getObject("name");
                    if (idField instanceof Integer) {
                        int id = (Integer) idField;
                        System.out.println(id);
                    }
                    if (nameField instanceof String) {
                        String name = (String) nameField;
                        System.out.println(name);
                    }
                }
            }

            sql = "SELECT id FROM exhibits WHERE name = ?";

            try (var ps = conn.prepareStatement(sql)) {
                ps.setString(1, "Zebra");
                try (var rs = ps.executeQuery()) {
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        System.out.println(id);
                    }
                }
            }

        }


    }
}
