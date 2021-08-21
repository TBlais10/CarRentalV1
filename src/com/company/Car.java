package com.company;

import java.text.NumberFormat;

public class Car {
    private String model;
    private String name;
    private String color;
    private int price;
    private boolean isRented;


    public Car(String model, String name, String color, int price, boolean isRented) {
        this.model = model;
        this.name = name;
        this.color = color;
        this.price = price;
        this.isRented = isRented;
    }

    public String getModel() {
        return model;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    @Override
    public String toString() {

        NumberFormat currency = NumberFormat.getCurrencyInstance();

        String output = "";

        output += model + " " + name /*+ " - Price: " + currency.format(price) + " per day."*/; //commented code for later when working w/ price

        return output;
    }
}
