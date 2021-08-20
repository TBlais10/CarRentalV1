package com.company;

public class Menu {

    public void start(){
        System.out.println("Welcome to Taylor's Car Rental Service!");
        new Inventory().initializeCars();
        run();
    }

    public void run(){

        while (new Inventory().getCarsAval().size() != 0){

        System.out.println("This is our current selection of rental cars:");
        for (int i = 0; i < new Inventory().getCarsAval().size(); i++) {
            System.out.println(i + 1 + ")" + new Inventory().getCarsAval());

        }

        }

    }

}
