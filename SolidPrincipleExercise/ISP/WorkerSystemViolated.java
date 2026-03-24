public class WorkerSystemViolated {
    public static void main(String[] args) {
        System.out.println("ranjan");

        Worker human = new HumanWorker();
        human.eat();
        
        Worker robo = new RobotWorker();
        robo.eat();
    }
}

/*
whats wrong in this when things are working
ISP says: Clients should not be forced to depend on methods they do not use or avoid create fat interface
what problem here is robotworker cls doesn't need eat method but robot cls is forced to implement

and this is problem ISP say, if don't need then better is so segregate the interface.
*/


interface Worker {
    void eat();
    void work();
}

class HumanWorker implements Worker {
    @Override
    public void eat() {
        System.out.println("human workers are currently eating...");
    }

    @Override
    public void work() {
        System.out.println("Human workers are currently working...");
    }
}

class RobotWorker implements Worker {
    @Override
    public void eat() {
        System.out.println("robot are eating but what :)");
    }

    @Override
    public void work() {
        System.out.println("Robot workers are ready to work...");
    }
}