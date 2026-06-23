package com.bharani;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        load the register driver
//        Class.forName("com.mysql.cj.jdbc.Driver");

//        connection
        String url = "JDBC:mysql://localhost:3306/jdbc";
        String username = "root";
        String password = "bharani";
        Connection connect = DriverManager.getConnection(
                url,
                username,
                password
        );
//        Statement Creation
        Statement statement = connect.createStatement();

//        Executing the query
        String query = "insert into studentInfo values(4 , 'Ashok' , 20 , 'Hyderabad')";
        int affectedRows = statement.executeUpdate(query);

        if (affectedRows == 0) {
            System.out.println("Data not inserted");
        }
        else {
            System.out.println("Data is inserted");
        }
//        close the connection
        statement.close();
        connect.close();
    }
}