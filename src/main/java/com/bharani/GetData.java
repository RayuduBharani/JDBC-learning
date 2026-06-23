package com.bharani;

import java.sql.*;

public class GetData {
    public static void  main(String[] args) throws SQLException {

        String url = "JDBC:mysql://localhost:3306/jdbc";
        String name = "root";
        String password = "bharani";
        Connection connect = DriverManager.getConnection(url , name , password);

        Statement statement = connect.createStatement();

//      Getting all the records from the DB
        String query = "select * from studentInfo";
        ResultSet data = statement.executeQuery(query);

        while (data.next()){
            System.out.println(
                    data.getInt("id") + " " +
                    data.getString("name") + " " +
                    data.getInt("age") + " " +
                    data.getString("city") + " "
            );
        }

        statement.close();
        connect.close();
    }
}
