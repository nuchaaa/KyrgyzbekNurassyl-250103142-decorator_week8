package week_10.task4;
public class LegacyForeignOrder {
    String id;
    double money;
    public LegacyForeignOrder(String orderId, double gbpAmount) {
        id = orderId;
        money = gbpAmount;
    }
    public String getOrderId() {
        return id;
    }
    public double getGbpAmount() {
        return money;
    }
}
