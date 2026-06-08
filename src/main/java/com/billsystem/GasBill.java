
package com.billsystem;

public class GasBill extends Bill {
     private double ratePerUnit;

    // Constructor
    public GasBill(String billId,
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
