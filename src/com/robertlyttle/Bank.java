package com.robertlyttle;

import java.util.ArrayList;

public class Bank {
   private String name;
   private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<>();
    }

    private Branch findBranch(String branchName) {
        for (Branch branch : branches) {
            if (branch.getName().equals(branchName)) {
                return branch;
            }
        }
        return null;
    }

    public int addBranch(String branchName) {
        if (findBranch(branchName) == null) {
            this.branches.add(new Branch(branchName));
            return 1;
        }
        return -1;
    }

    public int addCustomer(String branchName, String customerName, double initalTransaction) {
        Branch branch = findBranch(branchName);
        if(branch != null) {
            branch.addCustomer(customerName, initalTransaction);
            return 1;
        }
        return -1;
    }

    public int addCustomerTransaction(String branchName, String customerName, double amount) {
        Branch branch = findBranch(branchName);
        if(branch != null) {
            branch.addCustomerTransaction(customerName, amount);
            return 1;
        }
        return -1;
    }

    public int getBranchCustomers(String branchName, boolean showTransactions) {
        Branch branch = findBranch(branchName);

        if (branch != null) {
            System.out.println("Branch Name: " + branch.getName());
            ArrayList<Customer> branchCustomers = branch.getCustomers();
            for (Customer customer : branchCustomers) {
                System.out.println("Customer: " + customer.getName());
                if (showTransactions) {
                        System.out.println("Transactions: " + customer.getTransactions());
                }
            }
            return 1;
        }
        return -1;
    }

    public String getName() {
        return name;
    }

}
