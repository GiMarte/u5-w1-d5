package gianmarte.u5w1d5;

import gianmarte.u5w1d5.entities.User;
import gianmarte.u5w1d5.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    private final UserService userService;

    public Runner(UserService userService) {
        this.userService = userService;
    }

    @Override public void run(String... args)throws Exception {

        User user1 = new User("giancarlo@gmail.com", "giglio", "carlo", "bananone69");
        userService.saveUser(user1);
    }
}
