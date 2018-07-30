package domain.repository;

import domain.model.Transaction;

import java.util.List;

public interface TransactionRepository {
    void Save(Transaction t);
    List<Transaction> Get();
    List<Transaction> GetForTimestampLimit(long limit);
}
