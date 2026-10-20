public class Cheese extends PizzaDecorator {
    public Cheese(Pizza pizza) {
        super(pizza);

    }
    public double getPrice() {
        return pizza.getPrice() + 2;
    }
    public String getDescription() {
        return pizza.getDescription() + ", Cheese";
    }

}
