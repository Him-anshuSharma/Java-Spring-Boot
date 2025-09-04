package week1;

import java.util.*;

abstract class User {
    protected String name;
    protected String userId;

    public User(String name, String userId) {
        this.name = name;
        this.userId = userId;
    }

    public abstract void getDetails();
}

interface Transaction {
    void deposit(double amount);
    void withdraw(double amount);
    double checkBalance();
}

class Customer extends User implements Transaction {
    private double balance;
    private boolean active = true;

    public Customer(String name, String userId, double balance) {
        super(name, userId);
        this.balance = balance;
    }

    @Override
    public void getDetails() {
        System.out.println("Customer: " + name + " (ID: " + userId + "), Balance: " + balance + ", Active: " + active);
    }

    @Override
    public void deposit(double amount) {
        if (!active) {
            System.out.println("Account frozen. Deposit not allowed.");
            return;
        }
        balance += amount;
        System.out.println("Deposited: " + amount + ", New Balance: " + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (!active) {
            System.out.println("Account frozen. Withdrawal not allowed.");
            return;
        }
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    @Override
    public double checkBalance() {
        return balance;
    }

    public void freezeAccount() { active = false; }
    public void unfreezeAccount() { active = true; }
}

class Admin extends User {
    private List<Customer> customers;

    public Admin(String name, String userId, List<Customer> customers) {
        super(name, userId);
        this.customers = customers;
    }

    @Override
    public void getDetails() {
        System.out.println("Admin: " + name + " (ID: " + userId + ")");
    }

    public void viewAllAccounts() {
        System.out.println("All Accounts:");
        for (Customer c : customers) {
            c.getDetails();
        }
    }

    public void freezeAccount(Customer c) {
        c.freezeAccount();
        System.out.println("Account frozen for " + c.name);
    }

    public void unfreezeAccount(Customer c) {
        c.unfreezeAccount();
        System.out.println("Account unfrozen for " + c.name);
    }
}

public class BankSystem {
    public static void main(String[] args) {
        Customer c1 = new Customer("Alice", "C001", 1000);
        Customer c2 = new Customer("Bob", "C002", 2000);
        List<Customer> list = new ArrayList<>();
        list.add(c1);
        list.add(c2);

        Admin admin = new Admin("Admin1", "A001", list);

        c1.deposit(500);
        c1.withdraw(200);
        System.out.println("Balance: " + c1.checkBalance());

        admin.viewAllAccounts();
        admin.freezeAccount(c1);
        c1.withdraw(100); // should be blocked
        admin.unfreezeAccount(c1);
        c1.withdraw(100);
    }
}
