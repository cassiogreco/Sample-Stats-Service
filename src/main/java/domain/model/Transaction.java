package domain.model;

public class Transaction {
    double amount;
    long timestamp;

    public Transaction(double a, long t) {
        this.amount = a;
        this.timestamp = t;
    }

    public double getAmount() {
        return this.amount;
    }

    public long getTimestamp() {
        return this.timestamp;
    }
}
