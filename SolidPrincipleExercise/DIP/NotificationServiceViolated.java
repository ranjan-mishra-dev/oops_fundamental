
public class NotificationServiceViolated {
    public static void main(String[] args) {
        NotificationService emailService = new NotificationService();
        emailService.notifyUser();
    }
}

class NotificationService {
    EmailService email = new EmailService();

    public void notifyUser() {
        email.sendMsg();
    }
}

class EmailService {
    public void sendMsg() {
        System.out.println("This msg send via email");
    }
}

/*
when i saw this principle then i thought it is same as ISP but then found
ISP: main motive is to avoid fat interface and Clients should not be forced to depend/implement on methods they do not use
DIP[Dependency Inversion principle]: avoid tight coupling, depond upon abstraction not concretions.


problem in above cls implementation is:  high module cls(Notificationservice) tightly bind with Email service(low module) this tight coupling is not good
what if tomorrow i have to shif from email to sms service then in that case OCP rule get break

so we are going to make loosely couple using interface
 */

/*
Added by AI

DIP:
High-level modules should NOT depend on low-level modules
Both should depend on abstractions

Simple: Don’t depend on concrete classes → depend on interfaces

High-Level Module: Contains business logic / decision-making

Defines WHAT the system should do | Doesn’t care about implementation details

This is high-level
Because: It decides when to notify | It controls application flow

Low-Level Module: Contains implementation details

Defines HOW things are done

This is low-level
Because: It handles how message is sent
*/