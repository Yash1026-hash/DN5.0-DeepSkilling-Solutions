interface Coffee {
    String getDescription();
    int getCost();
}

class SimpleCoffee implements Coffee {

    @Override
    public String getDescription() {
        return "Simple Coffee";
    }

    @Override
    public int getCost() {
        return 100;
    }
}

class MilkDecorator implements Coffee {

    private Coffee coffee;

    public MilkDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Milk";
    }

    @Override
    public int getCost() {
        return coffee.getCost() + 20;
    }
}

public class Decorator {

    public static void main(String[] args) {

        Coffee coffee = new SimpleCoffee();

        coffee = new MilkDecorator(coffee);

        System.out.println(coffee.getDescription());
        System.out.println(coffee.getCost());
    }
}