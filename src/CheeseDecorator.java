public class CheeseDecorator extends PizzaDecorator {
    public CheeseDecorator(Pizza pizza) {
        super(pizza);

    }
    public double getPrice() {
        return pizza.getPrice() + 2;
    }
    public String getDescription() {
        return pizza.getDescription() + ", Cheese";
    }

}
