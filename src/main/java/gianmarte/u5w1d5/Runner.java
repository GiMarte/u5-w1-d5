package gianmarte.u5w1d5;

import gianmarte.u5w1d5.entities.Building;
import gianmarte.u5w1d5.entities.User;
import gianmarte.u5w1d5.entities.Workstation;
import gianmarte.u5w1d5.enums.WorkstationType;
import gianmarte.u5w1d5.exceptions.NotFoundException;
import gianmarte.u5w1d5.exceptions.ValidationException;
import gianmarte.u5w1d5.repositories.BuildingRepository;
import gianmarte.u5w1d5.services.BuildingService;
import gianmarte.u5w1d5.services.UserService;
import gianmarte.u5w1d5.services.WorkstationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Runner implements CommandLineRunner {
    private final UserService userService;
    private final BuildingService buildingService;
    private final WorkstationService workstationService;

    @Autowired
    private BuildingRepository buildingRepository;

   public Runner(UserService userService, BuildingService buildingService, WorkstationService workstationService) {
    this.userService = userService;
    this.buildingService = buildingService;
    this.workstationService = workstationService;

}@Override public void run(String... args)throws Exception {
    try {
        User user1 = new User("giancarlo@gmail.com", "giglio", "carlo", "bananone69");
       // userService.saveUser(user1);
        Building build1 = new Building("Grand apartment", "Via John Fitzgerald kennedy", "Prague");
     //   buildingService.saveBuilding(build1);
        Workstation workstation1 = new Workstation("Postazione lavoro",WorkstationType.PRIVATE,5,buildingService.findByID(1));
        workstationService.saveWorkstation(workstation1);
    } catch (NotFoundException | ValidationException ex) {
            log.info(ex.getMessage());
    }
    }


}
