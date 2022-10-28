package com.cars.manage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class CustomerDisplay {
    public static void displayCustomer(){
        try {
            Connection connection=ConnectionProvider.createConnection();
            Statement statement=connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from customer_details");
            while (resultSet.next())
            {
                System.out.printf("\n\nCustomer ID : %d\nFirst Name : %s\nLast Name : %s\nAddress : %s\nPhone Number : %d\nPremium taken : %s\n",resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getLong(5),resultSet.getString(6));

            }
            connection.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void searchCustomer(){
        Scanner in = new Scanner(System.in);
        try {
            Connection connection=ConnectionProvider.createConnection();
            Statement statement=connection.createStatement();
            System.out.println("Enter the id of the customer to be searched");
            int id=in.nextInt();
            ResultSet resultSet = statement.executeQuery("select * from customer_details where Customerid='"+id+"'");
            while (resultSet.next())
            {
//                System.out.printf("\n\nFirst Name : %s\nLast Name : %s\nAddress : %s\nPhone Number : %d\n",resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getLong(4));
                System.out.printf("\n\nCustomer ID : %d\nFirst Name : %s\nLast Name : %s\nAddress : %s\nPhone Number : %d\nPremium taken : %s\n",resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getLong(5),resultSet.getString(6));
            }
            connection.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
