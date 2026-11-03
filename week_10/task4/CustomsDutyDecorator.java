package week_10.task4;
public class CustomsDutyDecorator extends PricingDecorator {
    public CustomsDutyDecorator(PricingService service) {
        super(service);
    }
    @Override
    public double calculateTotal() {
        double x = p.calculateTotal();
        return x + 8.5;
    }
    @Override
    public String getReceiptBreakdown() {
        return p.getReceiptBreakdown() + " customs 8.5%";
    }
}
