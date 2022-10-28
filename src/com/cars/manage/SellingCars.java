package com.cars.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class SellingCars {
    private String modelNumber,brand,date;
    private long kmsDriven,mobNo;
    private float buying_price;

    public SellingCars(){}

    public SellingCars(String modelNumber, String brand, String date, long kmsDriven, long mobNo, float buying_price) {
        this.modelNumber = modelNumber;
        this.brand = brand;
        this.date = date;
        this.kmsDriven = kmsDriven;
        this.mobNo = mobNo;
        this.buying_price = buying_price;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getKmsDriven() {
        return kmsDriven;
    }

    public void setKmsDriven(long kmsDriven) {
        this.kmsDriven = kmsDriven;
    }

    public long getMobNo() {
        return mobNo;
    }

    public void setMobNo(long mobNo) {
        this.mobNo = mobNo;
    }

    public float getBuying_price() {
        return buying_price;
    }

    public void setBuying_price(float buying_price) {
        this.buying_price = buying_price;
    }

    public void addingOldCars()
    {
        try {
            Connection connection=ConnectionProvider.createConnection();
            String q= "insert into old_cars values(?,?,?,?,?,?)";
            PreparedStatement pstmt = connection.prepareStatement(q);

            pstmt.setString(1,this.getModelNumber());
            pstmt.setString(2,this.getBrand());
            pstmt.setString(3,this.getDate());
            pstmt.setLong(4,this.getKmsDriven());
            pstmt.setLong(5,this.getMobNo());
            pstmt.setFloat(6,this.getBuying_price());

            pstmt.executeUpdate();
            System.out.println("your car is sold successfully!!");
            connection.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
