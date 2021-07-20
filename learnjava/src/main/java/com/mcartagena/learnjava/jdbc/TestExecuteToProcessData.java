package com.mcartagena.learnjava.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestExecuteToProcessData {
    public static void main(String[] args) throws SQLException {

        try (Connection conn = DriverManager
                .getConnection("jdbc:postgresql://192.168.100.7:5432/java-11-certification"
                        , "postgres", "postgres-java")) {

            var sql = "SELECT * FROM exhibits";
            try (var ps = conn.prepareStatement(sql)) {
                boolean isResultSet = ps.execute();
                if(isResultSet){
                    try(ResultSet rs = ps.getResultSet()){
                        System.out.println("Ran a query...");
                    }
                } else {
                    int result = ps.getUpdateCount();
                    System.out.println("Ran an update...");
                }
            }
        }
    }
}
