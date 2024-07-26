import java.util.Scanner;

public class BankAccount {
    private String accountHolderName;
    private double accountBalance;
    private int accountNumber;

    private static int nextAccountNumber = 1234;

    public BankAccount(String accountHolderName, double accountBalance, int accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountBalance = accountBalance;
        this.accountNumber = accountNumber;
    }

    public BankAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("What is the name for the account? ");
        this.accountHolderName = scanner.nextLine();
        System.out.print("What is the beginning balance for the account? ");
        this.accountBalance = scanner.nextDouble();
        this.accountNumber = nextAccountNumber++;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            accountBalance += amount;
            System.out.println("Deposit successful. New balance: $" + accountBalance);
        } else {
            System.out.println("Deposit amount must be greater than zero.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= accountBalance) {
            accountBalance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + accountBalance);
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    // Method to transfer an amount to another account
    public void transfer(BankAccount toAccount, double amount) {
        if (amount > 0 && amount <= accountBalance) {
            this.withdraw(amount);
            toAccount.deposit(amount);
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void printAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Balance: $" + accountBalance);
    }
}
