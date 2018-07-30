package application;

import domain.repository.TransactionRepository;
import junit.framework.TestCase;
import presentation.TransactionInput;

import static org.mockito.Mockito.*;

public class TransactionServiceTest extends TestCase {
    public void testShouldSaveATransaction() {
        TransactionRepository transactionRepository = mock(TransactionRepository.class);
        TransactionService transactionService = new TransactionService(transactionRepository);
        TransactionInput ti = new TransactionInput(10, 10);

        transactionService.SaveTransaction(ti);
    }
}
