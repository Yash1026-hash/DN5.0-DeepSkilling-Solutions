interface printer{
    void print();
}

class laserprinter implements printer{
    @Override
    public void print(){
        System.out.println("printing with laser printer");
    }
}

class inkjetprinter implements printer{
    @Override
    public void print(){
        System.out.println("printing with inkjet printer");
    }
}

public class ISP{
    public static void main(String args[]){
        printer p = new laserprinter();
        printer p1 = new inkjetprinter();
        p.print();
        p1.print();
    }
}