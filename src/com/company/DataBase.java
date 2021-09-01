package com.company;

import java.util.ArrayList;

public class DataBase {

    private ArrayList<Car> carsAval = new ArrayList<>();

    private ArrayList<Car> rentedCars = new ArrayList<>();

    public ArrayList<User> allUsers = new ArrayList<>();

    public void initializeDataBase() {
        Car car1 = new Car("Jeep Renegade", "Black", 250, false, "",0);
        carsAval.add(car1);

        Car car2 = new Car("Ford Mustang", "Red", 400, false, "",0);
        carsAval.add(car2);

        Car car3 = new Car("Dodge Charger", "Grey", 400, false, "",0);
        carsAval.add(car3);

        Car car4 = new Car("Chevy Cruz", "Yellow", 300, false, "", 0);
        carsAval.add(car4);

        Car car5 = new Car("VW Van Jetta", "Blue", 275, false, "", 0);
        carsAval.add(car5);

        User admin = new User("Admin", "swordfish");
        allUsers.add(admin);
    }

    public void showMenu() {//possibly cutting down on the code needed in other classes.
        System.out.println("\nThis is our current selection of rental cars:");
        for (int i = 0; i < carsAval.size(); i++) {
            System.out.println(i + 1 + ") " + carsAval.get(i).getDetails());
        }
    }

    public void showRentedMenu() {
        System.out.println("Welcome back! Which car would you like to return?");
        for (int i = 0; i < rentedCars.size(); i++){
            System.out.println(i + 1 + ") " +
                    "" + rentedCars.get(i).getDetails());
        }
    }

    public ArrayList<Car> getCarsAval() {
        return carsAval;
    }

    public ArrayList<Car> getRentedCars() {
        return rentedCars;
    }

    public ArrayList<User> getAllUsers() {
        return allUsers;
    }
}
