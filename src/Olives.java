public class Olives extends PizzaDecorator {
    public Olives(Pizza p) {
        super(p);
    }

    public double getPrice() {
        return pizza.getPrice() + 1;
    }
    public String getDescription() {
        return pizza.getDescription() + ", Olives";
    }
}
