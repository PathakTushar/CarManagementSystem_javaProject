package com.cars.manage;

import java.sql.*;
import java.util.Scanner;

public class CarDisplay {

    public static void displayCar(){
        try {
            Connection connection=ConnectionProvider.createConnection();
            Statement statement=connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from cars");
            while (resultSet.next())
            {
                System.out.printf("\n\nModel Number : %s\nBrand : %s\nColor : %s\nPrice : %f\n",resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getFloat(4));

            }
            connection.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void searchCars_brand(){
        Scanner in = new Scanner(System.in);
        try {
            Connection connection=ConnectionProvider.createConnection();
            Statement statement=connection.createStatement();
            System.out.println("Enter the brand of the car to be searched");
            String brand = in.nextLine();
            ResultSet resultSet = statement.executeQuery("select * from cars where brand='"+brand+"'");
            while (resultSet.next())
            {
                System.out.printf("\n\nModel Number : %s\nBrand : %s\nColor : %s\nPrice : %f\n",resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getFloat(4));

            }
            connection.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void searchCars_price(){
        Scanner in = new Scanner(System.in);
        try {
            Connection connection=ConnectionProvider.createConnection();
            Statement statement=connection.createStatement();
            System.out.println("Enter the price range");
            float price=in.nextFloat();
            ResultSet resultSet = statement.executeQuery("select * from cars where price <="+price);
            while (resultSet.next())
            {
                System.out.printf("\n\nModel Number : %s\nBrand : %s\nColor : %s\nPrice : %f\n",resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getFloat(4));

            }
            connection.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void searchCars_modelNumber(String modelNumber){
        Scanner in = new Scanner(System.in);
        try {
            Connection connection=ConnectionProvider.createConnection();
            Statement statement=connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from cars where modelNumber ='"+modelNumber+"'");
            while (resultSet.next())
            {
                System.out.printf("\n\nModel Number : %s\nBrand : %s\nColor : %s\nPrice : %f\n",resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getFloat(4));

            }
            connection.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static float getPrice_modelNumber(String modelNumber){
        float price=0;
        Scanner in = new Scanner(System.in);
        try {
            Connection connection=ConnectionProvider.createConnection();
            Statement statement=connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select price from cars where modelNumber ='"+modelNumber+"'");
            while (resultSet.next())
            {
                price=resultSet.getFloat(1);

            }
            connection.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return price;
    }
}
