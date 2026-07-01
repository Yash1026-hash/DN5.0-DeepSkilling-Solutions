class Logger{
    static Logger logger = null;
    private Logger(){
        System.out.println("Logger instance created");
    }
    public static Logger getInstance(){
        if(logger == null){
            logger = new Logger();
        }
        return logger;
    }
    public void log(String message){
        System.out.println("Log message: " + message);
    }
    
}

public class SingletonExample {
    public static void main(String[] args){
        Logger l1 = Logger.getInstance();
        Logger l2 = Logger.getInstance();
        l1.log("Application Started");
        l2.log("User Logged in");
        System.out.println(l1 == l2);
    }
}