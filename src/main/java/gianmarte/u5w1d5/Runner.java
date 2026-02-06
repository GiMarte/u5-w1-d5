package gianmarte.u5w1d5;

import gianmarte.u5w1d5.entities.Building;
import gianmarte.u5w1d5.entities.Reservation;
import gianmarte.u5w1d5.entities.User;
import gianmarte.u5w1d5.entities.Workstation;
import gianmarte.u5w1d5.enums.WorkstationType;
import gianmarte.u5w1d5.exceptions.NotFoundException;
import gianmarte.u5w1d5.exceptions.ValidationException;
import gianmarte.u5w1d5.repositories.BuildingRepository;
import gianmarte.u5w1d5.repositories.UserRepository;
import gianmarte.u5w1d5.services.BuildingService;
import gianmarte.u5w1d5.services.ReservationService;
import gianmarte.u5w1d5.services.UserService;
import gianmarte.u5w1d5.services.WorkstationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Slf4j
@Component
public class Runner implements CommandLineRunner {
    private final UserService userService;
    private final BuildingService buildingService;
    private final WorkstationService workstationService;
    private final ReservationService reservationService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BuildingRepository buildingRepository;



   public Runner(UserService userService, BuildingService buildingService, WorkstationService workstationService, ReservationService reservationService) {
    this.userService = userService;
    this.buildingService = buildingService;
    this.workstationService = workstationService;
    this.reservationService = reservationService;

}@Override public void run(String... args)throws Exception {
    try {
        User user1 = new User("lucapesto@hotmail.it", "pesto", "luca", "pestilu");
        //userService.saveUser(user1);
        Building build1 = new Building("Grandioso office", "Via Matteotti", "Barcelona");
       // buildingService.saveBuilding(build1);
        Workstation workstation1 = new Workstation("Postazione lavoro",WorkstationType.PRIVATE,10,buildingService.findByID(2));
       // workstationService.saveWorkstation(workstation1);
        Reservation res1 = new Reservation(LocalDate.now(),userService.findByID(3),workstationService.findByID(1));
        reservationService.saveReservation(res1);

    } catch (NotFoundException | ValidationException ex) {
            log.info(ex.getMessage());
    }
    }


}
