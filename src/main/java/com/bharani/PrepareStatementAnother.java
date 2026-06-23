package com.bharani;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PrepareStatementAnother {
    public static void main(String[] args) {
        Connection connect = null;
        PreparedStatement statement = null;
        try{
            String url = "JDBC:mysql://localhost:3306/jdbc";
            String name = "root";
            String password = "bharani";
            connect = DriverManager.getConnection(url , name , password);

            String query = "UPDATE studentInfo SET name = ? WHERE id = ?";
            statement = connect.prepareStatement(query);

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter updated value");
            String name1 = sc.nextLine();

            System.out.println("Enter id");
            int id = sc.nextInt();

            statement.setString(1 , name1);
            statement.setInt(2 , id);

            int effected = statement.executeUpdate();
            if (effected == 0) {
                System.out.println("Update is not working");
            }
            else {
                System.out.println("Update success");
            }

        }
        catch (SQLException e) {
            System.out.println("SQL exception");
        }
        catch (Exception e){
            System.out.println("Some err happened");
        }
        finally {
            try{
                statement.close();
                connect.close();
            }
            catch (Exception e){
                System.out.println("Some err happened in Closing connection");
            }
        }
    }
}
