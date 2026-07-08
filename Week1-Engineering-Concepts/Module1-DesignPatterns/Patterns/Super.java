class Faculty{
    String name = "Yash";
}
class AssistantProfessor extends Faculty{
    
    String name = "Rohit";
    void display(){
        System.out.println("parent name is: "+super.name);
        System.out.println("child name is: "+name);
        
    }
}
class associateProfessor extends Faculty{
    
    String name = "Rohit";
    void display(){
        System.out.println("parent name is: "+super.name);
    
        
    }
}
public class Super {
    public static void main(String[] args) {
        AssistantProfessor ap = new AssistantProfessor();
        ap.display();
        associateProfessor as = new associateProfessor();
        as.display();
    }
}