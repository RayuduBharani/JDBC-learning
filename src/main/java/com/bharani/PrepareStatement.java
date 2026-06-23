package com.bharani;

import java.sql.*;
import java.util.Scanner;

public class PrepareStatement {
    public static void main(String[] args){
        Connection connect = null;
        PreparedStatement prepareStatement = null;
        try{
            String url = "JDBC:mysql://localhost:3306/jdbc";
            String name = "root";
            String password = "bharani";
            connect = DriverManager.getConnection(url , name , password);

            String query = "insert into studentInfo values(? , ? , ? , ?)";
            prepareStatement = connect.prepareStatement(query);
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter id");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter name");
            String name1 = sc.nextLine();

            System.out.println("Enter age");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter city");
            String city = sc.nextLine();

            prepareStatement.setInt(1 , id);
            prepareStatement.setString(2 , name1);
            prepareStatement.setInt(3 , age);
            prepareStatement.setString(4 , city);

            int rows = prepareStatement.executeUpdate();
            if (rows == 0) {
                System.out.println("Not inserted anything");
            }
            else {
                System.out.println("Insertion Success");
            }
        }
        catch (SQLException e) {
            System.out.println("Sql Exception err");
        }
        catch (Exception e) {
            System.out.println("Some err happened");
        }
        finally {
            try {
                prepareStatement.close();
                connect.close();
            }
            catch (Exception e){
                System.out.println("Error happened in closing");
            }
        }
    }
}