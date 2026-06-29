class Employee{
    public void work(){
        System.out.println("Emplyee Wworking");
    }
}

class Manager extends Employee{
    @Override
    public void work(){
        System.out.println("Manager is managing team");
    }
}

class Devops extends Employee{
    @Override
    public void work(){
        System.out.println("Devops is writing code");
    }
}

public class LSP {
    public static void main(String args[]){
        Employee e = new Manager();
        Employee e1 = new Devops();
        e.work();
        e1.work();
    }
}