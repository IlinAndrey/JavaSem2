package app.Application.Services;

import app.Application.Classes.Building;
import app.Application.Interfaces.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BuildingService {
    @Autowired
    private final BuildingRepository buildingRepository;

    public BuildingService(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    public void addBuilding(Building building) {
        buildingRepository.save(building);
    }

    public List<Building> getBuilding() {
        return buildingRepository.findAll();
    }

    public void deleteBuilding(UUID id) {
        buildingRepository.deleteById(id);
    }

    public List<Building> getByType(String firstName) {
        return buildingRepository.findAllByType(firstName);
    }

    public List<Building> getByCreationDate(String lastName) {
        return buildingRepository.findAllByCreationDate(lastName);
    }
}
