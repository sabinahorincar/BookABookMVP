package com.example.bookabook.ui;

public class Singleton {
    // static variable single_instance of type Singleton
    private static Singleton single_instance = null;

    // variable of type String
    public String book;
    public String username;
    public boolean logedIn;
    public boolean hasMembership;

    // private constructor restricted to this class itself
    private Singleton()
    {
        book = "Your card is empty";
        username = "Welcome";
        logedIn = false;
    }

    // static method to create instance of Singleton class
    public static Singleton getInstance()
    {
        if (single_instance == null)
            single_instance = new Singleton();

        return single_instance;
    }

}
