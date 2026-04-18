package SolidPrincipleExercise.SRP;

public class SRP_user_followed {
    public static void main(String[] args) {
        Validator validator = new Validator();
        Saver saver = new Saver();
        Notify notify = new Notify();

        UserService us = new UserService(validator, saver, notify);
        us.register("ranjan@gmail.com", "123456");
    }    
}

/*
during writing this code one question arise in my mind, why instance variable present outside  register not inside of it
ans:
* everytime u registering user that no of time object get created, not good in memory terms.
* unit testing: during unit testing you can use a fake cls to test wether its working later u will see DI concept.


*/


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
    private Validator validate;
    private Saver save;
    private Notify notificationService;

    public UserService(Validator validator, Saver saver, Notify notify) {
        validate = validator;
        save = saver;
        notificationService = notify;
    }

    public void register(String email, String password) {
        User user = new User(email, password);

        if (validate.check(user)) {
            save.fileSave(user);
            notificationService.sendWelcomeEmail(email);
        } else {
            System.out.println("Not a valid email!");
        }
    }
}

/*actually i was thinking this UserService cls following SRP but today i found if new db saver arrived, or new notification service arrived
i have to come again and do changes that shows i have more than 1 reason to change this cls, it's better to take it out from them */

class Validator {

    public boolean check(User user) {
         if (!user.getEmail().contains("@")) {
            System.out.println("Invalid email");
            return false;
        }

        if (user.getPassword().length() < 6) {
            System.out.println("Password must be at least 6 characters");
            return false;
        }

        return true;
    }
}

class Saver {
    public void fileSave(User user) {
        System.out.println("User with " + user.getEmail() + " saved successfully!");
    }
}

class Notify {
    public void sendWelcomeEmail(String email) {
        System.out.println("Notification sent on: " + email);
    }
}
