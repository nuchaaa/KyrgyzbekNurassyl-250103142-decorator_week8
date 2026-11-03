package week_10.task4;
public abstract class PricingDecorator implements PricingService {
    PricingService p;
    public PricingDecorator(PricingService service) {
        p = service;
    }
    @Override
    public double calculateTotal() {
        return p.calculateTotal();
    }
    @Override
    public String getReceiptBreakdown() {
        return p.getReceiptBreakdown();
    }
}
