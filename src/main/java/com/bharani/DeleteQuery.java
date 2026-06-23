package com.bharani;
import java.sql.*;

public class DeleteQuery {
    public static void main(String[] args) throws SQLException {
        String url = "JDBC:mysql://localhost:3306/jdbc";
        String username = "root";
        String password = "bharani";
        Connection connect = DriverManager.getConnection(
                url,
                username,
                password
        );
        Statement statement = connect.createStatement();
        String query = "delete from studentInfo where id = 4";
        int affectedRows = statement.executeUpdate(query);
        if (affectedRows == 0) {
            System.out.println("Not deleted the data");
        }
        else {
            System.out.println("Deleted successfully");
        }

        statement.close();
        connect.close();
    }
}
