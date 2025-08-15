// Package name (Group ID and the project name)
package com.alphatechsz.computerstore;
// Import arraylist
import java.util.ArrayList;
// Order class (3rd additional class)
public class Order
{
    // 3 Private attributes
    private String ID; // ID of the order
    private String userID; // User ID of the order and it cannot be changed because every order the users make, the order will be assigned based on their unique user's ID
    public static ArrayList<Product> products = new ArrayList<>(); // ArrayList of products inside an order
    // Constructors
//    public Order() // Empty constructor
//    {
//        // Refering to the paramatized constructor
//        this("0000", null);
//    }
//    public Order(String ID, User user) // Paramatized constructor (2 Parameters)
//    {
//        this.ID = "ORDER" + ID; // Set order ID with the beginning of "ORDER"
//        this.userID = user.getID(); // Put user ID in every order it makes
//        products = new ArrayList<>(); // Initiliase ArrayList of products of the instance
//    }
    // Setter
    public void setID(String ID) // Set order ID
    {
        this.ID = ID;
    }
    // Getters
    public String getID() // Get order ID
    {
        return this.ID;
    }
    public String getUserID() // Get user ID
    {
        return this.userID;
    }
    // Add product to the order
    public void addProduct(Product product)
    {
        products.add(product); // Add a product to the ArrayList of products
        System.out.println("Product added to order: " + product.getBrand() + " " + product.getModel());
    }
    // Search product inside the user order
    public Product searchProduct(int productID)
    {
        for(Product product : products) // For each loop (Iterate through the products)
        {
            if(product.getID() == productID) // Check whether the product ID is the same inside the inventory list
            {
                return product;
            }
        }
        System.out.println("Product ID not found!");
        return null;
    }
    // Remove a product from the order
    public void removeProduct(int productID)
    {
        products.remove(searchProduct(productID)); // Remove a product by its ID
    }
    // Confirming the user order
    public void confirmOrder(Inventory inventory)
    {
        System.out.println("Order has been confirmed");
        // This will remove the ordered products inside the order from the inventory list.
//        for (Product product : products) // For each loop (Iterate through the products)
//        {
//            inventory.removeProduct(product.getID());
//        }
    }
    // Display the receipt as a summary from the user order
    public void receipt()
    {
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("Receipt " + this.getID());
        System.out.println("---------------------------------------------------------------------------------");
        for(Product product : products) // For each loop (Iterate through the products list)
        {
            System.out.println(product.getBrand() + " " + product.getModel());
            System.out.println("ID: " + product.getID());
            System.out.println("Price: RM" + product.getPrice());
            System.out.printf("10%% Discount total: RM%.2f\n", product.getDiscountTotal(10));
            System.out.printf("10%% Discount new price: RM%.2f\n", product.getDiscountPrice(10));
        }
        double totalPrice = 0;
        for(Product product : products) // For each loop (Iterate through the products list)
        {
            totalPrice = totalPrice + product.getDiscountPrice(10);
        }
        System.out.printf("Total price all items: RM%.2f\n", totalPrice);
        System.out.println("Thank you for the purchase!");
        System.out.println("---------------------------------------------------------------------------------");
    }
    // Get list of products inside an order
    public void getProducts()
    {
        for(Product product : products) // For each loop (Iterate through the products list)
        {
            product.getInformation();
        }
    }
}
