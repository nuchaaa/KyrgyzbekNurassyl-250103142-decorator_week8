public class Pineapple extends PizzaDecorator{
    public Pineapple(Pizza newPizza) {
        super(newPizza);

    }
    public double getPrice() {
        return pizza.getPrice() + 1.5;
    }
    public String getDescription() {
        return pizza.getDescription() + ", Pineapple";
    }
}
