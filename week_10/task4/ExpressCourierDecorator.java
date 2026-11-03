package week_10.task4;
public class ExpressCourierDecorator extends PricingDecorator {
    public ExpressCourierDecorator(PricingService service) {
        super(service);
    }
    @Override
    public double calculateTotal() {
        return p.calculateTotal() + 15;
    }
    @Override
    public String getReceiptBreakdown() {
        return p.getReceiptBreakdown() + " express 15";
    }
}
