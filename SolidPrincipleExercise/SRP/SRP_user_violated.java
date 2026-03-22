package SRP;
public class SRP_user_violated {
    public static void main(String[] args) {
        // System.out.println("ranjan");

        User u1 = new User("ranjan@gmail.com", "123456");
        UserService user_service = new UserService();
        user_service.register(u1);
        

    }
}

class User {
    private String email;
    private String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    
}

class UserService {

    public void register(User user) {
        String email = user.getEmail();

        if (!email.contains("@")) {
            System.out.println("Invalid email");
            return;
        }
        

        System.out.println("saving to database");
        System.out.println("sending welcome email");
    }
}

/**
 this class contains 3 responsibilites register, saving to db and sending email, means 3 resason to change but SRP say only 1, means SRP again violated.
 it means i have to put all 3 in different cls so that each class has one reason to change and fulfill only its own logic.
 
 avoid god class, they are real devil :)
  
 */