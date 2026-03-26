
import java.util.ArrayList;
import java.util.List;

public class Observer2 {

    public static void main(String[] args) {
        System.out.println("ranjan");
        StockPrice market = new StockPrice();

        Observer o1 = new EmailObserver();
        Observer o2 = new SMSObserver();

        market.addObserver(o1);
        market.addObserver(o2);

        market.setPrice(500);

        System.out.println("-----------");

        Observer o3 = new EmailObserver();
        market.addObserver(o3);
        market.setPrice(1000);
    }
}

interface Stock {

    void addObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObserver();
}

interface Observer {

    void update(int price);
}

class EmailObserver implements Observer {

    @Override
    public void update(int price) {
        System.out.println("Email: stock price updated to " + price);
    }
}

class SMSObserver implements Observer {

    @Override
    public void update(int price) {
        System.out.println("SMS: stock price updated to " + price);
    }
}

class StockPrice implements Stock {

    private final List<Observer> observersList = new ArrayList<>();
    // final bcz to avoid lost of  current observer, denying re-assign new ArrayList<>();
    private int price;

    @Override
    public void removeObserver(Observer o) {
        observersList.remove(o);
    }

    @Override
    public void addObserver(Observer o) {
        if (o != null && !observersList.contains(o)) {
            observersList.add(o);
        }
    }

    public void setPrice(int price) {
        this.price = price;
        notifyObserver();
    }

    @Override
    public void notifyObserver() {
        for (Observer o : observersList) {
            o.update(price);
        }
    }
}

/*
what problem this solve,

before observer how we were solving this problem?
actually before we used direct call and tight coupling means subject need to know everything like send email, push, sms notification
and everything is hardcoded, violate OCP for new type of notification, no dynamic behavior like user want only sms or email but it send in all manner
hard to test, can't test email independently

but with this subject only know just say notify() and dynamically acc. to observer their medium, notification delviered.
Before Observer, we manually called dependent services; Observer automates this using a publish-subscribe mechanism.

 */


/*
Added by AI

Observer Pattern defines a one-to-many dependency where when one object (Subject) changes state, all its dependents (Observers) are notified automatically.

Core Components
1. Subject (Publisher) attach(), detach(), notify()
Holds list of observers
Notifies them
2. Observer (Subscriber) update()
Gets updates

Feature         Description
LLD Category    Behavioral Pattern
Relationship    One-to-Many (Subject to Observers)
Communication   Push-based (Subject pushes to Observers)
Main Advantag   Eliminates Polling and reduces coupling
*/
