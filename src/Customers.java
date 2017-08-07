import java.util.ArrayList;

public class Customers {
    private ArrayList<Double> transactionList;
    private String name;

    public Customers(String name, double initialAmount) {
        this.transactionList = new ArrayList<>();
        this.name = name;
        this.transactionList.add(initialAmount);
    }

    public ArrayList<Double> getTransactions() {
        return transactionList;
    }

    public String getName() {
        return name;
    }

    public void addTransaction(double amount) {
        transactionList.add(amount);
    }
}