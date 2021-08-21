package com.company;

import java.util.ArrayList;

public class Menu {

    Inventory inv = new Inventory();
    ArrayList<Car> arrList = inv.getCarsAval();
    CLI userInput = new CLI();
    ArrayList<Car> rented = inv.getRentedCars();

    public void start() {
        System.out.println("Welcome to Taylor's Car Rental Service!");
        inv.initializeCars();
        run();
    }

    public void run() {

        while (arrList.size() != 0) {

            System.out.println("\nThis is our current selection of rental cars:");
            for (int i = 0; i < arrList.size(); i++) {
                System.out.println(i + 1 + ") " + arrList.get(i));
            }

            System.out.println("Please choose the car you wish to rent!");
            int selection = userInput.getInt(1, 5);
            userInput.scanner.nextLine();

            for (int i = 0; i < arrList.size(); i++) {
                if (selection - 1 == i) {
                    System.out.println("\n---\nThank you for choosing the " + arrList.get(i) + "! Safe Travels!\n---");
                    rented.add(arrList.get(i));
                    arrList.remove(i);
                    run();
                }

            }

        }

            subMenu();
    }

    private void subMenu() {
        System.out.println("\nThank you for choosing Taylor's Car Rental Service! What would you like to do from this point?");
        System.out.println("1) Restart this program and refresh the lot");
        System.out.println("2) Exit the program");
        int selection = userInput.getInt(1, 2);

        if (selection == 1) {
            System.out.println("\n---\nAlrighty! Restarting the program!\n---");
            start();
        } else {
            System.out.println("\n---\nAlrighty! Exiting the program. Please come again!\n---");


        }

    }

}