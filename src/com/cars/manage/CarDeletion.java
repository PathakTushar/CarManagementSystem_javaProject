package com.cars.manage;

import java.sql.*;

public class CarDeletion {

    public static boolean deleteCar(String modelNumber){
        boolean res=false;
        try {
            Connection connection=ConnectionProvider.createConnection();
            Statement statement=connection.createStatement();
            String query="delete from cars where modelNumber='"+modelNumber+"'";
            statement.executeUpdate(query);

            res=true;
            connection.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return res;
    }
}
