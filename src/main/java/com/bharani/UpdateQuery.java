package com.bharani;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateQuery {
    public static void main(String[] args) throws SQLException {

        String url = "JDBC:mysql://localhost:3306/jdbc";
        String userName = "root";
        String userPassword = "bharani";
        Connection connect = DriverManager.getConnection(
                url ,
                userName ,
                userPassword
        );
        Statement statement = connect.createStatement();

        String query = "update studentInfo set age = 22 where id = 3";

        int effectedRows = statement.executeUpdate(query);
        if (effectedRows == 0) {
            System.out.println("Update is not success");
        }
        else {
            System.out.println("Update is successfully completed");
        }

        statement.close();
        connect.close();
    }
}
