
package com.billsystem;


public abstract class Bill {
    protected String billId;
    protected String customerId;
    protected double unitsConsumed;
    protected String month;
    protected boolean isPaid;

    // Constructor
    public Bill(String billId,
                String customerId,
                double unitsConsumed,
                String month) {

        this.billId = billId;
        this.customerId = customerId;
        this.unitsConsumed = unitsConsumed;
        this.month = month;

        this.isPaid = false;
    }

    // Abstract method
    public abstract double calculateBill();

    // Display Bill
    public void displayBill() {

        System.out.println("Bill ID: " + billId);
        System.out.println("Customer ID: " + customerId);
        System.out.println("Units: " + unitsConsumed);
        System.out.println("Month: " + month);
        System.out.println("Paid: " + isPaid);
    }

    // Mark as paid
    public void setPaid() {

        isPaid = true;
    }

    // Getters
    public String getBillId() {
        return billId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public double getUnitsConsumed() {
        return unitsConsumed;
    }

    public String getMonth() {
        return month;
    }

    public boolean isPaid() {
        return isPaid;
    }
}
