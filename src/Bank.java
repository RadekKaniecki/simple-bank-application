import java.util.ArrayList;

public class Bank {
    private ArrayList<Branch> bank;
    private String name;

    public Bank(String name) {
        this.bank = new ArrayList<>();
        this.name = name;
    }

    public ArrayList<Branch> getBank() {
        return bank;
    }

    public String getName() {
        return name;
    }

    private boolean searchBranchName(String branchName) {
        for (int i = 0; i < bank.size(); i++) {
            if (bank.get(i).getName().equalsIgnoreCase(branchName)) {
                return true;
            }
        }
        return false;
    }

    private Branch getBranch(String branchName) {
        for (int i = 0; i < bank.size(); i++) {
            if (bank.get(i).getName().equalsIgnoreCase(branchName)) {
                return bank.get(i);
            }
        }
        return null;
    }

    private int getBranchIndex(String branchName) {
        for (int i = 0; i < bank.size(); i++) {
            if (bank.get(i).getName().equalsIgnoreCase(branchName)) {
                return i;
            }
        }
        return -1;
    }

    public boolean addNewBranch(String branchName) {
        if (searchBranchName(branchName)) {
            System.out.println("Branch " + branchName + " already exist.");
            return false;
        }
        bank.add(new Branch(branchName));
        return true;
    }

    public boolean addNewCustomer(String branchName, String customerName,
                                  double initialAmount) {
        Branch tempBranch = getBranch(branchName);
        if (tempBranch != null) {
            if (tempBranch.addNewCustomer(customerName, initialAmount)) {
                return true;
            }
            System.out.println("Customer " + customerName
                    + " is already created.");
            return false;
        }
        System.out.println("Branch " + branchName + " doesn't exist.");
        return false;
    }

    public boolean removeCustomer(String customerName, String branchName) {
        Branch tempBranch = getBranch(branchName);
        if (tempBranch != null) {
            if (tempBranch.removeCustomer(customerName)) {
                return true;
            } else {
                System.out.println("Cannot find customer " + customerName + ".");
                return false;
            }
        }
        System.out.println("Branch " + branchName + " doesnt't exist.");
        return false;
    }

    public boolean removeBranch(String branchName) {
        int branchIndex = getBranchIndex(branchName);
        if (branchIndex >= 0) {
            bank.remove(branchIndex);
            return true;
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName,
                                          String customerName, double transactionAmount) {
        Branch tempBranch = getBranch(branchName);
        if (tempBranch != null) {
            if (tempBranch.addTransaction(customerName, transactionAmount)) {
                return true;
            }
            System.out.println("Customer " + customerName + " doesn't exist.");
            return false;
        }
        System.out.println("Branch " + branchName + " doesn't exist.");
        return false;
    }

    public void printCustomersList(String branchName, boolean isTransaction) {
        Branch tempBranch = getBranch(branchName);
        if (tempBranch != null) {
            ArrayList<Customers> tempCustomersList = tempBranch.getBranchList();
            if (isTransaction) {
                for (int i = 0; i < tempCustomersList.size(); i++) {
                    System.out.println((i + 1) + "."
                            + tempCustomersList.get(i).getName());
                    ArrayList<Double> tempTransactions = tempCustomersList.get(
                            i).getTransactions();

                    for (int j = 0; j < tempTransactions.size(); j++) {
                        System.out.println(tempTransactions.get(j));
                    }
                    System.out.println();
                }
            } else {
                for (int i = 0; i < tempCustomersList.size(); i++) {
                    System.out.println((i + 1) + "."
                            + tempCustomersList.get(i).getName());
                }
            }
        } else {
            System.out.println("Branch " + branchName + " doesn't exist.");
        }
    }

    public void printBranchList() {
        for (int i = 0; i < bank.size(); i++) {
            System.out.println((i + 1) + "." + bank.get(i).getName());
        }
        System.out.println();
    }

}