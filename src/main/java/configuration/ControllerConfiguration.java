package configuration;

import application.StatsService;
import application.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import presentation.StatsController;
import presentation.TransactionController;
import org.springframework.context.annotation.*;

@Configuration
@Import({ServiceConfiguration.class})
public class ControllerConfiguration {
    @Autowired
    private TransactionService transactionService;

    @Autowired
    private StatsService statsService;

    @Bean
    public TransactionController transactionController() {
        return new TransactionController(transactionService);
    }

    @Bean
    public StatsController statsController() {

        return new StatsController(statsService);
    }
}
