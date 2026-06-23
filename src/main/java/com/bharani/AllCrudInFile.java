package com.bharani;

import java.sql.*;

public class AllCrudInFile {
    public static  void main(String[] args) throws SQLException {
        String url = "JDBC:mysql://localhost:3306/jdbc";
        String name = "root";
        String password = "bharani";
        Connection connect = DriverManager.getConnection(url , name , password);

        Statement statement =connect.createStatement();

        String query = "insert into studentInfo values(6 , 'Santosh' , 20 , 'Hyderabad')";
        boolean status = statement.execute(query);
        if (status){
            // only get operation
            ResultSet data = statement.getResultSet();
            while (data.next()){
                System.out.println(
                        data.getInt("id") + " "
                                + data.getString("name")
                                + " " + data.getInt("age")
                                + " " + data.getString("city")
                                + " "
                        );
            }
        }
        else {
            // insert , delete , update
            int affectedRows = statement.getUpdateCount();
            if (affectedRows == 0) {
                System.out.println("Operation failed");
            }
            else {
                System.out.println("Operation successful");
            }
        }


        statement.close();
        connect.close();
    }
}
