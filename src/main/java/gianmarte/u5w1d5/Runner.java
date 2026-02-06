package gianmarte.u5w1d5;

import gianmarte.u5w1d5.entities.Building;
import gianmarte.u5w1d5.entities.User;
import gianmarte.u5w1d5.services.BuildingService;
import gianmarte.u5w1d5.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    private final UserService userService;
    private final BuildingService buildingService;

   public Runner(UserService userService, BuildingService buildingService) {
    this.userService = userService;
    this.buildingService = buildingService;

}@Override public void run(String... args)throws Exception {

        User user1 = new User("giancarlo@gmail.com", "giglio", "carlo", "bananone69");
       // userService.saveUser(user1);
        Building build1 = new Building("Grand apartment", "Via John Fitzgerald kennedy", "Prague");
        buildingService.saveBuilding(build1);
    }
}
