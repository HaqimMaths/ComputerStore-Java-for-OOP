// Package name (Group ID and the project name)
package com.alphatechsz.computerstore;
// IODevice Class (3rd derived class) inherits Product.java and implements Diagnosis.java interface
public class IODevice extends Product implements Diagnosis
{
    // 5 Private attributes
    private String maleConnector; // Male connector (Plug in)
    private String femaleConnector; // Female connector (Plug ports)
    private boolean wiredConnection; // Is the current object of IO device a wired connection?
    private boolean wirelessUsbConnection; // Is the current object of IO device a wireless USB connection?
    private boolean bluetoothConnection; // Is the current object of IO device have Bluetooth connection?
    // 2 Constructors
    // Default constructor (Empty Constructor)
    public IODevice() {
        // Refering to the paramatized constructor of this class
        this(0, "None", "None", "None", "None", "None", 0, "None", "None", false, false, false, 0.0);
    }
    // Parameterized constructor (13 parameters)
    public IODevice(int ID, String brand, String model, String type,
            String size, String color, int manufactureYear,
            String maleConnector, String femaleConnector,
            boolean wirelessUsbConnection, boolean wiredConnection,
            boolean bluetoothConnection, double price)
    {
        // Refering to the base class which is the parent class (Product.java)
        super(ID, brand, model, "IO Device", type, size, color, manufactureYear, price);
        this.maleConnector = maleConnector; // Set male connector of the instance
        this.femaleConnector = femaleConnector; // Set female connector of the instance
        this.wiredConnection = wiredConnection; // Set wired connection of the instance
        this.wirelessUsbConnection = wirelessUsbConnection; // Set wireless USB connection of the instance
        this.bluetoothConnection = bluetoothConnection; // Set bluetooth connection of the instance
    }
    // Setters
    public void setMaleConnector(String maleConnector) // Set male connector
    {
        this.maleConnector = maleConnector;
    }
    public void setFemaleConnector(String femaleConnector) // Set female connector
    {
        this.femaleConnector = femaleConnector;
    }
    public void setWiredConnection(boolean wiredConnection) // Set wired connection
    {
        this.wiredConnection = wiredConnection;
    }
    public void setWirelessUsbConnection(boolean wirelessUsbConnection) // Set wireless USB connection
    {
        this.wirelessUsbConnection = wirelessUsbConnection;
    }
    public void setBluetoothConnection(boolean bluetoothConnection) // Set bluetooth connection
    {
        this.bluetoothConnection = bluetoothConnection;
    }
    // Getters
    public String getMaleConnector() // Get male connector
    {
        return this.maleConnector;
    }
    public String getFemaleConnector() // Get female connector
    {
        return this.femaleConnector;
    }
    public boolean getWiredConnection() // Get wired connection
    {
        return this.wiredConnection;
    }
    public boolean getWirelessUsbConnection() // Get wireless USB connection
    {
        return this.wirelessUsbConnection;
    }
    public boolean getBluetoothConnection() // Get bluetooth connection
    {
        return this.bluetoothConnection;
    }
    // Method 1: Display details of the accessory
    @Override // Override getInformation() method from the base class
    public void getInformation()
    {
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("IO Device " + this.getBrand() + "-" + this.getModel() + " Information"); // Display the brand and the model of IO device
        System.out.println("ID: " + this.getID()); // Display the ID of the IO device
        System.out.println("Brand: " + this.getBrand()); // Display the brand of the IO device
        System.out.println("Model: " + this.getModel()); // Display the model of the IO device
        System.out.println("Category: " + this.getCategory()); // Display the category of the IO device
        System.out.println("Type: " + this.getType()); // Display the type of the IO device
        System.out.println("Size: " + this.getSize()); // Display the size of the IO device (Height * Length * Width)
        System.out.println("Color: " + this.getColor()); // Display the color of the IO device
        System.out.println("Manufacture Year: " + this.getManufactureYear()); // Display the year of manufacture of the IO device
        System.out.println("Male connector: " + this.maleConnector); // Display the type of male connector for the IO device
        System.out.println("Female connector: " + this.femaleConnector); // Display the type of female connector for the IO device
        System.out.println("Wired connection: " + this.wiredConnection); // Display whether the IO device is wired connection or not
        System.out.println("Wireless USB connection: " + this.wirelessUsbConnection); // Display whether the IO device is wireless USB connection or not
        System.out.println("Bluetooth connection: " + this.bluetoothConnection); // Display whether the IO device is bluetooth connection or not
        System.out.println("Price: RM" + this.getPrice()); // Display the IO device original price
        System.out.printf("10%% Discount price: RM%.2f\n", this.getDiscountPrice(10)); // Display the IO device 10% discount price
        System.out.printf("10%% Discount total: RM%.2f\n", this.getDiscountTotal(10)); // Display the IO device 10% discount total
    }
    // To identify the current IO device object type and category (Overrideable method)
    @Override // Override identity() method from the base class
    public void identity()
    {
        System.out.println("I am " + this.getType() + " from " + this.getCategory());
        System.out.println("I am made for inputting instructions to the computer and outputting it from the computer.");
    }
    // Turn on
    @Override // Override turnOn() method from the Diagnosis interface
    public void turnOn()
    {
        System.out.println(this.getBrand() + " " + this.getModel() + " can be turned on.");
    }
    // Run the software
    @Override // Override run() method from the Diagnosis interface
    public void run()
    {
        System.out.println(this.getBrand() + " " + this.getModel() + " can be used smoothly.");
    }
    // Turn off
    @Override // Override turnOff() method from the Diagnosis interface
    public void turnOff()
    {
        System.out.println(this.getBrand() + " " + this.getModel() + " can turned off without any bugs.");
    }
    // Update the software
    @Override // Override update() method from the Diagnosis interface
    public void update()
    {
        System.out.println(this.getBrand() + " " + this.getModel() + " drivers can be updated and up to date.");
    }
    // Check if the accessory is multi connections or not.
    public boolean isMultiConnections()
    {
        // Check whether the IO device have 2 connections over 3 connections
        return (this.wiredConnection && this.wirelessUsbConnection) || (this.wiredConnection && this.bluetoothConnection)
                || (this.wirelessUsbConnection || this.bluetoothConnection);
    }
}