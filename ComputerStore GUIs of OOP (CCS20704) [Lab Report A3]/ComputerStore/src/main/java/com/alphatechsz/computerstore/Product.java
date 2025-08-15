// Package name (Group ID and the project name)
package com.alphatechsz.computerstore;
// Base class and the Parent class (Product.java)
/* The purpose of the base class is to become the parent class for the other 3 derived classes
*  which are Computer, SoftwareSystem, and IODevice
*/
public class Product // Class becoming abstract for containing abstract method
{
    // 9 Private attributes
    private int ID; // ID of the product
    private String brand; // Brand of the product
    private String model; // Model of the product
    private String category; // Category of the product
    private String type; // Type of the product
    private String size; // Size of the product
    private String color; // Color of the product
    private int manufactureYear; // Manufacture year of the product
    private double price; // Price of the product
    // 2 Constructors
    public Product() // Empty constructor
    {
        this(0, "None", "None", "None", "None", "None", "None", 0, 0.0);
    }
    public Product(int ID, String brand, String model,
            String category, String type, String size, String color, 
            int manufactureYear, double price) // Paramatized constructor (9 Parameters)
    {
        this.ID = ID; // Set ID of the instance
        this.brand = brand; // Set brand of the instance
        this.model = model; // Set model of the instance
        this.category = category; // Set category of the instance
        this.type = type; // Set type of the instance
        this.size = size; // Set size of the instance
        this.color = color; // Set color of the instance
        this.manufactureYear = manufactureYear; // Set manufacture year of the instance
        this.price = price; // Set price of the instance
    }
    // Setters
    public void setID(int ID) // Set ID
    {
        this.ID = ID;
    }
    public void setBrand(String brand) // Set brand
    {
        this.brand = brand;
    }
    public void setModel(String model) // Set model
    {
        this.model = model;
    }
    public void setCategory(String category) // Set category
    {
        this.category = category;
    }
    public void setType(String type) // Set type
    {
        this.type = type;
    }
    public void setSize(String size) // Set size
    {
        this.size = size;
    }
    public void setColor(String color) // Set color
    {
        this.color = color;
    }
    public void setManufactureYear(int manufactureYear) // Set manufacture year
    {
        this.manufactureYear = manufactureYear;
    }
    public void setPrice(double price) // Set price
    {
        this.price = price;
    }
    // Getters
    public int getID() // Get ID
    {
        return this.ID;
    }
    public String getBrand() // Get brand
    {
        return this.brand;
    }
    public String getModel() // Get model
    {
        return this.model;
    }
    public String getCategory() // Get category
    {
        return this.category;
    }
    public String getType() // Get type
    {
        return this.type;
    }
    public String getSize() // Get size
    {
        return this.size;
    }
    public String getColor() // Get color
    {
        return this.color;
    }
    public int getManufactureYear() // Get year of manufacture
    {
        return this.manufactureYear;
    }
    public double getPrice() // Get price
    {
        return this.price;
    }
    // To display object information (Overrideable method)
    public void getInformation()
    {
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("Product: " + this.getBrand() + " " + this.getModel()); // Display product brand and model
        System.out.println("ID: " + this.getID()); // Display product ID
        System.out.println("Size: " + this.getSize()); // Display product size (Height x Length x Width)
        System.out.println("Color: " + this.getColor()); // Display product color
        System.out.println("Category: " + this.getCategory()); // Display product category
        System.out.println("Type: " + this.getType()); // Display product type
        System.out.println("Manufacture year: " + this.getColor()); // Display product manufacture year
    }
    // To identify the current product type and category (Overrideable method)
    public void identity()
    {
        System.out.println("I am a product.");
    }
    // To obtain the new discount total
    public double getDiscountTotal(double discountPercentage)
    {
        return (discountPercentage * this.getPrice()) / 100;
    }
    // To obtain the total discount price (Original price - Discount price)
    public double getDiscountPrice(double discountPercentage)
    {
        return this.getPrice() - (discountPercentage * this.getPrice()) / 100;
    }
}
