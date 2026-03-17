class PartOne {
    public static void main(String[] args) {
        // System.out.println("ranjan mishra");
        
        Car c1 = new Car();
        c1.start();

        Notification email_not = new EmailNotification();
        email_not.send();

        Notification sms_not = new SMSNotification();
        sms_not.send();
    
        Notification push_not = new PushNotification();
        push_not.send();

        Animal dogesh = new Dog();
        dogesh.eat();
        dogesh.run();

        
    }
}


//abstraction using interface
interface Notification {
    void send();
}

class EmailNotification implements Notification {
    @Override
    public void send() {
        System.out.println("Sending email notifi...");
    }
}

class SMSNotification implements Notification {
    @Override
    public void send() {
        System.out.println("Sending sms notifi...");
    }
}

class PushNotification implements Notification {
    @Override
    public void send() {
        System.out.println("Sending push notifi...");
    }
}


// abstraction using abstract class
abstract class Animal {
    void eat() {
        System.out.println("I am eating, come back later");
    }

    abstract void run();
}

class Dog extends Animal {
    @Override
    void run() {
        System.out.println("Why should i run, theif is also human");
    }
}


// partial abstraction [implementation is fixed, we can modified in another cls]
class Car {
    public void start() {
        checkFuel();
        startMotor();
    }
//here we are like using start() enjoy to functions but if we make method public then user can misue the system, because we want he should follow a sequence but
// he can start from a btwn, security breach problem here, thats why we kept private.

    private void checkFuel() {
        System.out.println("Checking fuel...");
    }

    private void startMotor() {
        System.out.println("Motor starting...");
    }
}

/** Abstraction means hiding uncessary details from client and showing only what necessary for client.
like we have 10 functions, and 9 functions helping 1 functions, showing their is no sense to make visible all 9 to user,
we want to give access to that 1 function that actually user need, here we use abstaction.

But u can ask by making all 9 function private we can make left 1 public that will also work correct, but its called partial abstraction means
these 9 functions cannot called by users everything is hidden, and main methods still contains implementation, the logic is already written inside the class,
by making method private, now if you try to override in subclass, not possible. You cannot force subclass to implement their own version.

 */


/** 
So to solve partial implementation problem beacuse each subclass can has its own implementation, that why we use Abstract class and Interface.

*/

/**

when to use abstraction?

abstraction is needed to reduce complexity and hide implementation deatils. instead of exposing everything, we expose only what the user needs.
just think in your stripe a user is able to access
payment.validateCard();
payment.checkBalance();
payment.deductMoney();
payment.generateReceipt();

not great for company and why we allow user to access internal/security things when he only need
payment.pay();

so abstraction say user take what things need you to do your work and leave everything secret,
abstraction also helps in scalabilitiy of code

 */

/** 
  when to use abstrction:

  1. you want to hide complex logic
  2. when multiple implementations are possible like in payment system may be credit card, upi, paypal, net banking
  all perform payment but logic is different
  3. when you want a common contract like each subclass doing different implementation but purpose/action is same.
*/

/**

how i will goint to think about abstraction implementation
1. will there be multiple implmentation of this behavior: like notifcation common behavior but type can be email, sms, push notifi. THEN ABSTRACTION IS NEEDED
2. will new types be added in future, abstraction helps in future scalability.

 */


/**
 coding naunace
 
 if in interface you write method like void send() so java automatically treat is as public + abstract + your_declaration
  interface method visibility must be public in implementation class, you cannot reduce the visibility of an inheirted method.
  if you don't write then:
Compiler error: attempting to assign weaker access privileges; was public

Because:
interface method → public
class method → default
Default is less visible than public, which is not allowed.

private < default < protected < public

  Methods inside an interface are implicitly public and abstract, so when implementing them in a class, they must be declared public to maintain the same visibility level.
 */

  /**
   so when we have interface to implement abstraction then why we need asbtract class
   
   both for abstraction but:
   interface: it define a contract, it only tells what must be done, not how it is done.
   abstract cls: partially implemented class means a concrete method share among all its child
   'simple trick: ' multiple implmentation & cehavior: interface, shared code btwn classes & parent child hierarchy: abstract ls
    
   Interface defines a contract for behavior, while an abstract class provides a base class with shared functionality.
   */

/**
    in abstract class:
    This works because:

    Parent method access = default
    Child method access = default

    Java rule:
    The child method cannot reduce visibility, but it can keep the same or increase it. 
     
*/