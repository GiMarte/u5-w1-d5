package gianmarte.u5w1d5.services;

import gianmarte.u5w1d5.entities.Workstation;
import gianmarte.u5w1d5.exceptions.NotFoundException;
import gianmarte.u5w1d5.exceptions.ValidationException;
import gianmarte.u5w1d5.repositories.WorkstationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WorkstationService {
    private final WorkstationRepository workstationRepository;

    @Autowired
    public WorkstationService(WorkstationRepository workstationRepository) {
        this.workstationRepository = workstationRepository;
    }


    public void saveWorkstation(Workstation workstation) {
        if(workstationRepository.existsByBuildingAndDescription(workstation.getBuilding(),workstation.getDescription())) throw new ValidationException("Edificio gia esistente");
        workstationRepository.save(workstation);
        log.info("Postazione salvata correttamente");
    }

    public Workstation findByID(long id) {
        return workstationRepository.findById(id).orElseThrow(() -> new NotFoundException("Workstation non trovata"));
    }

}
