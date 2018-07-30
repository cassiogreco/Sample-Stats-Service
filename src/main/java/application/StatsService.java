package application;

import domain.model.Statistics;
import domain.model.Transaction;
import domain.repository.TransactionRepository;
import domain.service.StatisticsService;
import presentation.Stats;

import java.util.List;

public class StatsService {
    private TransactionRepository transactionRepository;
    private StatisticsService statisticsService;

    public StatsService(TransactionRepository repo, StatisticsService statisticsService) {
        this.transactionRepository = repo;
        this.statisticsService = statisticsService;
    }

    public Stats getStats() {
        List<Transaction> t = this.transactionRepository.GetForTimestampLimit(60 * 1000);
        return convertToStats(this.statisticsService.getStatsForTransactions(t));
    }

    private Stats convertToStats(Statistics s) {
        return new Stats(s.getSum(), s.getAverage(), s.getMax(), s.getMin(), s.getCount());
    }
}
