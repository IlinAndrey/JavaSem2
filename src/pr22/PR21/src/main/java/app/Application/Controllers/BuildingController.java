package app.Application.Controllers;

import app.Application.Classes.Building;
import app.Application.EmailService;
import app.Application.Services.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
public class BuildingController {
    @Autowired
    private BuildingService buildingService;

    @Autowired
    private EmailService mail;

    @PostMapping("/buildings")
    public void addUser(@RequestBody Building building) {
        buildingService.addBuilding(building);
    }

    @GetMapping("/buildings")
    public List<Building> getAll() {
        return buildingService.getBuildings();
    }

    @DeleteMapping("/building/{id}")
    public void delete(@PathVariable UUID id) {
        buildingService.deleteBuilding(id);
    }

    @GetMapping("/getBuildingByType/{type}")
    public List<Building> getByType(@PathVariable String type){
        return buildingService.getByType(type);
    }

    @GetMapping("/getBuildingByCreationDate/{creationDate}")
    public List<Building> getByCreationDate(@PathVariable LocalDateTime creationDate){
        return buildingService.getByCreationDate(creationDate);
    }
}
