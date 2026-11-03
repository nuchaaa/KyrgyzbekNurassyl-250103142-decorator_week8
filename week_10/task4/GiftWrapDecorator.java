package week_10.task4;
public class GiftWrapDecorator extends PricingDecorator {
    public GiftWrapDecorator(PricingService service) {
        super(service);
    }
    @Override
    public double calculateTotal() {
        return p.calculateTotal() + 5;
    }
    @Override
    public String getReceiptBreakdown() {
        return p.getReceiptBreakdown() + " gift wrap 5";
    }
}
