package app.Application.Services;

import app.Application.Classes.Building;
import app.Application.Interfaces.BuildingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Service
@Slf4j

public class BuildingService {
    @Autowired
    private final BuildingRepository buildingRepository;

    public BuildingService(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    public void addBuilding(Building building) {
        buildingRepository.save(building);
    }

    public List<Building> getBuildings() {
        return buildingRepository.findAll();
    }

    public void deleteBuilding(UUID id) {
        buildingRepository.deleteById(id);
    }

    public List<Building> getByType(String type) {
        return buildingRepository.findAllByType(type);
    }

    public List<Building> getByCreationDate(LocalDateTime creationDate) {
        return buildingRepository.findAllByCreationDate(creationDate);
    }
}
