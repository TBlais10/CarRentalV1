package com.company;

import java.util.ArrayList;

public class Math {

    Inventory inv = new Inventory();
    ArrayList<Car> arrList = inv.getCarsAval();
    CLI userInput = new CLI();

    public void rentedTotal(int i){
        System.out.println("\n---\nThank you for choosing the " + arrList.get(i) + "! The price per day is " + arrList.get(i).getPrice() + ". How many days do you wish to rent it?\n---");
        int input = userInput.getInt();
        int total = input * arrList.get(i).getPrice();
        System.out.println("\n---\n For a " + input + " day rental the " + arrList.get(i) + "will cost a total of "  + total + "! Safe Travels!\n---");

    }


}
