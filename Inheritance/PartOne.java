
class PartOne {
    public static void main(String[] args) {
        // System.out.println("ranjan");
        // Payment p1 = new Upi(1000, 4321);
        // p1.displayRecipt();

        Device d1 = new SmartPhone();
        // output both parent first then child constructor called | bcz child can't exist without parent thats why



    }
}


class Payment {
    protected  double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public void displayRecipt() {
        System.out.println("Payment ₹ " + amount + " in your account.");
    }
}

class Upi extends Payment{
    private int id;

    Upi (double amount, int id) {
        super(amount);
        this.id = id;
    }

    @Override
    public void displayRecipt() {
        System.out.println("Upi Rs." + amount + " in your account.");
    }
}

// see hidden super method call

class Device {
    Device() {
        System.out.println("1. Device (Parent) constructor called");
    }
}

class SmartPhone extends Device {
    
    SmartPhone() {
        System.out.println("2. SmartPhone (Child) constructor called");

    }
    
}

/**

what if parent cls is public -> then child inheriting then parent class var/method in child class become public still public, protected still protected private u can't acccess
what if parent cls is private -> then child inheriting then parent class var/method in child class become public become private, protected become private, private u can't acccess
what if parent cls is private -> then child inheriting then parent class var/method in child class become public become protected, protected become protected, private u can't acccess
 jis type se inherit karte ho, public and protected wahi ban jataa h


 what to put in parent cls as field: If every child class needs the data, put it in the parent. If there is a rule that applies to all types, the parent should own the field and the logic.
 Generalize in the Parent, Specialize in the Child.

Inheritance is the mechanism that allows one class (the subclass or child) to acquire the properties and behaviors of another class (the superclass or parent).

It represents an "IS-A" relationship. For example, a Dog is-a Animal, and a SavingsAccount is-a BankAccount.

Why use Inheritance in LLD?
Code Reusability: You write common logic once in the parent class.
Method Overriding: You can provide a specific implementation for a method that is already defined in the parent (Polymorphism).
Standardization: It ensures all child classes follow a specific "base" structure.

 */

/**
 by AI
 Types of Inheritance in Java
Java supports three main types of class-based inheritance:

Single Inheritance: One child inherits from one parent.
Example: Class B extends Class A

Multilevel Inheritance: A child class acts as a parent for another class.
Example: Class C extends Class B, and Class B extends Class A. (Think: Grandparent -> Parent -> Child).
Hierarchical Inheritance: Multiple child classes inherit from one single parent.
Example: Class B extends Class A AND Class C extends Class A.
Note on Multiple Inheritance: Java does not support multiple inheritance with classes (e.g., Class C extends A, B is invalid). This prevents the "Diamond Problem" where the compiler wouldn't know which parent's method to use. We use Interfaces to bypass this.

3. The super Keyword
The super keyword is your direct line to the parent class. You’ll use it in two main ways:

super(): Calls the parent’s constructor. This must be the first line in the child’s constructor.
super.methodName(): Calls a method from the parent class that you might have overridden in the child.

4. Method Overriding (Runtime Polymorphism)
This is where the power of inheritance shines. A child class can provide a specific implementation for a method already defined in its parent.

Rules for Overriding:

The method name and parameters must be identical.
The return type must be the same (or a subtype).
Access Modifier: The child’s method cannot be more restrictive than the parent's. 

Use @Override: Always use the annotation. It tells the compiler to check if you actually matched the parent's method signature.


Critical Rules to Remember
The First Line Rule: A call to this() or super() must be the very first statement in a constructor. You cannot do work and then call the parent.
No Loops: You cannot have recursive chaining (e.g., Constructor A calls B, and B calls A). The compiler will stop you.
One or the Other: You cannot use both this() and super() in the same constructor. Why? Because both want to be the first line! (Note: If you use this(), it eventually leads to a constructor that calls super()).
 
Constructor chaining:
Use this() to call another constructor in the same class. This is great for providing default values without duplicating code.
calling parent cls constructor: Use super when you want to reach "up" into the parent class.

by super.method_name you can access parent cls methods

Constructor Overloading is a technique where a class has more than one constructor, each with a different parameter list.


The Rules of Overloading
For constructors to be overloaded, they must differ in their signature:
Number of parameters (e.g., one vs. two).
Data types of parameters (e.g., int vs. String).
Order of parameters (e.g., String, int vs. int, String).

*/