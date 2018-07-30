package configuration;

import domain.repository.TransactionRepository;
import infrastructure.repository.InMemoryTransactionRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.*;

@Configuration
public class RepositoryConfiguration {
    @Bean
    public TransactionRepository transactionRepository() {
        return new InMemoryTransactionRepository();
    }
}
