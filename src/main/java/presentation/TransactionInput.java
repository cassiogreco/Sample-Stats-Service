package presentation;

public class TransactionInput {
    long timestamp;
    double amount;

    public TransactionInput(double a, long t) {
        this.timestamp = t;
        this.amount = a;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public double getAmount() {
        return this.amount;
    }
}
