// Package name (Group ID and the project name)
package com.alphatechsz.computerstore;
// Import arraylist
import java.util.ArrayList;
// Inventory class (2nd additional class)
public class Inventory 
{
    // 1 Private attribute
    public static ArrayList<Product> products = new ArrayList<>(); // List of all products inside an ArrayList
    // Constructor
    public Inventory() // Empty constructor
    {
        products = new ArrayList<>(); // Initialize products ArrayList
    }
}