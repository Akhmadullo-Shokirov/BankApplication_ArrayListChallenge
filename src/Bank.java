import java.util.ArrayList;

public class Bank {

    private String name;
    private final ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches =  new ArrayList<>();
    }

    public boolean newBranch(String branchName) {
        if(findBranch(branchName) == null) {
            this.branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String customerName, String branchName, double initialAmount) {
        Branch branch = findBranch(branchName);
        if(branch != null) {
            return branch.newCustomer(customerName, initialAmount);
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double amount) {
        Branch branch = findBranch(branchName);
        if(branch != null) {
            return branch.addCustomerTransaction(customerName, amount);
        }
        return false;
    }

    private Branch findBranch(String branchName) {
        for(Branch checkedBranch : this.branches) {
            if(checkedBranch.getName().equals(branchName)) {
                return checkedBranch;
            }
        }
        return null;
    }

    public boolean listCustomers(String branchName, boolean showTransactions) {
        Branch branch = findBranch(branchName);
        if(branch != null) {
            System.out.println("Customer details for branch " + branch.getName());
            ArrayList<Customer> branchCustomers = branch.getCustomers();
            for(Customer customer : branchCustomers) {
                System.out.println("Customer: " + "[" + (branchCustomers.indexOf(customer) + 1) + "] " + customer.getName());
                if(showTransactions) {
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = customer.getTransactions();
                    for(Double transaction : transactions) {
                        System.out.println("[" + (transactions.indexOf(transaction)) + "] Amount " + transaction);
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
