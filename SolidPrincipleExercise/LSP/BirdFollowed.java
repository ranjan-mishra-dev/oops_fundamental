public class BirdFollowed {
    public static void main(String[] args) {
        Bird sparrow = new Sparrow();
        Bird peguin = new Peguin();

        sparrow.eat();
        Flyable sparrow2 = new Sparrow();
        sparrow2.fly();

        peguin.eat();
    }
}

/**
 
here if u see peguin not fly so instead of forcing behaviour of fly to it, we separate it.
 */

class Bird {
    public void eat() {
        System.out.println("All birds eats");
    }
}

interface Flyable {
    void fly();
}

class Peguin extends Bird {
    @Override
    public void eat() {
        System.out.println("Peguin eating currently...");
    }
}

class Sparrow extends Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("Sparrow flying in bly sky...");
    }

    @Override
    public void eat() {
        System.out.println("Sparrows are eating insects....");
    }
}

