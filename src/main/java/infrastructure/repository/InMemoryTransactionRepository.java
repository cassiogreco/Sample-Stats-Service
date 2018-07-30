package infrastructure.repository;

import domain.model.Transaction;
import domain.repository.TransactionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryTransactionRepository implements TransactionRepository {
    private List<Transaction> transactions;

    public InMemoryTransactionRepository() {
        this.transactions = new ArrayList<>();
    }

    public void Save(Transaction t) {
        this.transactions.add(t);
    }

    public List<Transaction> Get() {
        return this.transactions;
    }

    public List<Transaction> GetForTimestampLimit(long limit) {
        return this.transactions.stream().filter(t -> System.currentTimeMillis() - t.getTimestamp() <= limit).collect(Collectors.toList());
    }
}
