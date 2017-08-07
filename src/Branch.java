import java.util.ArrayList;

public class Branch {
    private ArrayList<Customers> branchList;
    private String name;

    public Branch(String name) {
        this.branchList = new ArrayList<>();
        this.name = name;
    }

    public ArrayList<Customers> getBranchList() {
        return branchList;
    }

    public String getName() {
        return name;
    }

    private boolean searchCustomerName(String customerName) {
        for (int i = 0; i < branchList.size(); i++) {
            if (branchList.get(i).getName().equalsIgnoreCase(customerName)) {
                return true;
            }
        }
        return false;
    }

    private Customers getCustomer(String customerName) {
        for (int i = 0; i < branchList.size(); i++) {
            if (branchList.get(i).getName().equalsIgnoreCase(customerName)) {
                return branchList.get(i);
            }
        }
        return null;
    }

    private int getCustomerIndex(String customerName) {
        for (int i = 0; i < branchList.size(); i++) {
            if (branchList.get(i).getName().equalsIgnoreCase(customerName)) {
                return i;
            }
        }
        return -1;
    }

    public boolean addNewCustomer(String customerName, double initialAmount) {
        if (searchCustomerName(customerName)) {
            return false;
        }
        branchList.add(new Customers(customerName, initialAmount));
        return true;
    }

    public boolean removeCustomer(String customerName) {
        int customerIndex = getCustomerIndex(customerName);
        if (customerIndex >= 0) {
            branchList.remove(customerIndex);
            return true;
        }
        return false;
    }

    public boolean addTransaction(String customerName, double transactionAmount) {
        Customers tempCustomer = getCustomer(customerName);
        if (tempCustomer != null) {
            tempCustomer.addTransaction(transactionAmount);
            return true;
        }
        return false;
    }

}