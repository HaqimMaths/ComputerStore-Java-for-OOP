// Package name (Group ID and the project name)
package com.alphatechsz.computerstore;
// SoftwareSystem class (2nd derived class) inherits Product.java and implements Diagnosis.java interface
public class SoftwareSystem extends Product implements Diagnosis
{
    // 4 Private attributes
    private String licenseType; // License type of the software system
    private boolean compatibleWithWindows; // Can the current object of software system run in Windows OS?
    private boolean compatibleWithMac; // Can the current object of software system run in Mac OS?
    private boolean compatibleWithLinux; // Can the current object of system run in Linux OS?
    // 2 Constructors
    // Default constructor (Empty Constructor)
    public SoftwareSystem() {
        // Refer to the paramatized constructor of this class
        this(0, "None", "None", "None", "None", "None", 0, "None", false, false, false, 0.0);
    }
    
    // Paramatized Constructor (12 parameters)
    public SoftwareSystem(int ID, String brand, String model, String type, String size, String color, int manufactureYear, String licenseType,
        boolean compatibleWithWindows, boolean compatibleWithMac,
        boolean compatibleWithLinux, double price)
    {
        // Refer to the parent class which is the base class (Product.java)
        super(ID, brand, model, "Software System", type, size, color, manufactureYear, price);
        this.licenseType = licenseType; // Set license type of the instance
        this.compatibleWithWindows = compatibleWithWindows; // Set the condition of Windows OS compatible of the instance
        this.compatibleWithMac = compatibleWithMac; // Set the condition of Mac OS compatible of the instance
        this.compatibleWithLinux = compatibleWithLinux; // Set the condition of Linux OS compatible of the instance
    }

    // Setters
    public void setLicenseType(String licenseType) // Set license type of the software system object
    {
        this.licenseType = licenseType;
    }
    public void setCompatibleWithWindows(boolean compatibleWithWindows) // Set the condition of Windows OS compatibility with the object
    {
        this.compatibleWithWindows = compatibleWithWindows;
    }
    public void setCompatibleWithMac(boolean compatibleWithMac) // Set the condition of Mac OS compatibility with the object
    {
        this.compatibleWithLinux = compatibleWithMac;
    }
    public void setCompatibleWithLinux(boolean compatibleWithLinux) // Set the condition of Linux OS compatibility with the object
    {
        this.compatibleWithLinux = compatibleWithLinux;
    }
    // Getters
    public String getLicenseType() // Get license type of the software system object
    {
        return this.licenseType;
    }
    public boolean getCompatibleWithWindows() // Get the condition of Windows OS compatibility with the object
    {
        return this.compatibleWithWindows;
    }
    public boolean getCompatibleWithMac() // Get the condition of Mac OS compatibility with the object
    {
        return this.compatibleWithMac;
    }
    public boolean getCompatibleWithLinux() // Get the condition of Linux OS compatibility with the object
    {
        return this.compatibleWithLinux;
    }
    // Display details about software system
    @Override // Override getInformation() method from the base class
    public void getInformation()
    {
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("Software System " + this.getBrand() + "-" + this.getModel() + " Information"); // Display software system brand and model
        System.out.println("ID: " + this.getID()); // Display software system ID
        System.out.println("Category: " + this.getCategory()); // Display software system category
        System.out.println("Type: " + this.getType()); // Display software system type
        System.out.println("Size: " + this.getSize()); // Display software system size (In GB)
        System.out.println("Color: " + this.getColor()); // Display software system color
        System.out.println("Manufacture Year: " + this.getManufactureYear()); // Display the software system manufacture year
        System.out.println("License type: " + this.licenseType); // Display the software system license type
        System.out.println("Compatible with Windows: " + this.compatibleWithWindows); // Display the software system compatible with Windows OS
        System.out.println("Compatible with Mac: " + this.compatibleWithMac); // Display the software system compatible with Mac OS
        System.out.println("Compatible with Linux: " + this.compatibleWithLinux); // Display the software system compatible with Linux OS
        System.out.println("Price: RM" + this.getPrice()); // Display the software system price
        System.out.printf("10%% Discount price: RM%.2f\n", this.getDiscountPrice(10)); // Display the software system 10% discount price
        System.out.printf("10%% Discount total: RM%.2f\n", this.getDiscountTotal(10)); // Display the software system 10% discount total
    }
    // To identify the current software system object type and category (Overrideable method)
    @Override // Override identity() method from the base class
    public void identity()
    {
        System.out.println("I am " + this.getType() + " from " + this.getCategory());
        System.out.println("I am made with millions lines of codes.");
    }
    // Turn on
    @Override // Override turnOn() method from the Diagnosis interface
    public void turnOn()
    {
        System.out.println(this.getBrand() + " " + this.getModel() + " can be opened without any errors.");
    }
    // Run the software
    @Override // Override run() method from the Diagnosis interface
    public void run()
    {
        System.out.println(this.getBrand() + " " + this.getModel() + " can run smoothly.");
    }
    // Turn off
    @Override // Override turnOff() method from the Diagnosis interface
    public void turnOff()
    {
        System.out.println(this.getBrand() + " " + this.getModel() + " can be closed without any errors.");
    }
    // Update the software
    @Override // Override update() method from the Diagnosis interface
    public void update()
    {
        System.out.println(this.getBrand() + " " + this.getModel() + " can be updated and it is up to date.");
    }
    // Check if the software system is multi platform
    public boolean isMultiPlatform()
    {
        // Check whether the system is compatible with 2 OS over 3 OS
        return (this.compatibleWithWindows && this.compatibleWithMac)
                || (this.compatibleWithWindows && this.compatibleWithLinux) 
                || (this.compatibleWithMac && this.compatibleWithLinux);
    }
}
