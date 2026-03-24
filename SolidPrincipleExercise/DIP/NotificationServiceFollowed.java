public class NotificationServiceFollowed {
    public static void main(String[] args) {
        Notification email = new EmailService();
        NotificationService service1 = new NotificationService(email);
        service1.notifyUser("hii i am ranjan");

        Notification sms = new SMSService();
        NotificationService service2 = new NotificationService(sms);
        service2.notifyUser("hii i am ranjan again");
    }
}

class NotificationService {
    private final Notification notification;

    public NotificationService(Notification notification) {
        this.notification = notification;
    }

    public void notifyUser(String msg) {
        notification.sendMsg(msg);
    }
}

interface Notification {
    void sendMsg(String msg);
}

class EmailService implements Notification {
    @Override
    public void sendMsg(String msg) {
        System.out.println("Email is sending ur msg: " + msg);
    }
}

class SMSService implements Notification {
    @Override
    public void sendMsg(String msg) {
        System.out.println("SMS is sending ur msg: " + msg);
    }
}

/*
vs code suggest to put final keyword at notification field i was like why then i found once the object created we don't want to reassign until object destroy thats why
final, use this when you have a value that should never change while the program is running.
*/

/*
Added by AI

"I use final to enforce immutability.
 It ensures that the dependency is properly initialized at construction time and prevents accidental re-assignment, making the class more robust and thread-safe."

DIP says:
Inject dependency from outside

final ensures:
Once injected → never modified
Strong, stable design


Why use(final) it for Dependencies (Like our DIP example)?
private final MessageService messageService;

Safety: It ensures the NotificationService always has a sender. It can't be null halfway through.
Constructor Guard: Java forces you to initialize it in the constructor. If you forget, the code won't compile.
Performance: The JVM can optimize final variables better because it knows they will never change.
 */