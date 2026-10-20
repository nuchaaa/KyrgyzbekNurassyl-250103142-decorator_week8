public class Main {
    public static void main(String[] args) {
        Pizza pizza = new PlainPizza();
        pizza = new Cheese(pizza);
        pizza = new Olives(pizza);
        pizza = new Pineapple(pizza);
        System.out.println(pizza.getDescription());
        System.out.println("Total cost:" + pizza.getPrice());
    }
}