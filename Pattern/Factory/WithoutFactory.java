public class WithoutFactory {
    public static void main(String[] args) {
        System.out.println("ranjan");

        Notification emailService = new Email();
        emailService.push();

        Notification smsService = new SMS();
        smsService.push();

    }    
}
/*Without a factory, object creation happens directly in the client (main method):
Problems:
Tight coupling 🔗
Hard to extend
Violates Open Closed Principle
*/


interface Notification {
    void push();
}

class Email implements Notification {
    @Override
    public void push() {
        System.out.println("this msg sent via email");
    }
}

class SMS implements Notification {
    @Override
    public void push() {
        System.out.println("this msg sent via SMS");
    }
}