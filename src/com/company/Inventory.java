package com.company;

import java.util.ArrayList;

public class Inventory {

    private ArrayList<Car> carsAval = new ArrayList<>();

    private ArrayList<Car> rentedCars = new ArrayList<>();

public void initializeCars(){
    Car car1 = new Car("Jeep", "Renegade", "Black", 250, false);
    carsAval.add(car1);

    Car car2 = new Car("Ford", "Mustang", "Red", 400, false);
    carsAval.add(car2);

    Car car3 = new Car("Dodge", "Charger", "Charcoal Grey", 400, false);
    carsAval.add(car3);

    Car car4 = new Car("Chevy", "Cruz", "Yellow", 300, false);
    carsAval.add(car4);

    Car car5 = new Car("VW", "Van Jetta", "Blue", 275, false);
    carsAval.add(car5);
}

    public ArrayList<Car> getCarsAval() {
        return carsAval;
    }

    public ArrayList<Car> getRentedCars() {
        return rentedCars;
    }
}
