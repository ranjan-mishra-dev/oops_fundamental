public class WithCommand {
    public static void main(String[] args) {

        Light light = new Light();
        Fan fan = new Fan();

        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        Command fanOn = new FanOnCommand(fan);
        Command fanOff = new FanOffCommand(fan);

        RemoteControl remote = new RemoteControl(3);

        remote.setCommand(0, lightOn, lightOff);
        remote.setCommand(1, fanOn, fanOff);

        remote.pressOn(0);   
        remote.pressOff(0);  
        remote.pressUndo();  
    }
}


class RemoteControl {
    private Command[] onCommands;
    private Command[] offCommands;
    private Command lastCommand;

    RemoteControl(int slots) {
        onCommands = new Command[slots];
        offCommands = new Command[slots];
    }

    void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    void pressOn(int slot) {
        onCommands[slot].execute();
        lastCommand = onCommands[slot];
    }

    void pressOff(int slot) {
        offCommands[slot].execute();
        lastCommand = offCommands[slot];
    }

    void pressUndo() {
        if (lastCommand != null) {
            lastCommand.undo();
        }
    }
}

interface Command {
    void execute();
    void undo();
}

class Light {
    void turnOn() {
        System.out.println("Light On");
    }

    void turnOff() {
        System.out.println("Light Off");
    }
}

class Fan {
    void start() {
        System.out.println("Fan start");
    }

    void stop() {
        System.out.println("Fan stop");
    }
}

class LightOnCommand implements Command {
    private Light light;

    LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
    
    public void undo() {
        light.turnOff();
    }
}

class LightOffCommand implements Command {
    private Light light;
    
    LightOffCommand(Light light) {
        this.light = light;
    }
    
    @Override
    public void execute() {
        light.turnOff();
    }

    public void undo() {
        light.turnOn();
    }
}

class FanOnCommand implements Command {
    private Fan fan;

    FanOnCommand(Fan fan) {
        this.fan = fan;
    }

    public void execute() {
        fan.start();
    }

    public void undo() {
        fan.stop();
    }
}

class FanOffCommand implements Command {
    private Fan fan;

    FanOffCommand(Fan fan) {
        this.fan = fan;
    }

    public void execute() {
        fan.stop();
    }

    public void undo() {
        fan.start();
    }
}

/*
see WithoutCommand.java file then read this

Added By AI

Why we need Command Pattern?
problem without it
Tight coupling:
button -> directly calls Light.turnOn()
If tomorrow:

Add Fan
Add AC
Add Undo
Add Logging

Code explodes with if-else

With Command Pattern
Decouples Invoker ↔ Receiver
Makes system extensible


When to Use?

Use Command Pattern when:

1. You want to decouple sender & receiver
UI → Business logic
Button → Action
2. You need Undo / Redo
Store commands in stack
3. You want queue / scheduling
Tasks, jobs, background workers
4. You want logging / replay
Store command history and replay later


| Problem                | Solution                     |
| ---------------------- | ---------------------------- |
| Tight coupling         | Command acts as middle layer |
| Hard to extend actions | Add new command class        |
| No undo support        | Store commands               |
| No flexibility         | Commands are interchangeable |


Core Components:
Command Interface: Usually defines a simple execute() method.
Concrete Command: Implements execute() by calling the specific action on the Receiver.
Receiver: The "brain" that knows how to perform the actual work (e.g., a Light or Document object).
Invoker: Holds the command and triggers it (e.g., a RemoteControl or Button).
Client: Creates the Concrete Command and assigns the Receiver to it.


Use Strategy if you need to switch between different versions of the same logic (like different sorting algorithms).
Use Command if you need to treat an action like an object (to save it, undo it, or put it in a background queue).
*/