public class BirdViolated {
    public static void main(String[] args) {
        System.out.println("ranjan");

        Bird sparrow = new Sparrow();
        Bird peguin = new Peguin();

        sparrow.fly();
        peguin.fly();
    }
}

/**
 i was thinking when u have to follow LSP principle then in that case u just have to make sure that child replacing parent successfully
 but i was wrong LSP ensure also that don't force subcls to implement methods they don't support 
 */

class Bird {
    void fly() {
        System.out.println("Birds are flying...");
    }
}

class Peguin extends Bird{
    @Override
    void fly() {
        throw new UnsupportedOperationException();
    }
}

class Sparrow extends Bird {
    @Override
    void fly() {
        System.out.println("Sparrows are flying...");
    }
}