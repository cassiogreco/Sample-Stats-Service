package presentation;

public class Stats {
    double sum;
    double avg;
    double max;
    double min;
    double count;

    public Stats(double sum, double avg, double max, double min, double count) {
        this.sum = sum;
        this.avg = avg;
        this.max = max;
        this.min = min;
        this.count = count;
    }

    public double getSum() {
        return this.sum;
    }

    public double getAverage() {
        return this.avg;
    }

    public double getMin() {
        return this.min;
    }

    public double getMax() {
        return this.max;
    }

    public double getCount() {
        return this.count;
    }
}
