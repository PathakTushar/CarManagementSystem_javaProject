import com.cars.manage.*;

import java.util.Scanner;

public class LandingPage {
    public static void main(String[] args) {
        int choice;
        Scanner in = new Scanner(System.in);
        boolean login_flag=false;
        boolean hasTakenPremium=false;
        int login_id=0;
//        System.out.println("Press 1 to create the database and its respective tables else any other value if the database is already created");
//        int database_choice=in.nextInt();
        while (true)
        {
            System.out.printf("\n<----------------------------------------CHOICES--------------------------------------->\n");
            if (!login_flag)
                System.out.println("press 1 for login/signup");
            else
                System.out.println("press 1 for logout");
            System.out.println("press 2 for searching cars");
            System.out.println("press 3 for taking premium");
            System.out.println("press 4 for buying cars");
            System.out.println("press 5 for selling cars");
            System.out.println("press 6 for knowing offers");
            System.out.println("press 0 for exit");
            System.out.printf("<-------------------------------------------------------------------------------------->\n");
            System.out.println("Enter your choice");
            choice=in.nextInt();
            if (choice==1&&login_flag){
                login_flag=false;
                hasTakenPremium=false;
                System.out.println("Logged out successfully!!");
            }
            else if(choice==1){
                System.out.println("press a for admin and u for user");
                char ch=in.next().charAt(0);
                if(ch=='u'){
                    System.out.println("press l for login and s for signup");
                    char logChoice=in.next().charAt(0);
                    in.nextLine();
                    if(logChoice=='l')
                    {
                        System.out.println("enter the username");
                        String username=in.nextLine();
                        System.out.println("enter the password");
                        String password=in.nextLine();

                        boolean res=Login.login(username,password);
                        if(res){
                            System.out.println("Logged In successfully!!");
                            login_flag=true;
                            login_id=Login.getId(username);
                            hasTakenPremium=Premium.checkPremium(login_id);
                        }
                        else {
                            System.out.println("Sorry, Please try once again");
                        }
                    }
                    if (logChoice=='s')
                    {
                        String username;
                        while (true)
                        {
                            System.out.println("enter the username");
                            username=in.nextLine();
                            boolean res=CheckAlreadyExist.exists(username);
                            if(res){
                                System.out.println("This username is already taken!! ,try some other username");
                            }
                            else break;
                        }
                        System.out.println("enter the password");
                        String password=in.nextLine();
                        Signup signup = new Signup(username,password);
                        signup.signup();
                        System.out.println("Enter your firstName");
                        String firstName=in.nextLine();
                        System.out.println("Enter your lastName");
                        String lastName=in.nextLine();
                        System.out.println("Enter your address");
                        String address=in.nextLine();
                        System.out.println("Enter your phone number");
                        long phoneNumber=in.nextLong();
                        CustomerDetails addingEntry=new CustomerDetails(firstName,lastName,address,phoneNumber);
                        addingEntry.addCustomerDetails();

                    }
                }
                if (ch=='a'){
                    int admin_login_flag=0;
                    in.nextLine();
                    System.out.println("welcome to login page");
                    System.out.println("enter the username");
                    String username=in.nextLine();
                    System.out.println("enter the password");
                    String password=in.nextLine();
                    if(username.equals("admin")&&password.equals("admin@123")){
                        System.out.println("Logged In Successfully!!");
                        admin_login_flag=1;
                    }
                    else {
                        System.out.println("Sorry, wrong username or password!!");
                    }
                    if(admin_login_flag==1)
                    {
                        AdminFunctionality.functionality();
                    }

                }
            }
            else if (choice==2) {
                if(login_flag){
                    System.out.println("Press 1 if you want to search on the brand, 2 if you want to search on the price range and 3 if you want to view all the available cars");
                    int search_choice=in.nextInt();
                    if(search_choice==1)    CarDisplay.searchCars_brand();
                    else if (search_choice==2) {
                        CarDisplay.searchCars_price();
                    } else if (search_choice==3) {
                        CarDisplay.displayCar();
                    }
                    else System.out.println("please choose the options correctly!!");
                }
                else {
                    System.out.println("please login first!!");
                }
            }
            else if (choice==3) {
                if(hasTakenPremium){
                    System.out.println("you have already taken premium");
                }
                else if(login_flag){
                    System.out.println("You will have to pay an amount of rs 1000 for taking premium");
                    System.out.println("Press y for yes and n for no");
                    char ch=in.next().charAt(0);
                    if(ch=='y'){
                        Premium.takePremium(login_id);
                        hasTakenPremium=true;
                    }
                    if (ch=='n') System.out.println("you are missing many benefits of our application, please take the premium");
                }
                else {
                    System.out.println("please login first!!");
                }

            }
            else if (choice==4) {
                if(login_flag){
                    System.out.println("Press 1 if you want to see all the available cars for buying or press 2 if you want to search for a particular brand");
                    int buy_choice=in.nextInt();
                    if (buy_choice==1){
                        CarDisplay.displayCar();
                    }
                    else if (buy_choice==2){
                        CarDisplay.searchCars_brand();
                    }
                    else System.out.println("Oops!! you opted some wrong option");
                    System.out.println("Do you like any of our cars? Press y for yes and n for no");
                    char ch=in.next().charAt(0);
                    in.nextLine();
                    if(ch=='y'){
                        System.out.println("Enter the model number of the car you liked");
                        String model_number=in.nextLine();
                        System.out.println("so you liked the car whose details are as follows : ");
                        CarDisplay.searchCars_modelNumber(model_number);
                        String message;
                        float updated_price;
                        float price=CarDisplay.getPrice_modelNumber(model_number);
                        if(hasTakenPremium){
                            message="since you are our premium member so you will get a discount of 2%, and you have to pay a total of rs ";
                            updated_price=price-price*2/100;
                        }
                        else {
                            message="you have to pay a total of rs ";
                            updated_price=price;
                        }
                        System.out.println(message+updated_price);
                    }
                    else System.out.println("sorry for the inconvenience");
                }
                else {
                    System.out.println("please login first!!");
                }
            }
            else if (choice==5) {
                if(login_flag){
                    if (hasTakenPremium){
                        in.nextLine();
                        System.out.println("Enter the model number of the car to be sold");
                        String modelNumber=in.nextLine();
                        System.out.println("Enter the brand of the car to be sold");
                        String brand=in.nextLine();
                        System.out.println("Enter the buying date of the car to be sold in the format of yyyy-mm-dd");
                        String date=in.nextLine();
                        System.out.println("Enter the kms driven of the car to be sold");
                        long kmsDriven=in.nextLong();
                        System.out.println("Enter the mobile number");
                        long mobNo=in.nextLong();
                        System.out.println("Enter the price at which the car was bought");
                        float buying_price=in.nextFloat();

                        System.out.println("we will reduce the price of the car per thousand kms driven by 1% from the original buying price");
                        long percentReduced=kmsDriven/1000;
                        float selling_price=buying_price-(buying_price*(percentReduced+1)/100);
                        System.out.println("your car price is estimated as rs "+selling_price);
                        System.out.println("Do you want to sell it? Press y for yes and n for no");
                        char sellingChoice=in.next().charAt(0);
                        if(sellingChoice=='y'){
                            SellingCars sellingCars=new SellingCars(modelNumber,brand,date,kmsDriven,mobNo,buying_price);
                            sellingCars.addingOldCars();
                        }

                    }
                    else System.out.println("sorry you have to take the premium first to sell your cars");
                }
                else {
                    System.out.println("please login first!!");
                }
            }

            else if (choice==6) {
                System.out.println("there are many offers such as blah blah blah....................");
            }
            else if (choice==0) {
                break;
            }
            else {
                System.out.println("wrong input!!");
            }

        }
    }
}
