package week_10.task4;
public class LegacyCurrencyConverter {
    public double convert(double amount, String from, String to) {
        if (from.equals("GBP") && to.equals("USD")) return amount / 1.25;
        return amount;
    }
}
