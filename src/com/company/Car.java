package com.company;

public class Car {
    private final String name;
    private final String color;
    private final int price;
    private boolean rented;
    private String renterName = "";
    private int totalCost;


    public Car(String name, String color, int price, boolean rented, String renterName, int totalCost) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.rented = rented;
        this.renterName = renterName;
        this.totalCost = totalCost;
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

    public String getDetails(){
        return name;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    public String getRenterName() {
        return renterName;
    }

    public void setRenterName(String renterName) {
        this.renterName = renterName;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

}
