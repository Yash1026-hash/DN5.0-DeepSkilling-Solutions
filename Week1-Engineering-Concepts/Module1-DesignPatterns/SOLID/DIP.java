interface Messageservice {
    void sendMessage();

}

class EmailService implements Messageservice{

    @Override
    public void sendMessage(){
        System.out.println("Email is sent");
    }
}
class SMS implements Messageservice{
    @Override
    public void sendMessage(){
        System.out.println("SMS is sent");
    }
}
class notification{
    private Messageservice service;
    public notification(Messageservice service){
        this.service = service;
    }
    public void notifyUser(){
        service.sendMessage();
    }
}
public class DIP{
    public static void main(String args []){
        Messageservice service = new EmailService();
        notification notify = new notification(service);
        notify.notifyUser();
        Messageservice service1 = new SMS();
        notification notify1 = new notification(service1);
        notify1.notifyUser();
    }
}