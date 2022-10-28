package com.cars.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CarAdd {
    public static boolean insertCarToDatabase(Car car){
        boolean res=false;
        try {
            Connection connection=ConnectionProvider.createConnection();
            String q= "insert into cars values(?,?,?,?)";
            PreparedStatement pstmt = connection.prepareStatement(q);

            pstmt.setString(1,car.getModelNumber());
            pstmt.setString(2,car.getBrand());
            pstmt.setString(3,car.getColor());
            pstmt.setFloat(4,car.getPrice());

            pstmt.executeUpdate();
            connection.close();
            res=true;

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return res;
    }
}
