package com.cars.manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CreateDatabase {
    public static void createDatabase() {
        try {
            //Registering the Driver
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            //Getting the connection
            String mysqlUrl = "jdbc:mysql://localhost/";
            Connection con = DriverManager.getConnection(mysqlUrl, "root", "Tushar786@");
            Statement stmt = con.createStatement();
            //Query to create a database
            int flag=0;
            ResultSet resultSet = stmt.executeQuery("show databases");
            while (resultSet.next()){
                if(resultSet.getString(1).equals("cars_manage")){
                    System.out.println("The required database already exists");
                    flag=1;
                    break;
                }
            }
            if(flag==0) {
                String query = "CREATE database cars_manage";
                //Executing the query
                stmt.execute(query);
                String query1 = "use cars_manage";
                stmt.execute(query1);
                String query2 = "create table cars(modelNumber varchar(50),brand varchar(50),color varchar(50),price float)";
                stmt.execute(query2);
                String query3 = "create table customer_details(Customerid int not null primary key auto_increment,FirstName varchar(50),LastName varchar(50),Address varchar(100),Phone_Number bigint,Premium varchar(10) default 'NO')";
                stmt.execute(query3);
                String query4 = "create table old_cars(modelNumber varchar(100) not null primary key,brand varchar(100),buying_date date,kms_driven bigint,mob_no bigint,buying_price float)";
                stmt.execute(query4);
                String query5 = "create table signup(id int not null primary key auto_increment,username varchar(100),password varchar(100))";
                stmt.execute(query5);
                System.out.println("Database and its respective table has been created");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
