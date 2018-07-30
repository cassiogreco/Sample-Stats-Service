package domain.service;

import domain.model.Statistics;
import domain.model.Transaction;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class StatisticsServiceTest extends TestCase {
    public void testStatisticsAreCalculatedCorrectly() {
        List<Transaction> t = new ArrayList<>();
        t.add(new Transaction(10, 10));
        t.add(new Transaction(20, 10));
        t.add(new Transaction(30, 10));
        t.add(new Transaction(40, 10));
        StatisticsService service = new StatisticsService();

        Statistics stats = service.getStatsForTransactions(t);

        assert stats.getAverage() == 25;
        assert stats.getSum() == 100;
        assert stats.getMax() == 40;
        assert stats.getMin() == 10;
        assert stats.getCount() == 4;
    }
}
