public class PartOne {
    public static void main(String[] args) {
        
      BankAcount lunch_baad = new BankAcount();
      lunch_baad.setBalance(100);
      lunch_baad.getBalance(1000);
      lunch_baad.getBalance(10);
    }
}

class BankAcount {
  private double balance;

  public void setBalance(double amount) {
    if (amount > 0) {
      balance += amount;
      System.out.println("Deposited successfully !");
    } else
      System.out.println("Invalid amount !");
  }

  public void getBalance(double amount) {
    if (amount > 0 && amount <= balance) {
      balance -= amount;
      System.out.println("Withdrawn successfully " + amount + " !");
    } else
      System.out.println("Go earn first !");
  }


}


/**
  encapsulation: protect internal data of an object from outside access.
  encap. achieved using:
  Private → Data hiding
Getter/Setter → Controlled access

without encapsulation: anyone can change data, it needed bcz
data security, data validation, maintainability, controlled access
 */

/**
  access modifier:

private: most restrictive level. Entities marked as private are accessible only within the same class.
default (no modifier): Often called Package-Private. If you don't specify a keyword, the entity is accessible only to classes within the same package.
protected: Accessible within the same package AND by subclasses (even if they are in different packages).
public: The least restrictive level. Accessible from anywhere in the project.

 */
