public class Singleton {
    public static void main(String[] args) {
        System.out.println("ranjan");

        Practice p1 = Practice.getInsteance();
        Practice p2 = Practice.getInsteance();
    
        if (p1 == p2) {
            System.out.println("both are same object");
        } else {
            System.out.println("both are different objects");
        }

    }    
}

class Practice {

    private static Practice instance;
    private Practice () {};

    public static  Practice getInsteance() {
        if (instance == null)
            instance = new Practice();
    
        return instance;
    }
}

/*
Ensures a class has only one instance and provides a global access point to it.
famous use is DB connection we don't want for same db connection multiple time new object get create and db connection compute power increase, we keep it global, single
but it is not thread safe so we made it using locks

A Singleton must have:

Private constructor: prevent new
Static instance variable: to access without obj creation
Public method to access instance: similar to getter method
*/