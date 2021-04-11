package app.Application.Controllers;

import app.Application.Classes.Building;
import app.Application.Services.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class BuildingController {
    @Autowired
    private BuildingService buildingService;

    @PostMapping("/building")
    public void addBuilding(@RequestBody Building building) {
        buildingService.addBuilding(building);
    }

    @GetMapping("/building")
    public List<Building> getAll() {
        return buildingService.getBuilding();
    }

    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable UUID id) {
        buildingService.deleteBuilding(id);
    }

    @GetMapping("/getBuildingByType/{type}")
    public List<Building> getByType(@PathVariable String type){
        return buildingService.getByType(type);
    }

    @GetMapping("/getBuildingByCreationDate/{creationDate}")
    public List<Building> getByCreationDate(@PathVariable String creationDate){
        return buildingService.getByCreationDate(creationDate);
    }
}
