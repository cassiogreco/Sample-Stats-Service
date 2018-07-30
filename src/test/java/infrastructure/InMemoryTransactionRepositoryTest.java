package infrastructure;

import domain.model.Transaction;
import domain.repository.TransactionRepository;
import infrastructure.repository.InMemoryTransactionRepository;
import junit.framework.TestCase;

import java.util.List;

public class InMemoryTransactionRepositoryTest extends TestCase {
    public void testSave() {
        TransactionRepository repo = new InMemoryTransactionRepository();
        Transaction t = new Transaction(10, 10);

        repo.Save(t);

        assert repo.Get().size() == 1;
    }

    public void testGet() {
        TransactionRepository repo = new InMemoryTransactionRepository();
        Transaction t = new Transaction(10, 10);
        repo.Save(t);
        repo.Save(t);

        List<Transaction> transactions = repo.Get();

        assert transactions.size() == 2;
        assert transactions.get(1).getAmount() == 10;
    }

    public void testGetForTimestampLimit() {
        TransactionRepository repo = new InMemoryTransactionRepository();
        long currentTimestamp = System.currentTimeMillis();
        Transaction t = new Transaction(10, currentTimestamp - (20 * 1000));
        Transaction t2 = new Transaction(20, currentTimestamp - (100 * 1000));
        repo.Save(t);
        repo.Save(t2);

        List<Transaction> transactions = repo.GetForTimestampLimit(60 * 1000);

        assert transactions.size() == 1;
        assert transactions.get(0).getAmount() == 10;
    }
}
