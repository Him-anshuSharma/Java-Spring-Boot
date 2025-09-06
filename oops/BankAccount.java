package oops;

class BankAccount {
    private int balance;
    private long lastTransaction;

    BankAccount() {
        balance = 0;
    }

    private void updateBalance(int balance) {
        this.balance = balance;
        lastTransaction = System.currentTimeMillis();
    }

    public long getLastTransaction() {
        return lastTransaction;
    }

    public void deposit(int amount) {
        if (amount <= 0)
            return;
        int updatedBalance = balance + amount;
        updateBalance(updatedBalance);
    }

    public boolean withdraw(int amount) {
        if (amount > balance)
            return false;
        int remaingBalance = balance - amount;
        updateBalance(remaingBalance);
        return true;
    }
}