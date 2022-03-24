package com.company;

import java.util.ArrayList;

public class Menu {

    DataBase data = new DataBase(); //To only initialize an instance of Inventory once.
    ArrayList<Car> arrList = data.getCarsAval();
    ArrayList<Car> rented = data.getRentedCars();
    ArrayList<User> users = data.allUsers;
    CLI userInput = new CLI(); //To only initialize an instance of CLI once.

    public void start() {//Introduces the program and populates carsAval arraylist.
        System.out.println("Welcome to Taylor's Car Rental Service!");
        data.initializeDataBase();
        loginMenu();
    } //Starts w/ an account check

    private void loginMenu() {
        System.out.println("Do you have an account with us? Y/N");
        System.out.println("Or would you like to exit the program? If so, type 'exit'.");
        String input = userInput.getString();
        loginMenuCheck(input);
    } //Split from start so start prompt does not always need to be accessed for logging in.

    private void loginMenuCheck(String input) {
        if (input.substring(0, 1).equalsIgnoreCase("Y")) {
            System.out.println("\n---\nWhat is your username and password?\n---");
            System.out.print("Username ");
            String username = userInput.getString();

            System.out.print("Password ");
            String password = userInput.getString();

            //System.out.println(data.allUsers.size() + " - Calling data.allUsers");
            //System.out.println(users.size() + " - Calling users");
            for (User user : users) {
                //System.out.println(user.getUsername() + "-" + user.getPassword() + "-" + username + "-" + password);

                if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                    System.out.println("\n---\nWelcome back " + username + "\n---");
                    run();
                }
            }
            System.out.println("The username or password is incorrect. Would you like to try again? Y/N");
            String answer = userInput.getString();
            if (answer.substring(0, 1).equalsIgnoreCase("y")) {
                loginMenuCheck(input);//method call for login
            } else {
                loginMenu();
            }

        } else if (input.substring(0, 1).equalsIgnoreCase("N")) {
            //createUser method
            createNewUser();
        } else if (input.substring(0, 1).equalsIgnoreCase("E")) {
            userInput.exit();
        } else {
            System.out.println("Incorrect input! Please try again.");
            loginMenu();
        }
    } //Contains login and method to create a new user....move to a new class.

    private void createNewUser() {
        System.out.println("\n---\nOk! Lets create a new user for you!");

        System.out.println("Create your username!");
        String username = userInput.getString();

        System.out.println("Now your password! Should contain a minimum of 8 characters and no more than 20 characters.");
        String password = userInput.getString(8, 20);

        User newUser = new User(username, password); //issue coming up here - nullpointexception
        data.allUsers.add(newUser); //add to Arraylist <-- issue is here...is the data not being added to the arraylist? I think so
        System.out.println(users.get(1).getUsername()); //tests to make sure the new data was added to arraylist
        System.out.println(users.get(1).getPassword()); //tests to make sure the new data was added to arraylist

        System.out.println("\n---\nWelcome " + username + "! Thank you for creating an account with us! Please log in to use our program.\n---");
        loginMenu();
    } //creates a new user...move to CLI class?

    public void run() {//The main menu of the program.
        System.out.println("\n---\nWe have a total of " + arrList.size() + " cars available for rent and we have " + rented.size() + " cars currently being rented.");
        System.out.println("\nChoose from the following menu options:");
        System.out.println("1) Rent a car");
        System.out.println("2) Return a car");
        System.out.println("3) Log out");
        System.out.println("4) Exit the program");

        int input = userInput.getInt(1, 4);

        if (input == 1) {
            renting();
        } else if (input == 2) {
            returnCar();
        } else if (input == 3) {
            System.out.println("\n---\nLogging out! Please come again\n---");
            loginMenu();
        } else {
            new CLI().exit();
        }
    } //runs the main menu of the program.

    public void renting() {

        while (arrList.size() != 0) {
            data.showMenu();  //Loops thru the carsAval to take advantage of creating the list of cars and will change as the arraylist changes. Seen in Inventory Class

            System.out.println("Please choose the car you wish to rent!");
            int selection = userInput.getInt(1, arrList.size());

            confirmRental(selection);
        }
    } //The main cor rental menu

    private void returnCar() {
        if (rented.size() == 0) {
            System.out.println("\n---\nWe have no cars out for rent! Returning to main menu...\n---2" +
                    "");
            run();
        }

        while (rented.size() != 0) {
            data.showRentedMenu(); //Loops thru the rentedCars to take advantage of creating the list of cars and will change as the arraylist changes. Seen in Inventory Class
            System.out.print("\nInput:");
            int selection = userInput.getInt(1, rented.size());

            confirmReturn(selection);
        }
        //System.out.println("\nWelcome back loyal customer! Help us to find you in our system! What is your name?");
        //Ask to check thru the User class' arraylists and check for the user.
        //if they find a matching name, ask to confirm if that is their account.
        //confirm which car they wish to return. Use a for loop to go thru the list of cars, then on a yes add that car back to the carsAval list.

    } //The main return car menu

    private void confirmRental(int selection) {
        for (int i = 0; i < arrList.size(); i++) {
            if (selection - 1 == i) {
                System.out.println("\n---\nDo you want to rent the " + arrList.get(i).getDetails() + "? Y/N?\n---"); //To confirm w/ the user that this is the car they wanted.
                userInput.scanner.nextLine();
                String input = userInput.getString(1, 3);
                String trimmedInput = input.substring(0, 1).toUpperCase();
                checkingUserRentalInput(i, trimmedInput);

            }
        }
    } //Checks w/ user if they wish to stick w/ the rental option they choose.

    private void checkingUserRentalInput(int i, String trimmedInput) {
        if (trimmedInput.equals("Y")) {
            System.out.println("Alrighty! You have confirmed the rental of the " + arrList.get(i).getDetails() + "! What name will the rental be listed under?");
            String name = userInput.getString();//Adds the user name to the object before changing arrays
            arrList.get(i).setRenterName(name);
            arrList.get(i).setRented(true); //Sets boolean to true
            rentedTotal(i); //For asking customer how long they wish to rent the car for and what the total cost will be.
            rented.add(arrList.get(i));
            arrList.remove(i);
            subMenu();
        } else if (trimmedInput.equals("N")) {
            System.out.println("\n---\nOK! What would you like to do from here?\n1) Return to the rental menu\n2) Return to the main menu \n---");
            int input = userInput.getInt(1, 2);
            userRentalRetry(input);
        }
    } //Checking the user input given from confirmRental

    private void userRentalRetry(int input) {
        if (input == 1) {
            System.out.println("\n...returning to rented menu");
            renting();
        } else {
            System.out.println("\n---\nAlrighty! Returning to main menu.\n---");
            run();
        }
    } //If the user does not want to rent the car in question, asks if they want to return to rental or main menu.

    private void confirmReturn(int selection) { //
        for (int i = 0; i < rented.size(); i++) {
            if (selection - 1 == i) {
                System.out.println("\n---\nAlrighty! You want to return the " + rented.get(i).getDetails() + "! What was the name under that rental?\n---");
                userInput.scanner.nextLine();

                String name = userInput.getString();
                checkingUserReturnInput(selection, i, name);

            }

        }
    } //Checks w/ user if they wish to stick w/ the rental option the choose.

    private void checkingUserReturnInput(int selection, int i, String name) {
        if (name.equals(rented.get(i).getRenterName())) {
            System.out.println("\n---\nThank you " + rented.get(i).getRenterName() + "! Your total rental costs comes to $" + rented.get(i).getTotalCost() + ". We hope you have a great day!\n---");
            rented.get(i).setRenterName("");
            rented.get(i).setRented(false);
            rented.get(i).setTotalCost(0);
            arrList.add(rented.get(i));
            rented.remove(i);
            subMenu();
        } else {
            System.out.println("Oops! That name does not match our records. Do you want to...\n1)Try again\n2)Return to the rented menu?");
            int input = userInput.getInt(1, 2);
            userReturnRetry(selection, input);
        }
    } //Checking the user input from confirmReturn

    private void userReturnRetry(int selection, int input) {
        if (input == 1) {
            System.out.println("\n...returning to prompt...");
            confirmReturn(selection);
        } else {
            System.out.println("\n---\nAlrighty! Returning to return menu.\n---");
            returnCar();
        }
    } //The options for the retry options in else statement of checkingUserReturnInput

    private void subMenu() {
        subMenuDialogue();
        int selection = userInput.getInt(1, 5);
        userSelection(selection);
    } //Once the user is done w/ a menu option, will appear and ask them if there is another part of the program they wish to work inside.

    private void subMenuDialogue() {
        System.out.println("\nThank you for choosing Taylor's Car Rental Service! What would you like to do from this point?");
        System.out.println("1) Restart this program and refresh the lot");
        System.out.println("2) Return to the main menu.");
        System.out.println("3) Go to the rental menu to rent a car.");
        System.out.println("4) Go to the return menu to return a car.");
        System.out.println("5) Exit the program");
    } //The menu options for the sub menu

    private void userSelection(int selection) {
        if (selection == 1) {
            System.out.println("\n---\nAlrighty! Restarting the program!\n---");
            arrList.clear();
            rented.clear();
            start();
        } else if (selection == 2) {
            System.out.println("\n---\nAlrighty! Returning to the main menu.\n---");
            run();
        } else if (selection == 3) {
            System.out.println("\n---\nAlrighty! Sending you to the rental menu.\n---");
            renting();
        } else if (selection == 4) {
            System.out.println("\n---\nAlrighty! Sending you to the return menu.\n---");
            returnCar();
        } else {
            new CLI().exit();
        }
    } //the if else blocks for the sub menu options.

    private void rentedTotal(int i) {
        System.out.println(i);
        System.out.println("\n---\nThank you for choosing the " + arrList.get(i).getDetails() + "! The price per day is " + arrList.get(i).getPrice() + ". How many days do you wish to rent it?\n---");
        int input = userInput.getInt(1, 30);
        int total = input * arrList.get(i).getPrice();
        System.out.println("\n---\n For a " + input + " day rental the " + arrList.get(i).getDetails() + " will cost a total of $" + total + "! Safe Travels!\n---");
        arrList.get(i).setTotalCost(total);

    } //a quick program that will give the user the total of the rental per days they wish to rent for.
}