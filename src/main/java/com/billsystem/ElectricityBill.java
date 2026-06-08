
package com.billsystem;


public class ElectricityBill extends Bill{
        private double ratePerUnit;

    // Constructor
    public ElectricityBill(String billId,
                           String customerId,
                           double unitsConsumed,
                           String month,
                           double ratePerUnit) {

        super(billId, customerId, unitsConsumed, month);

        this.ratePerUnit = ratePerUnit;
    }

    // Override abstract method
    @Override
    public double calculateBill() {

        return unitsConsumed * ratePerUnit;
    }
}
