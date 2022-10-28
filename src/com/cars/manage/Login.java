package com.cars.manage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login {
    public static boolean login(String userName,String password)
    {
        boolean res=false;
        try {
            Connection connection=ConnectionProvider.createConnection();
            Statement statement=connection.createStatement();
            String query="select password from signup where username='"+userName+"'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                if (resultSet.getString(1).equals(password)) {
                    res = true;
                }
            }
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return res;
    }
    public static int getId(String userName)
    {
        int res=-1;
        try {
            Connection connection=ConnectionProvider.createConnection();
            Statement statement=connection.createStatement();
            String query="select id from signup where username='"+userName+"'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                res=resultSet.getInt(1);
            }
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return res;
    }
}
