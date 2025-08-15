// Package name (Group ID and the project name)
package com.alphatechsz.computerstore;
// Diagnosis interface (Polymorphism interface)
// To do maintenances for the electronic devices such as Computer, Software System, and IO Device.
public interface Diagnosis 
{
    // 4 different methods available
    // Turn on method (Turning on the power of the object)
    void turnOn();
    // Turn off method (Turning off the power of the object
    void turnOff();
    // Run method (Running the usage of the object)
    void run(); 
    // Update method (Updating the drivers or softwares of the object)
    void update();
}
