import java.util.ArrayList;
import java.util.Scanner;

class Account {
    private String accountHolder;
    private double balance;
    private ArrayList<String> transactionHistory;

    public Account(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account opened with ₹" + initialBalance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited ₹" + amount);
            System.out.println(" Deposit successful. New Balance: ₹" + balance);
        } else {
            System.out.println(" Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println(" Invalid withdrawal amount.");
            return;
        }
        if (amount > balance) {
            System.out.println(" Insufficient balance!");
            transactionHistory.add("Failed withdrawal attempt of ₹" + amount);
        } else {
            balance -= amount;
            transactionHistory.add("Withdrew ₹" + amount);
            System.out.println(" Withdrawal successful. New Balance: ₹" + balance);
        }
    }

    public void showBalance() {
        System.out.println(" Current Balance: ₹" + balance);
    }

    public void showTransactionHistory() {
        System.out.println(" Transaction History:");
        for (String entry : transactionHistory) {
            System.out.println("- " + entry);
        }
    }
}

public class BankAccount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(" Enter account holder name: ");
        String name = scanner.nextLine();
        System.out.print(" Enter initial deposit: ₹");
        double initialBalance = scanner.nextDouble();

        Account account = new Account(name, initialBalance);

        int choice;
        do {
            System.out.println("\n=====  BANK MENU =====");
            System.out.println("1️  Deposit");
            System.out.println("2 Withdraw");
            System.out.println("3️  Check Balance");
            System.out.println("4️  View Transactions");
            System.out.println("0️  Exit");
            System.out.print("➡ Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print(" Enter deposit amount: ₹");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print(" Enter withdrawal amount: ₹");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.showBalance();
                    break;
                case 4:
                    account.showTransactionHistory();
                    break;
                case 0:
                    System.out.println(" Exiting. Thank you!");
                    break;
                default:
                    System.out.println(" Invalid choice. Try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
