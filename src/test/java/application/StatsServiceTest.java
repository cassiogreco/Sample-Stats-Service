package application;

import domain.model.Statistics;
import domain.model.Transaction;
import domain.repository.TransactionRepository;
import domain.service.StatisticsService;
import junit.framework.TestCase;
import presentation.Stats;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class StatsServiceTest extends TestCase {
    public void testShouldGetStatistics() {
        StatisticsService statisticsService = mock(StatisticsService.class);
        TransactionRepository transactionRepository = mock(TransactionRepository.class);
        List<Transaction> transactions = listOfTransactions();
        when(transactionRepository.GetForTimestampLimit(60 * 1000)).thenReturn(transactions);
        when(statisticsService.getStatsForTransactions(transactions)).thenReturn(statistics());
        StatsService statsService = new StatsService(transactionRepository, statisticsService);

        Stats s = statsService.getStats();

        assert s.getAverage() == 10;
        assert s.getSum() == 10;
        assert s.getMin() == 10;
        assert s.getMax() == 10;
        assert s.getCount() == 1;
    }

    private List<Transaction> listOfTransactions() {
        List<Transaction> t = new ArrayList<>();
        t.add(new Transaction(10, 10));
        t.add(new Transaction(20, 10));
        t.add(new Transaction(30, 10));
        t.add(new Transaction(40, 10));
        return t;
    }

    private Statistics statistics() {
        return new Statistics(10, 10, 10, 10, 1);
    }
}
