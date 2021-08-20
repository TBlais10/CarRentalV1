package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CLI {

    Scanner scanner = new Scanner(System.in);

    public int getInt(int min, int max) {
        try {
            //String[] blarg = {}; //This is a test for error messages
            System.out.print("Input: ");
            int input = scanner.nextInt();
            //String asdf = blarg[1]; //This is a test for error messages
            if (input > max || input < min) {
                System.out.println("Input is out of range! Please try again.");
                return getInt(min, max);
            }

            return input;
        }catch (InputMismatchException exception){//testing for data types outside of int
            System.out.println("Incorrect input! Please provide a number and try again.");
            scanner.nextLine();
            return getInt(min, max);
        } catch (Exception exception) {//testing for unknown errors
            System.out.println("An unknown error appeared.");
            scanner.nextLine();
            return getInt(min, max);
        }
    }

    public String getString(String input) {
        if(input == " ") System.out.println("Your input cannot be empty! Please try again.");

        return input;
    }

}
