
package com.billsystem;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class FileManager {
  
    private static final String CUSTOMER_FILE = "customers.txt";
    private static final String BILL_FILE = "bills.txt";

    // ✅ Save customer to file
    public static void saveCustomer(Customer customer) {

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(CUSTOMER_FILE, true))) {

            writer.write(customer.getId() + "," +
                         customer.getName() + "," +
                         customer.getPasswordForFile() + "," +
                         customer.getAddress() + "," +
                         customer.getContact());

            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ✅ Load customers from file
public static ArrayList<Customer> loadCustomers() {

    ArrayList<Customer> customers = new ArrayList<>();

    File file = new File(CUSTOMER_FILE);

    if (!file.exists()) {
        return customers;
    }

    try (BufferedReader reader = new BufferedReader(
            new FileReader(CUSTOMER_FILE))) {

        String line;

        while ((line = reader.readLine()) != null) {

            String[] data = line.split(",");

            Customer customer = new Customer(
                    data[0],
                    data[1],
                    data[2],
                    data[3],
                    data[4]
            );

            customers.add(customer);
        }

    } catch (IOException e) {
        e.printStackTrace();
    }

    return customers;
}
// Save all customers (overwrites file)
public static void saveAllCustomers(ArrayList<Customer> customers) {
    try (BufferedWriter writer = new BufferedWriter(
            new FileWriter(CUSTOMER_FILE))) {
        
        for (Customer c : customers) {
            writer.write(c.getId() + "," +
                         c.getName() + "," +
                         c.getPasswordForFile() + "," +
                         c.getAddress() + "," +
                         c.getContact());
            writer.newLine();
        }
        
    } catch (IOException e) {
        e.printStackTrace();
    }
}
// Save bill to file
public static void saveBill(Bill bill, String billType) {

    try (BufferedWriter writer =
                 new BufferedWriter(
                         new FileWriter(BILL_FILE, true))) {

        writer.write(
                bill.getBillId() + "," +
                bill.getCustomerId() + "," +
                bill.getUnitsConsumed() + "," +
                bill.getMonth() + "," +
                bill.calculateBill() + "," +
                billType + "," +
                bill.isPaid()
        );

        writer.newLine();

    } catch (IOException e) {

        e.printStackTrace();
    }
}
// Load all bills from file
public static ArrayList<Bill> loadBills() {

    ArrayList<Bill> bills = new ArrayList<>();

    File file = new File(BILL_FILE);

    if (!file.exists()) {
        return bills;
    }

    try (BufferedReader reader = new BufferedReader(
            new FileReader(BILL_FILE))) {

        String line;

        while ((line = reader.readLine()) != null) {

            String[] data = line.split(",");

            String billId = data[0];
            String customerId = data[1];
            double units = Double.parseDouble(data[2]);
            String month = data[3];
            double amount = Double.parseDouble(data[4]);
            String billType = data[5];
            boolean isPaid = Boolean.parseBoolean(data[6]);

            // Create appropriate Bill object based on type
            Bill bill = null;

            switch (billType) {

                case "Electricity":
                    bill = new ElectricityBill(
                            billId, customerId, units, month, 20);
                    break;

                case "Gas":
                    bill = new GasBill(
                            billId, customerId, units, month, 15);
                    break;

                case "Water":
                    bill = new WaterBill(
                            billId, customerId, units, month, 10);
                    break;
            }

            if (bill != null) {
                if (isPaid) {
                    bill.setPaid();
                }
                bills.add(bill);
            }
        }

    } catch (IOException e) {
        e.printStackTrace();
    }

    return bills;
}
// Save all bills back to file
public static void saveAllBills(ArrayList<Bill> bills) {

    try (BufferedWriter writer =
                 new BufferedWriter(
                         new FileWriter(BILL_FILE))) {

        for (Bill bill : bills) {

            String billType = "";

            if (bill instanceof ElectricityBill) {

                billType = "Electricity";
            }

            else if (bill instanceof GasBill) {

                billType = "Gas";
            }

            else if (bill instanceof WaterBill) {

                billType = "Water";
            }

            writer.write(
                    bill.getBillId() + "," +
                    bill.getCustomerId() + "," +
                    bill.getUnitsConsumed() + "," +
                    bill.getMonth() + "," +
                    bill.calculateBill() + "," +
                    billType + "," +
                    bill.isPaid()
            );

            writer.newLine();
        }

    } catch (IOException e) {

        e.printStackTrace();
    }
}
}

