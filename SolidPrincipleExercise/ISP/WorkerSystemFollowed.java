public class WorkerSystemFollowed {
    public static void main(String[] args) {
        System.out.println("ranjan");
        // HumanWorker human = new HumanWorker(); //professional people coding to an interface, bcz it is tight coupling not good for scalable sys.
        Workable human = new HumanWorker();
        human.work();

        Eatable human2 = (Eatable) human;
        human2.eat();
    }
}


interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

class HumanWorker implements Workable, Eatable {

    @Override
    public void work() {
        System.out.println("Humans are working plz stop them :)");
    }
    
    @Override
    public void eat() {
        System.out.println("Human are eating pls say them eat mindfully.");
    }
}

class RobotWorker implements Workable {
    @Override
    public void work() {
        System.out.println("Robots are working plz don't stop them :)");
    }
    
}