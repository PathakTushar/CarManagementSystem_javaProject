package com.cars.manage;

import java.util.Scanner;

public class AdminFunctionality {
    public static void functionality(){
        Scanner in= new Scanner(System.in);
        int choice;
        while (true)
        {
            System.out.printf("\n<----------------------------------ADMIN FUNCTIONALITY--------------------------------->\n");
            System.out.println("press 1 for adding");
            System.out.println("press 2 for deletion");
            System.out.println("press 3 for displaying cars");
            System.out.println("press 4 for searching cars");
            System.out.println("press 5 for displaying customers");
            System.out.println("press 6 for searching customers");
            System.out.println("press 0 for logout");
            System.out.printf("<---------------------------------------------------------------------------------------->\n");
            System.out.println("Enter your choice");

            choice=in.nextInt();
            if(choice==1)
            {
                in.nextLine();
                System.out.println("Enter the model number of car");
                String modelNumber = in.nextLine();
                System.out.println("Enter the brand of car");
                String brand = in.nextLine();
                System.out.println("Enter the color of car");
                String color = in.nextLine();
                System.out.println("Enter the price of car");
                float price = in.nextFloat();

                Car car=new Car(modelNumber,brand,color,price);
                boolean res = CarAdd.insertCarToDatabase(car);
                if(res)
                {
                    System.out.println("\ncar is successfully added in the list");
                }
                else {
                    System.out.println("\nsomething went wrong please try again");
                }


            }

            else if (choice==2)
            {
                in.nextLine();
                System.out.println("Enter the model number of the car to be deleted");
                String modelNumber=in.nextLine();
                boolean res= CarDeletion.deleteCar(modelNumber);
                if(res)
                {
                    System.out.println("\ncar is successfully deleted from the list");
                }
                else {
                    System.out.println("\nsomething went wrong please try again");
                }
            }
            else if (choice==3) {

                CarDisplay.displayCar();
            }
            else if (choice==4) {
                CarDisplay.searchCars_brand();
            }
            else if (choice==5) {
                CustomerDisplay.displayCustomer();
            }
            else if(choice==6){
                CustomerDisplay.searchCustomer();
            }
            else if (choice==0) {
                break;
            }
            else {
                System.out.println("invalid input choice");
            }
        }
    }
}
