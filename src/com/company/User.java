package com.company;

import java.util.ArrayList;

//To have accounts of customers and the cars they have renting/rented stored here.
public class User {


    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    private String userString = new CLI().getString();
//    private int userInt = new CLI().getInt();

 ///   ArrayList<User> users = new ArrayList<>();

//    public void newUser(){//create an arraylist from given user data from a new user.
//        //will need scanners in from CLI
//        //new arraylist w/ the defining name of what the user gives.
//
//        System.out.println("Welcome new user! What is your first name?");
//        String firstName = userString;
//
//        System.out.println("Great! Your last name?");
//        String lastName = userString;
//
//        System.out.println("Great! What is your gender?");
//        String gender = userString;
//
//        System.out.println("Almost done! What is your age?");
//        int age = userInt;
//
//        System.out.println("Last thing! Which state are you from?");
//        String state = userString;
//
//        System.out.println("Thank you very much " + firstName + " for registering with our system!");
//
//        User newUser = new User(firstName, lastName, gender, age, state);
//
//        users.add(newUser);
//    }
}
