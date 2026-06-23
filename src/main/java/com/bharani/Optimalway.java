package com.bharani;

import java.sql.*;

public class Optimalway {
    public static void main(String[] args) {
        String url = "JDBC:mysql://localhost:3306/jdbc";
        String name = "root";
        String password = "bharani";
        Connection connect = null;
        Statement statement = null;
        try {
            connect = DriverManager.getConnection(url, name, password);
            statement = connect.createStatement();

            String query = "select * from studentInfo";
            ResultSet data = statement.executeQuery(query);

            while (data.next()) {
                System.out.println(data.getInt("id") + " " + data.getString("name") + " " + data.getInt("age") + " " + data.getString("city") + " ");
            }


        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        catch (Exception e) {
            System.out.println("Some err happened");
        }
        finally {
            try {
                statement.close();
                connect.close();
            }
            catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
