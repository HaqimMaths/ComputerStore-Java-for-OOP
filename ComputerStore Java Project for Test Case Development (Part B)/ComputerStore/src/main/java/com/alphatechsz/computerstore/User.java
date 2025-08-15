// Package name (Group ID and the project name)
package com.alphatechsz.computerstore;
// User class (1st additional class)
// User class is used for login operation inside the main class
public class User
{
    // 4 Private attributes
    private static int ID; // ID of the user
    private static String name; // Name of the user
    private static String email; // Email of the user
    private static String password; // Password of the user
//    // Constructors
//    public User() // Empty constructor
//    {
//        // Refer to the paramatized constructor
//        this("0000", "None", "None", "None");
//    }
//    public User(String ID, String name,
//             String email, String password) // Paramatized constructor (4 Parameters)
//    {
//        ID = "USER" + ID; // Set the ID of the user class instance with the beginning of "USER"
//        name = name; // Set the name of the user instance
//        email = email; // Set the email of the user instance
//        password = password; // Set the password of the user instance
//    }
    // Setters
    public static void setID(int newID) // Set ID
    {
        ID = newID;
    }
    public static void setName(String newName) // Set name
    {
        name = newName;
    }
    public static void setEmail(String newEmail) // Set email
    {
        email = newEmail;
    }
    public static void setPassword(String newPassword) // Set password
    {
        password = newPassword;
    }
    // Getters
    public static int getID() // Get ID
    {
        return ID;
    }
    public static String getName() // Get name
    {
        return name;
    }
    public static String getEmail() // Get email
    {
        return email;
    }
    public static String getPassword() // Get password
    {
        return password;
    }
    // Get details about the user
    public static void getInformation()
    {
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("User Information"); 
        System.out.println("ID: " + ID); // Display ID of the user
        System.out.println("Name: " + name); // Display name of the user
        System.out.println("Email: " + email); // Display email of the user
        System.out.println("Password: " + password); // Display password of the user
    }
}
