package com.company;

import java.util.ArrayList;

public class Menu {

    Inventory inv = new Inventory(); //To only initialize an instance of Inventory once.
    ArrayList<Car> arrList = inv.getCarsAval();
    CLI userInput = new CLI(); //To only initialize an instance of CLI once.
    ArrayList<Car> rented = inv.getRentedCars();

    public void start() {//Introduces the program and populates carsAval arraylist.
        System.out.println("Welcome to Taylor's Car Rental Service!");
        inv.initializeCars();
        run();
    }

    public void run() {//The main menu of the program.
        System.out.println("\n---\nWe have a total of " + arrList.size() + " cars available for rent and we have " + rented.size() + " cars currently being rented.");
        System.out.println("\nChoose from the following menu options:");
        System.out.println("1) Rent a car");
        System.out.println("2) Return a car");
        System.out.println("3) Exit the program");

        int input = userInput.getInt(1, 3);

        if (input == 1){
            renting();
        }
        else if (input == 2){
            returnCar();
        }else {
            new CLI().exit();
        }
    }

    public void renting() {

        while (arrList.size() != 0) {

            System.out.println("\nThis is our current selection of rental cars:");
            for (int i = 0; i < arrList.size(); i++) { //Loops thru the carsAval to take advantage of creating the list of cars and will change as the arraylist changes.
                System.out.println(i + 1 + ") " + arrList.get(i));
            }

            System.out.println("Please choose the car you wish to rent!");
            int selection = userInput.getInt(1, arrList.size());

            for (int i = 0; i < arrList.size(); i++) {
                if (selection - 1 == i) {
                    //System.out.println("\n---\nThank you for choosing the " + arrList.get(i) + "! Safe Travels!\n---");
                    rentedTotal(i); //For asking customer how long they wish to rent the car for and what the total cost will be.
                    rented.add(arrList.get(i));
                    arrList.remove(i);
                    subMenu();
                }
            }
        }
    }

    private void returnCar() {
        while (rented.size() != 0){
            System.out.println("Welcome back! Which car would you like to return?");
            for (int i = 0; i < rented.size(); i++){
                System.out.println(i + 1 + ")" + rented.get(i));
            }

            System.out.print("\nInput:");
            int selection = userInput.getInt(1, rented.size());

            for (int i = 0; i < rented.size(); i++){
                if (selection - 1 == i){
                    System.out.println("\n---\nAlrighty! Thank you for returning the " + rented.get(i) + "! We hope to see you again.\n---");
                    arrList.add(rented.get(i));
                    rented.remove(i);
                    subMenu();
                }
            }
        }
        //System.out.println("\nWelcome back loyal customer! Help us to find you in our system! What is your name?");
        //Ask to check thru the User class' arraylists and check for the user.
        //if they find a matching name, ask to confirm if that is their account.
        //confirm which car they wish to return. Use a for loop to go thru the list of cars, then on a yes add that car back to the carsAval list.

    }

    private void subMenu() {
        subMenuDialogue();
        int selection = userInput.getInt(1, 5);
        userSelection(selection);
    }

    private void subMenuDialogue() {
        System.out.println("\nThank you for choosing Taylor's Car Rental Service! What would you like to do from this point?");
        System.out.println("1) Restart this program and refresh the lot");
        System.out.println("2) Return to the main menu.");
        System.out.println("3) Go to the rental menu to rent a car.");
        System.out.println("4) Go to the return menu to return a car.");
        System.out.println("5) Exit the program");
    }

    private void userSelection(int selection) {
        if (selection == 1) {
            System.out.println("\n---\nAlrighty! Restarting the program!\n---");
            arrList.clear();
            rented.clear();
            start();
        }else if(selection == 2){
            System.out.println("\n---\nAlrighty! Returning to the main menu.\n---");
            run();
        }
        else if (selection == 3){System.out.println("\n---\nAlrighty! Sending you to the rental menu.\n---");
            renting();
        }
        else if (selection == 4){System.out.println("\n---\nAlrighty! Sending you to the return menu.\n---");
            returnCar();
        }else {
            new CLI().exit();
        }
    } //the if else blocks for the sub menu options.

    private void rentedTotal(int i){
        System.out.println(i);
        System.out.println("\n---\nThank you for choosing the " + arrList.get(i) + "! The price per day is " + arrList.get(i).getPrice() + ". How many days do you wish to rent it?\n---");
        int input = userInput.getInt();
        int total = input * arrList.get(i).getPrice();
        System.out.println("\n---\n For a " + input + " day rental the " + arrList.get(i) + " will cost a total of "  + total + "! Safe Travels!\n---");

    } //a quick program that will give the user the total of the rental per days they wish to rent for.
}