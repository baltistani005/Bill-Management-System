
package com.billsystem;


public class Customer extends user implements Payable{
    private String address;
    private String contactNumber;

    // Constructor
    public Customer(String id, String name, String password,
                    String address, String contactNumber) {
        super(id, name, password);
        this.address = address;
        this.contactNumber = contactNumber;
    }

    // Override abstract method
    @Override
    public void displayinfo() {
        System.out.println("\n===== CUSTOMER MENU =====");
        System.out.println("1. View Profile");
        System.out.println("2. View Current Bill");
        System.out.println("3. Pay Bill");
        System.out.println("4. Change Password");
        System.out.println("5. Logout");
    }

    // View profile method
    public void viewProfile() {
        System.out.println("\n--- Customer Profile ---");
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Address: " + address);
        System.out.println("Contact: " + contactNumber);
    }
    public String getAddress() {
    return address;
    }   

    public String getContact() {
    return contactNumber;
    }

    public String getPasswordForFile() {
    return password;   
    }
    @Override
public void payBill() {

    System.out.println("Bill Paid Successfully.");
}

@Override
public double getRemaining() {

    return 0;
}
        }

