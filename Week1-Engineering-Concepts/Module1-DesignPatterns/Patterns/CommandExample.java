interface Command {
    void execute();
}

class TV {

    public void turnOn() {
        System.out.println("TV is ON");
    }

}

class TurnOnCommand implements Command {

    private TV tv;

    public TurnOnCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.turnOn();
    }

}

class Remote {

    private Command command;

    public Remote(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }

}

public class CommandExample {

    public static void main(String[] args) {

        TV tv = new TV();

        Command command = new TurnOnCommand(tv);

        Remote remote = new Remote(command);

        remote.pressButton();

    }

}