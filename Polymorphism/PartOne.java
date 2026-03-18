public class PartOne {
    public static void main(String[] args) {
        Animal a1 = new Dog();
        a1.eat();
        // a1.bark(); comile error

        /*

        Why does the Compiler do this?
        The compiler is like a strict security guard. It only looks at the declaration (Animal a1). It says:
        "You told me myDog is an Animal. I have checked the Animal class, and there is no bark() method there. I cannot guarantee that every Animal can bark (what if it's a Fish?), so I won't let you call this."
        The compiler plays it safe to prevent a Runtime Crash.

        solution: downcasting
        */

        University ranjan = new CSE("@cse123");
        ranjan.display();

        FileService f1 = new FileService();
        f1.save("mehujiaan.png");
        f1.save("mehujiaan.png", "/me/hu/sabse/taaktwar", true);


    }
}


//overloading
class FileService {

    public void save(String content) {
        System.out.println("We got your content");
    }

    public void save(String content, String path, boolean encrypt) {
        save(content, path);
        if (encrypt) {
            System.out.println("Encrypting...");
        } else {
            System.out.println("Chal naa bhai");
        }
    }
    
    private void save(String content, String path) {
        System.out.println("Content is: " + content + " path u provided: " + path);
    }

}

//overriding
class University {
    protected String id;

    public University(String id) {
        this.id = id;
    }

    void display() {
        System.out.println("I am from university with: " + id);
    }
}

class CSE extends University {

    public CSE (String id) {
        super(id);
    }

    @Override
    void display() {
        System.out.println("I am from CSE with: " + id);
    }
}

class Animal {

    void eat() {
        System.out.println("Animal is eating...");
    }
}

class Dog extends Animal {
    @Override
    void eat() {
        System.out.println("Dog is eating...");
    }

    void bark() {
        System.out.println("Dog bark");
    }
}

/** */

/**
 by AI
 Poly (many) and Morph (forms)

 The Two Types of Polymorphism
There are two distinct ways polymorphism manifests in Java:

A. Compile-Time Polymorphism (Static Binding)
This is achieved through Method Overloading. The compiler knows exactly which method to execute at the time you compile your code based on the method signature (parameters).

Example: A Printer class with print(String text) and print(int number).
Why "Static"? The "binding" between the method call and the method body happens before the program even runs[during compilation it link and its bytecode generate and excute at runtime].

B. Runtime Polymorphism (Dynamic Binding)
This is achieved through Method Overriding. This is the core of LLD. Here, a call to an overridden method is resolved at runtime rather than compile-time.

Example: A Shape reference pointing to a Circle object. When you call shape.draw(), Java waits until the program is running to see that the actual object is a Circle and runs the circle's version of draw().

Upcasting: 
Animal myDog = new Dog(); // Upcasting [Why do this? It allows you to write code that works with the general type (Animal) but behaves according to the specific type (Dog).]

for runtime polymorphism:
Inheritance is Required: You cannot have overriding without a Parent-Child relationship.

Method Signature must match: The name, return type, and parameters must be identical.
The "Reference" vs "Object" Rule: * The Reference Type (the left side) determines what methods you can call.

The Object Type (the right side) determines which version of the method actually runs.
Wit's Warning: If the Dog class has a special method bark(), but your reference is Animal myDog, you cannot call myDog.bark(). The compiler only sees the Animal part of the dog!


overloading u can do without inheritance but overriding need inheritance
in overloading:
The only thing that truly matters for overloading is the Method Signature (Name + Parameters). The access modifier (public, private, etc.) is not part of the signature.

what if method and paremter same but return is different: u get error
The Dilemma: The compiler sees the name (calculate) and the parameters (int, int). It has two matches. Even though the return types are different, the compiler doesn't know if you want the int result or the String result because you aren't even storing it in a variable!
Because of this ambiguity, Java forbids overloading based on return type.
 */