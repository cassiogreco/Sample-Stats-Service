package configuration;

import application.StatsService;
import application.TransactionService;
import domain.repository.TransactionRepository;
import domain.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.*;

@Configuration
@Import({RepositoryConfiguration.class})
public class ServiceConfiguration {
    @Autowired
    private TransactionRepository transactionRepository;

    private StatisticsService statisticsService() {
        return new StatisticsService();
    }

    @Bean
    public StatsService statsService() {
        return new StatsService(transactionRepository, this.statisticsService());
    }

    @Bean
    public TransactionService transactionService() {
        return new TransactionService(transactionRepository);
    }
}
