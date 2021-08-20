package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        //System.out.println(new CLI().getInt(1, 10));
    }
}

/*
If  the selection number is not one of the listed numbers (or not a number) the output should be "Car selection invalid,
please try again" AND the prompt should re-appearOnce the car selection is accepted, the selected car should be designate
in the program as being currently rented.
The program should start the cycle again where the list of available cars is shown (the selected car should not appear now).
The prompt for selection should also appear and when that selection is made that should be also designated as rented too

You can continue renting cars...continue the loop


Requirements:
This program should be built in a brand new class called CarRentalService
The class should have a at least one method where the main logic executes
The program should implement AT LEAST three loops.
The car names should be stored in String arrays.
The list of available cars should not output any currently rented cars
The program should cycle until all cars have been rented, at which point you have two choices: end the program, or reset the data.



The following classes and methods will be needed:

To restart the program: have a start() method called that will initialize our menus and reset our methods as if it were being ran for the first time.

* Main class:
* will be calling the run method in the CarRentalService class
*
* CLI class:
* add some fail safe scanners that is careful about what the user puts into the program.
*
* CarRentalService/Menu? Class:
* will contain atleast one method that will be called in the main.
* should contain a submenu method which will ask the user wants to return to the main menu or not.

menu options:
for each (string car : carsAval) ... for(int i = 0...;i++) i
    sout(i + 1 + ")" carsAval[cars].name().model().color())

    0, 1 , 2, 3, 4
    1, 2 ,3 ,4 ,5

    if(user input - 1 == i)
    carAval.remove(i)

    nested for loop that keeps track of number of aval options

    .size for arraylist
    .contains

    restart...method that calls the start.
    store the user input into a variable for it to run the menu again...
    new instance of the menu...
    initialCars = create the cars using inheritance from the car class. initialize in start method and restart method.

    try catch w/ the scanner so if the user puts in a string, it will spit an error message and return to the menu.

*
* Car Class:
* Multiple menus?
* Inheritance?
* Body: Economy? Mid size? compact? sport?
* Price?
* Color
* Name
* Model
* boolean isElectric?
* boolean isStandard? (transmission)
*
* methods?
* getters and setters
* getPrice?
getCar method (Object car)
reference the car inside the arraylist
return car.color() + car.model()
*
* Override toString method?
* display method

do while loop will run as long as there are cars in the arraylist.

*
*
* Inventory class:??
* Listed inside a string array
* ArrayLists?
* A rented cars list?
* any and all information about the cars
* boolean for is or isn't rented
* have two: rented and not rented.
* while loop for checking inventory
* while there is inventory in carsAvailable list, continue to rent a car
* while there is no inventory in carsAvailable list, ask if the user wants to end the program or restart the program.
* recall the main.start() method to restart the entire program.
*
*numbers of cars, which ones are rented, available cars.
boolean isRented
date rented?? (extra)
method that changes the boolean of isRented ... rented()
ArrayList named rented
ArrayList named inInventory

when is empty...start the menu.
* */