package domain.service;

import domain.model.Statistics;
import domain.model.Transaction;

import java.util.List;

public class StatisticsService {

    public StatisticsService() { }

    public Statistics getStatsForTransactions(List<Transaction> t) {
        return this.getStats(t);
    }

    private Statistics getStats(List<Transaction> t) {
        return new Statistics(this.getSum(t), this.getAverage(t), this.getMax(t), this.getMin(t), this.getCount(t));
    }

    private double getMax(List<Transaction> transactions) {
        double max = Double.NEGATIVE_INFINITY;
        for (Transaction t : transactions) {
            if (t.getAmount() > max) {
                max = t.getAmount();
            }
        }

        return max;
    }

    private double getSum(List<Transaction> transactions) {
        double sum = 0;
        for (Transaction t : transactions) {
            sum += t.getAmount();
        }

        return sum;
    }

    private double getMin(List<Transaction> transactions) {
        double max = Double.POSITIVE_INFINITY;
        for (Transaction t : transactions) {
            if (t.getAmount() < max) {
                max = t.getAmount();
            }
        }

        return max;
    }

    private double getCount(List<Transaction> t) {
        return t.size();
    }

    private double getAverage(List<Transaction> t) {
        return this.getSum(t) / this.getCount(t);
    }
}
