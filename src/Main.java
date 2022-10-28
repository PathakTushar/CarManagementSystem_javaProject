import com.cars.manage.Car;
import com.cars.manage.CarAdd;
import com.cars.manage.CarDeletion;
import com.cars.manage.CarDisplay;

import java.util.*;
public class Main {
    public static void main(String[] args) {

        Scanner in=new Scanner(System.in);
//        System.out.println("press 1 if you are an admin");
//        System.out.println("press 2 if you are an user");
//        int choicePerson=in.nextInt();
//        in.nextLine();
//        String userName,password;
//        if(choicePerson==1)
//        {
//            System.out.println("Enter the username for login");
//            userName=in.nextLine();
//            if (userName.equals("admin"))
//            {
//                System.out.println("Enter the password");
//                password=in.nextLine();
//                if (password.equals("admin123"))
//                {
//                    System.out.println("Logged in successfully!!");
//                }
//                else {
//                    System.out.println("Oops!! wrong password");
//                }
//            }
//            else {
//                System.out.println("Sorry invalid username");
//            }
//        }
//        if (choicePerson==2)
//        {
//            System.out.println("Press 1 for sign up");
//            System.out.println("Press 2 for log in");
//            int logChoice=in.nextInt();
//            if(logChoice==1)
//            {
//                System.out.println("Enter the username");
//            }
//        }

        int choice;
        while (true)
        {
            System.out.printf("\n<----------------------------------------CHOICES--------------------------------------->\n");
            System.out.println("press 1 for adding");
            System.out.println("press 2 for deletion");
            System.out.println("press 3 for display");
            System.out.println("press 0 for exit");
            System.out.printf("<-------------------------------------------------------------------------------------->\n");
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
            else if (choice==0) {
                break;
            }
            else {
                System.out.println("wrong input");
            }
        }
        System.out.println("Thank you for using our app");
    }
}
