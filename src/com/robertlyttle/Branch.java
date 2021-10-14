package com.robertlyttle;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    private Customer findCustomer(String customerName) {
        for (Customer customer : customers) {
            if (customer.getName().equals(customerName)) {
                return customer;
            }
        }
        return null;
    }

    public int addCustomer(String customerName, double initialTransaction) {
        if (findCustomer(customerName) == null) {
            this.customers.add(new Customer(customerName, initialTransaction));
            return 1;
        }
        return -1;
    }

    public int addCustomerTransaction(String customerName, double amount) {
        Customer customer = findCustomer(customerName);
        if (customer != null) {
            customer.addTransaction(amount);
            return 1;
        }
        return -1;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
}
