interface Observer {

    void update(int price);

}

class MobileApp implements Observer {

    @Override
    public void update(int price) {
        System.out.println("Mobile App: Stock Price = " + price);
    }

}

class EmailAlert implements Observer {

    @Override
    public void update(int price) {
        System.out.println("Email Alert: Stock Price = " + price);
    }

}

class Stock {

    private int price;

    private Observer observer1;
    private Observer observer2;

    public void addObserver(Observer observer1, Observer observer2) {
        this.observer1 = observer1;
        this.observer2 = observer2;
    }

    public void notifyObservers() {
        observer1.update(price);
        observer2.update(price);
    }

    public void setPrice(int price) {
        this.price = price;
        notifyObservers();
    }

}

public class Observercode {

    public static void main(String[] args) {

        Stock stock = new Stock();

        MobileApp mobile = new MobileApp();
        EmailAlert email = new EmailAlert();

        stock.addObserver(mobile, email);

        stock.setPrice(500);

    }

}