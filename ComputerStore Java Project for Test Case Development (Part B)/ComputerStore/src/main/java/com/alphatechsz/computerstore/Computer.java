// Package name (Group ID and the project name)
package com.alphatechsz.computerstore;
// Computer Class (1st derived class) inherits Product.java and implements Diagnosis.java interface
public class Computer extends Product implements Diagnosis
{
    // 5 Private attributes
    private String typeCPU; // CPU type of the computer
    private String typeGPU; // GPU type of the computer
    private String typeMotherboard; // Motherboard type of the computer
    private int sizeStorage; // Storage size of the computer
    private int sizeRAM; // RAM size of the computer
    // 2 Constructors
    // Default constructor (Empty constructor)
    public Computer()
    {
        // Refer to the paramatized constructor of this class
        this(0, "None", "None", "None", "None", "None", 0, "None", "None", "None", 0, 0, 0.0);
    }
    // Paramatized constructor (13 parameters)
    public Computer(int ID, String brand, String model, String type, String size, String color, int manufactureYear, String typeCPU, String typeGPU,
            String typeMotherboard, int sizeStorage,
            int sizeRAM, double price)
    {
        // Refer to the parent class which is the base class (Product.java)
        super(ID, brand, model, "Computer", type, size, color, manufactureYear, price);
        this.typeCPU = typeCPU; // Set CPU type of the instance
        this.typeGPU = typeGPU; // Set GPU type of the instance
        this.typeMotherboard = typeMotherboard; // Set motherboard type of the instance
        this.sizeStorage = sizeStorage; // Set storage size of the instance
        this.sizeRAM = sizeRAM; // Set RAM size of the instance
    }
    // Methods
    // Setters (Encapsulations)
    public void setTypeCPU(String newTypeCPU) // Set CPU type value of the computer object
    {
        this.typeCPU = newTypeCPU;
    }
    public void setTypeGPU(String newTypeGPU) // Set GPU type value of the computer object
    {
        this.typeGPU = newTypeGPU;
    }
    public void setTypeMotherboard(String newTypeMotherboard) // Set value motherboard type of the computer object
    {
        this.typeMotherboard = newTypeMotherboard;
    }
    public void setSizeStorage(int newSizeStorage) // Set value for storage size of the computer object
    {
        this.sizeStorage = newSizeStorage;
    }
    public void setSizeRAM(int newSizeRAM) // Set value for RAM size of the computer object
    {
        this.sizeRAM = newSizeRAM;
    }
    // Getters (Encapsulations)
    public String getTypeCPU() // Get value of CPU type of the computer object
    {
        return this.typeCPU;
    }
    public String getTypeGPU() // Get value of GPU type of the computer object
    {
        return this.typeGPU;
    }
    public String getTypeMotherboard() // Get value of motherboard type of the computer object
    {
        return this.typeMotherboard;
    }
    public int getSizeStorage() // Get value of storage size of the computer object
    {
        return this.sizeStorage;
    }
    public int getSizeRAM() // Get value of RAM size of the computer object
    {
        return this.sizeRAM;
    }
    // Other methods
    // To display object information
    @Override // Override getInformation() method from the base class
    public void getInformation()
    {
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("Computer " + this.getBrand() + "-" + this.getModel() + " information"); // Display computer brand and model
        System.out.println("ID: " + this.getID()); // Display computer ID
        System.out.println("Size: " + this.getSize()); // Display computer size (Height x Length x Width)
        System.out.println("Color: " + this.getColor()); // Display computer color
        System.out.println("Category: " + this.getCategory()); // Display computer category
        System.out.println("Type: " + this.getType()); // Display computer type
        System.out.println("Manufacture year: " + this.getColor()); // Display computer manufacture year
        System.out.println("CPU type: " + this.typeCPU); // Display CPU type
        System.out.println("GPU type: " + this.typeGPU); // Display GPU type
        System.out.println("Motherboard type: " + this.typeMotherboard); // Display motherboard type
        System.out.println("Storage size: " + this.sizeStorage); // Display storage size (In GB)
        System.out.println("RAM size: " + this.sizeRAM); // Display RAM size (In GB)
        System.out.println("Price: RM" + this.getPrice()); // Display the original price of the computer
        System.out.printf("10%% Discount price: RM%.2f\n", this.getDiscountPrice(10)); // Display the 10% discount price of the computer
        System.out.printf("10%% Discount total: RM%.2f\n", this.getDiscountTotal(10)); // Display the 10% discount total of the computer
    }
    // To identify the current computer object type and category (Overrideable method)
    @Override // Override identity() method from the base class
    public void identity()
    {
        System.out.println("I am " + this.getType() + " from " + this.getCategory());
        System.out.println("I am made with electronic circuits.");
    }
    // Try to turn on the computer
    @Override // Override turnOn() method from the Diagnosis interface
    public void turnOn()
    {
        System.out.println("The " + this.getBrand() + " " + this.getModel() + " can be turned on without any errors!");
    }
    // Try to turn off the computer
    @Override // Override turnOff() method from the Diagnosis interface
    public void turnOff()
    {
        System.out.println("The " + this.getBrand() + " " + this.getModel() + " can be turned on without any errors!");
    }
    // Try to run the computer
    @Override // Override run() method from the Diagnosis interface
    public void run()
    {
        System.out.println("The " + this.getBrand() + " " + this.getModel() + " can be run without any issues!");
    }
    // Try to update the computer
    @Override // Override update() method from the Diagnosis interface
    public void update()
    {
        System.out.println("The " + this.getBrand() + " " + this.getModel() + " is up to date!");
    }
    // Check whether the computer is a computer gaming or not
    public boolean isComputerGaming()
    {
        // Check whether the computer contains RTX or Radeon or Arc in its GPU type
        return (this.getTypeGPU().toLowerCase().contains("rtx") || this.getTypeGPU().toLowerCase().contains("radeon")
                || this.getTypeGPU().toLowerCase().contains("arc"));
    }
}