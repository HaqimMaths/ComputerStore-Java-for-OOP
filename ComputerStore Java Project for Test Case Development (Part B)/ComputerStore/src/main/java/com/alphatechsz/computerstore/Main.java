// Package name (Group ID and the project name)
package com.alphatechsz.computerstore;
/* Group ID: com.alphatechsz
*  Store Name: Alpha Techsz
*  Project Name: ComputerStore
*  Purpose: To create a Java GUI application about computer store
*/
// Main class (To run the program codes of this project)
public class Main
{
    // Main method
    public static void main(String[] args)
    {
        // Set user details
        User.setID(10);
        User.setName("Harish Haqim");
        User.setEmail("harishhaqim@outlook.com");
        User.setPassword("12345");
        // Set pre-data inventory products
        Inventory.products.add(new Computer(1, "HP", "Victus 16", "Laptop", "16 inch", "Black", 2025, "Intel Core i9", "Nvidia RTX 4090", "LARGE-ATX", 1024, 128, 4999));
        Inventory.products.add(new Computer(2, "HP", "Victus 15", "Laptop", "15 inch", "Black", 2024, "Intel Core i7", "Nvidia RTX 4080", "MINI-ATX", 512, 64, 3999));
        Inventory.products.add(new SoftwareSystem(3, "Microsoft", "Windows 11 Home", "OS", "11GB", "Blue", 2021, "Prepetual", true, false, false, 599));
        Inventory.products.add(new SoftwareSystem(4, "Microsoft", "Windows 11 Professional", "OS", "15GB", "Blue", 2021, "Prepetual", true, false, false, 1099));
        Inventory.products.add(new IODevice(5, "Razer", "Hyper-X", "Mouse", "2x6x6cm", "Black", 2020, "Type-C", "Type-C", true, true, true, 699));
        Inventory.products.add(new IODevice(6, "Aula", "120 RGB Board", "Keyboard", "15 inch", "White", 2023, "Type-C", "Type-C", true, true, true, 999));
        // GUI begins with login menu
        LoginMenu loginMenu = new LoginMenu();
        // Set login menu window to visible
        loginMenu.setVisible(true);
    }
}