package com.cars.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CustomerDetails {
    private String firstName;
    private String lastName;
    private String address;
    private long phoneNumber;

    public CustomerDetails(){}

    public CustomerDetails(String firstName, String lastName, String address, long phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void addCustomerDetails(){
        try {
            Connection connection=ConnectionProvider.createConnection();
            String q= "insert into customer_details (FirstName,LastName,Address,Phone_Number) values(?,?,?,?)";
            PreparedStatement pstmt = connection.prepareStatement(q);

            pstmt.setString(1,this.getFirstName());
            pstmt.setString(2,this.getLastName());
            pstmt.setString(3,this.getAddress());
            pstmt.setLong(4,this.getPhoneNumber());

            pstmt.executeUpdate();
            System.out.println("Information added successfully!!");
            connection.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
