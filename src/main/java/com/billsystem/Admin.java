
package com.billsystem;

public class Admin extends user{
    // Constructor
    public Admin(String id, String name, String password) {
        super(id, name, password);
    }

    // Override abstract method
    @Override
    public void displayinfo() {

    }
}

