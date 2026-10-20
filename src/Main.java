public class Main {
    public static void main(String[] args) {
        Pizza pizza = new PlainPizza();
        pizza = new CheeseDecorator(pizza);
        pizza = new OlivesDecorator(pizza);
        pizza = new PineappleDecorator(pizza);
        System.out.println(pizza.getDescription());
        System.out.println("Total cost:" + pizza.getPrice());
    }
}