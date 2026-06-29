class Payments {
    public void Payment(){
        System.out.println("Payment is done");
    }
}

class CreditCard extends Payments {
    @Override
    public void Payment(){
        System.out.println("Payment is done with creditcard" );
    }
}

class UPI extends Payments {
    @Override
    public void Payment(){
        System.out.println("Payment is done with UPI");
    }
}

class Paypal extends Payments {
    @Override
    public void Payment(){
        System.out.println("Payments is done with paypal");
    }

}

public class OCP{
    public static void main(String args[]){
        Payments p = new CreditCard();
        Payments p1 = new UPI();
        Payments p2 = new Paypal();
        Payments p3 = new Netbanking();
        p.Payment();
        p1.Payment();
        p2.Payment();
        p3.Payment();
    }
}

class Netbanking extends Payments {
    @Override
    public void Payment(){
        System.out.println("Payments is done with netbanking");
    }
}