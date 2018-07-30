package application;

import domain.model.Transaction;
import domain.repository.TransactionRepository;
import presentation.TransactionInput;

public class TransactionService {
    private TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository repo) {
        this.transactionRepository = repo;
    }

    public void SaveTransaction(TransactionInput input) {
        this.transactionRepository.Save(new Transaction(input.getAmount(), input.getTimestamp()));
    }
}
