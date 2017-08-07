import java.util.Scanner;

public class App {
    public static Scanner sc = new Scanner(System.in);
    public static Bank bank = new Bank("Millenium");

    public static void main(String[] args) {
        System.out.println("Welcome to " + bank.getName() + " bank, please see available options:");
        printOptions();
        boolean exit = false;

        while (!exit) {
            System.out.print("\nWhat is your choice? (press 9 to print options)");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    addNewBranch();
                    break;
                case 2:
                    addNewCustomer();
                    break;
                case 3:
                    addTransactionToCustomer();
                    break;
                case 4:
                    showCustomerList();
                    break;
                case 5:
                    showBranchList();
                    break;
                case 6:
                    removeBranch();
                    break;
                case 7:
                    removeCustomer();
                    break;
                case 9:
                    printOptions();
                    break;
                case 0:
                    exit = true;
                    System.out.println("Exiting program...");
                    break;
            }
        }

    }

    public static void printOptions() {
        System.out.println("1.Add new branch.");
        System.out.println("2.Add new customer to branch.");
        System.out.println("3.Add transaction for existing customer.");
        System.out.println("4.Show customer list (w/o transactions).");
        System.out.println("5.Show branch list.");
        System.out.println("6.Remove branch.");
        System.out.println("7.Remove customer.");
        System.out.println("9.Print available options.");
        System.out.println("0.Exit program.");
    }

    public static void addNewBranch() {
        System.out.print("Type the branch name you want to add:");
        String newBranchName = sc.nextLine();
        if (bank.addNewBranch(newBranchName)) {
            System.out.println("Branch " + newBranchName + " for the " + bank.getName() +
                    " bank was created successfully.");
        }
    }

    public static void addNewCustomer() {
        System.out.print("Type the new customer name:");
        String newCustomerName = sc.nextLine();
        System.out.print("Type initial amount for new customer:");
        double initialAmount = sc.nextDouble();
        sc.nextLine();
        System.out.print("Type branch you want to add this customer into:");
        String branchName = sc.nextLine();
        if (bank.addNewCustomer(branchName, newCustomerName, initialAmount)) {
            System.out.println("Customer " + newCustomerName + " has been added successfully to branch "
                    + branchName + ", with initial amount of: " + initialAmount + ".");
        }
    }

    public static void addTransactionToCustomer() {
        System.out.print("Type the customer name:");
        String customerName = sc.nextLine();
        System.out.print("Type transaction amount for customer:");
        double transactionAmount = sc.nextDouble();
        sc.nextLine();
        System.out.print("Type branch you want to add this customer into:");
        String branchName = sc.nextLine();
        if (bank.addCustomerTransaction(branchName, customerName, transactionAmount)) {
            System.out.println("Transaction on amount: " + transactionAmount +
                    " has been added succesfully for customer " + customerName +
                    " in branch " + branchName + ".");
        }
    }

    public static void showCustomerList() {
        System.out.print("Type the branch name which you want see customers for:");
        String branchName = sc.nextLine();
        System.out.print("Do you want also to see customers transactions? Type y/n");
        String transactions = sc.nextLine();

        boolean isTransactions;
        if (transactions.equalsIgnoreCase("y")) {
            isTransactions = true;
        } else {
            isTransactions = false;
        }

        bank.printCustomersList(branchName, isTransactions);
    }

    public static void showBranchList() {
        bank.printBranchList();
    }

    public static void removeCustomer() {
        System.out.print("Type the customer name:");
        String customerName = sc.nextLine();
        System.out.print("Type branch you want to remove this customer from:");
        String branchName = sc.nextLine();
        if (bank.removeCustomer(customerName, branchName)) {
            System.out.println("Customer " + customerName +
                    " has been succesffully removed from branch " + branchName);
        }
    }

    public static void removeBranch() {
        System.out.print("Type the branch name you want to remove:");
        String branchName = sc.nextLine();
        if (bank.removeBranch(branchName)) {
            System.out.println("Branch " + branchName + " has been removed successfully.");
        } else {
            System.out.println("Branch " + branchName + " doesn't exist.");
        }
    }

}