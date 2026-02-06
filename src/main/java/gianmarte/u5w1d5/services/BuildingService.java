package gianmarte.u5w1d5.services;

import gianmarte.u5w1d5.entities.Building;
import gianmarte.u5w1d5.exceptions.NotFoundException;
import gianmarte.u5w1d5.exceptions.ValidationException;
import gianmarte.u5w1d5.repositories.BuildingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BuildingService {
    private final BuildingRepository buildiongRepository;

    @Autowired
    public BuildingService(BuildingRepository buildiongRepository) {
    this.buildiongRepository = buildiongRepository;
}

    public void saveBuilding(Building building) {
        if (buildiongRepository.existsByName(building.getName())) throw new ValidationException("Edificio gia esistente");
        this.buildiongRepository.save(building);
        log.info("L'edificio e' stato salvato correttamente");
    }

    public Building findByID(long id) {
        return buildiongRepository.findById(id).orElseThrow(() -> new NotFoundException("ID non trovato"));
    }


}
