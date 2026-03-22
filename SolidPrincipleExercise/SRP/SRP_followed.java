package SolidPrincipleExercise.SRP;
public class SRP_followed {
    public static void main(String[] args) {
        // System.out.println("ranjan");

        ReportGenerator rg = new ReportGenerator();
        rg.generateReport();

        ReportSaver rs = new ReportSaver();
        rs.savedToFile();

        ReportNotification rn = new ReportNotification();
        rn.sendEmail();
    }
}

class ReportGenerator {
    public void generateReport() {
        System.out.println("Generating report.");
    }
}

class ReportSaver {
    public void savedToFile() {
        System.out.println("report saving in file.");
    }
}

class ReportNotification {
    public void sendEmail() {
        System.out.println("Sending email notification.");
    }
}