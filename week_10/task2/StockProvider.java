package week_10.task2;
public interface StockProvider {
    double getMarketPrice(String ticker);
    String getStatus(String ticker);
}
