package com.company;

public class Math {
    private final Menu menu;

    public Math(Menu menu) {
        this.menu = menu;
    }

    public void rentedTotal(int i) {
        System.out.println(i);
        System.out.println("\n---\nThank you for choosing the " + menu.getArrList().get(i).getDetails() + "! The price per day is " + menu.getArrList().get(i).getPrice() + ". How many days do you wish to rent it?\n---");
        int input = menu.getUserInput().getInt();
        int total = input * menu.getArrList().get(i).getPrice();
        System.out.println("\n---\n For a " + input + " day rental the " + menu.getArrList().get(i).getDetails() + " will cost a total of $" + total + "! Safe Travels!\n---");
        menu.getArrList().get(i).setTotalCost(total);

    } //a quick program that will give the user the total of the rental per days they wish to rent for.
 }