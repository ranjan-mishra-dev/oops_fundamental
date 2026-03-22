package SRP;
public class SRP_violated {
    public static void main(String[] args) {
        // System.out.println("ranjan");

        Report first = new Report();
        first.generateReport();
        first.savedToFile();
        first.sendEmail();
    }
}

class Report {
    public void generateReport() {
        System.out.println("Generating report...");
    }

    public void savedToFile() {
        System.out.println("Saving in file...");
    }

    public void sendEmail() {
        System.out.println("Sending notification on email...");
    }
}

/*

SRP rule: A class should have only ONE reason to change.
having multiple reasons to change — generation logic, storage logic, and communication logic are independent concerns.
Separating them improves maintainability, testability, and follows SRP.
----

problem i was facing which methods allow to keep in first cls. 
when CAN you keep method inside class?
If it does NOT introduce a new reason to change
----

*/