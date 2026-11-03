package week_10.task4;
public class CurrencyOrderAdapter implements PricingService {
    LegacyForeignOrder a;
    LegacyCurrencyConverter b;
    String c;
    public CurrencyOrderAdapter(LegacyForeignOrder order, LegacyCurrencyConverter converter, String targetCurrency) {
        a = order;
        b = converter;
        c = targetCurrency;
    }
    @Override
    public double calculateTotal() {
        return b.convert(a.money, "GBP", c);
    }
    @Override
    public String getReceiptBreakdown() {
        return "Order " + a.id + " price " + calculateTotal() + " " + c;
    }
}
