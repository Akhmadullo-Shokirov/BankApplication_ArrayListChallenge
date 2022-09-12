import java.util.Scanner;

public class Main {

    private final static Scanner scanner = new Scanner(System.in);
    static Bank IngBank = new Bank("Fake Bank");
    public static void main(String[] args) {

        boolean quit =false;
        printActions();
        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0 -> {
                    System.out.println("Closing...");
                    quit = true;
                }
                case 1 -> addNewBranch();
                case 2 -> addCustomer();
                case 3 -> addCustomerTransaction();
                case 4 -> listCustomers();
                case 5 -> printActions();
            }
        }
    }

    private static void printActions() {
        System.out.println("\nAvailable actions:\nPress:");
        System.out.println("""
                0 - to stop application
                1 - to add a new branch
                2 - to add a customer
                3 - to make a transaction
                4 - to print list of all customers
                5 - to print list of available actions""");
        System.out.println("Choose your action:");
    }

    private static void addNewBranch() {
        System.out.println("Please enter a new branch name:");
        String branchName = scanner.nextLine();
        if(IngBank.newBranch(branchName)) {
            IngBank.newBranch(branchName);
            System.out.println("New branch " + branchName + " added successfully.");
        } else {
            System.out.println("There is already a branch with name " + branchName);
        }
    }

    private static void addCustomer() {
        System.out.println("Enter branch name: ");
        String branchName = scanner.nextLine();
        System.out.println("Enter customer name: ");
        String customerName = scanner.nextLine();
        System.out.println("Enter initial amount: ");
        double initialAmount = scanner.nextDouble();
        if(IngBank.addCustomer(customerName, branchName, initialAmount)) {
            System.out.println("New customer added successfully");
        } else {
            System.out.println("Unable to add new customer. Please check branch name or customer name");
        }
    }

    private static void addCustomerTransaction() {
        System.out.println("Enter branch name: ");
        String branchName = scanner.nextLine();
        System.out.println("Enter customer name: ");
        String customerName = scanner.nextLine();
        System.out.println("Enter transaction amount: ");
        double amount = scanner.nextDouble();
        if(IngBank.addCustomerTransaction(branchName, customerName, amount)) {
            System.out.println("Amount " + amount + " was transferred successfully to " + customerName + " at branch " + branchName);
        } else {
            System.out.println("Unable to make a transaction. Please check branch name or customer name");
        }
    }

    private static void listCustomers() {
        System.out.println("Please enter a branch name:");
        String branchName = scanner.nextLine();
        System.out.println("Do you need a list of transactions also? (Yes or No) :");
        String showTransactionsValue = scanner.nextLine();
        boolean showTransactions;
        showTransactions = showTransactionsValue.equalsIgnoreCase("yes");
        IngBank.listCustomers(branchName, showTransactions);
    }
}
