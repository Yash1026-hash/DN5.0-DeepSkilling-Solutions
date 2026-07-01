interface BankAccount{
    void accessAccount();
}
class RealBankAccount implements BankAccount{
    @Override
    public void accessAccount() {
        System.out.println("Access Granted to Bank Account");
    }
}
class BankProxy implements BankAccount {
    private RealBankAccount account;
    private boolean authenticated;

    public BankProxy(boolean authenticated) {

        this.authenticated = authenticated;

        account = new RealBankAccount();

    }

    @Override

    public void accessAccount() {

        if (authenticated) {

            account.accessAccount();

        } else {

            System.out.println("Access Denied");

        }

    }

}

class Proxy {

    public static void main(String[] args) {

        BankAccount user1 = new BankProxy(true);

        user1.accessAccount();

        BankAccount user2 = new BankProxy(false);

        user2.accessAccount();

    }

}