package org.example;

import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws SQLException {
        Driver d = new Driver();
        Properties p = new Properties();
        p.put("user", "postgres");
        p.put("password", "password");

        Connection c = d.connect(
                "jdbc:postgresql://localhost:5432/postgres",
                p
        );

        ResultSet stmt = c.prepareCall("select * from test").executeQuery();

        while(stmt.next()){
            String name = stmt.getString("name");
            System.out.printf("name: [%s]\n", name);
        }

        c.close();

        System.out.println("Hello world!");
    }
}