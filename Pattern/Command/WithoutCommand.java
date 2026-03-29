public class WithoutCommand {
    public static void main(String[] args) {
        System.out.println("ranjan");

        Light light = new Light();
        Fan fan = new Fan();

        RemoteControl rc = new RemoteControl(light, fan);

        rc.lightOn();
        rc.lightOff();
    }
}

//u can ask why interface not used when methods are same but what if it is AC, or fan with speed different appliance has different functionality you can have a sigle method to all
/*
why actually we need:
actually previously invoker directly call recevier to perform any particular action but just think instead of direct call that also violate OCP, SRP principle 
what if in this we introduce or encapsulate this req so that we can have better control over it, like doing undo/redo, queuing previously we do direct but now we have better control over it and
we can also chng action like currently this command doing A we can redirect to B.

so for this COMMAND PATTERN CAME TO EXISTENCE.

*/


class Light {
    
    void turnOn() {
        System.out.println("Light ON!");
    }

    void turnOff() {
        System.out.println("Light Off!");
    }

}

class Fan { 
    void turnOn() {
        System.out.println("Fan ON!");
    }

    void turnOff() {
        System.out.println("Fan Off!");
    }
}

class RemoteControl {
    private final Light light;
    private final Fan fan;

    public RemoteControl(Light light, Fan fan) {
        this.light = light;
        this.fan = fan;
    }

    public void lightOn() {
        light.turnOn();
    }

    public void lightOff() {
        light.turnOff();
    }

    public void fanOn() {
        fan.turnOn();
    }

    public void fanOff() {
        fan.turnOff();
    }
}

/*
Added By AI


*/