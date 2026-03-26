import java.util.*;

public class OrderTrackingSystem {
    public static void main(String[] args) {
        System.out.println("ranjan");

        OrderSystem mumbai = new OrderSystem();

        Observer o1 = new EmailService(true);
        Observer o2 = new SMSService(true);
        Observer warehouse = new WarehouseService();
        Observer analytic = new AnalyticLogService();

        mumbai.addObserver(o1);
        mumbai.addObserver(o2);
        mumbai.addObserver(warehouse);
        mumbai.addObserver(analytic);

        int orderId = 123;
        String status = "PLACED";
        mumbai.setOrderStatus(status, orderId);

        Observer o3 = new SMSService(false);
        status = "SHIPPED";
        mumbai.setOrderStatus(status, orderId);
    }
}


interface Observer {
    void update(int orderId, String status);
}

class EmailService implements Observer {
    
    private boolean enabled;
    public EmailService(boolean enabled) {
        this.enabled = enabled;
    }
    
    
    @Override
    public void update(int orderId, String status) {
        if (enabled)
            System.out.println("Email: order " + orderId + " status updated to " + status);
    }
}

class SMSService implements Observer {
    
    private boolean enabled;
    public SMSService(boolean enabled) {
        this.enabled = enabled;
    }
    
    @Override
    public void update(int orderId, String status) {
        if (enabled)
            System.out.println("SMS: order " + orderId + " status updated to " + status);
    }
}

class WarehouseService implements Observer {
    
    @Override
    public void update(int orderId, String status) {
        System.out.println("Warehouse: order " + orderId + " status updated to " + status);
    }
}

class AnalyticLogService implements Observer {
    
    @Override
    public void update(int orderId, String status) {
        System.out.println("Analytic Log: order " + orderId + " status updated to " + status);
    }
}

interface Order {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyToObserver();
}

class OrderSystem implements Order {
    private final List<Observer> list = new ArrayList<>();
    private int orderId;
    private String orderStatus;


    @Override
    public void addObserver(Observer o) {
        list.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        list.remove(o);
    }

    @Override
    public void notifyToObserver() {
        for (Observer o: list)
            o.update(orderId, orderStatus);
    }

    public void setOrderStatus(String status, int orderId) {
        this.orderId = orderId;
        this.orderStatus = status;

        notifyToObserver();
    }
}

