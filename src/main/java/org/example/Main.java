package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<BankAccount> accounts = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Hello world! Welcome to the Bank of Stiegler!");
            System.out.println("Are you an existing customer? (-1 to exit)");
            System.out.println("1. Yes");
            System.out.println("2. No");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == -1) {
                break;
            }

            switch (choice) {
                case 1:
                    System.out.println("Please enter your account number:");
                    int accountNumber = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    BankAccount existingAccount = findAccount(accountNumber);
                    if (existingAccount != null) {
                        mainMenu(existingAccount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 2:
                    BankAccount newAccount = new BankAccount();
                    accounts.add(newAccount);
                    newAccount.printAccountDetails();
                    mainMenu(newAccount);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static BankAccount findAccount(int accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    private static void mainMenu(BankAccount account) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Hello " + account.getAccountHolderName() + "!");
            System.out.println("Welcome to the org.example.Main Menu, what would you like to do today?");
            System.out.println("1. To check account balance");
            System.out.println("2. To make a withdrawal");
            System.out.println("3. To make a deposit");
            System.out.println("4. To make a transfer to another account");
            System.out.println("0. To exit.");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Your account balance is: $" + account.getAccountBalance());
                    break;
                case 2:
                    System.out.println("Enter the amount to withdraw:");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Enter the amount to deposit:");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 4:
                    System.out.println("Please enter the account number to transfer to:");
                    int transferAccountNumber = scanner.nextInt();
                    scanner.nextLine();
                    BankAccount toAccount = findAccount(transferAccountNumber);
                    if (toAccount != null) {
                        System.out.println("Please enter the amount to transfer:");
                        double transferAmount = scanner.nextDouble();
                        account.transfer(toAccount, transferAmount);
                    } else {
                        System.out.println("Account doesn't exist.");
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
