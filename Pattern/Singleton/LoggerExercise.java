public class LoggerExercise {
    public static void main(String[] args) {
        System.out.println("ranjan");

        Logger logger1 = Logger.getInstance();
        logger1.log("payment started");

        Logger logger2 = Logger.getInstance();
        logger2.log("payment completed");

        if (logger1 == logger2) {
            System.out.println("Both objects are same");
        } else {
            System.out.println("both are not same");
        }
    }
}


class Logger {
    private static Logger instance;

    private Logger() {
        if (instance != null) {
            throw new RuntimeException("use getInstance() method");
        }

        System.out.println("logger intialized");
    }

    public static Logger getInstance() {
        
        if (instance == null) {
            synchronized (Logger.class) {
             if (instance == null)   
                instance = new Logger();
            }
        }
        return instance;
    }

    public void log(String msg) {
        System.out.println("[LOG]: " + msg);
    }
}