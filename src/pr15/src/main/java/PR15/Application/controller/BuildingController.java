package PR15.Application.controller;

import PR15.Application.model.Building;
import PR15.Application.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class BuildingController {
    @Autowired
    private BuildingService buildingService;

    @PostMapping("/building")
    public void addUser(@RequestBody Building building) {
        buildingService.addBuilding(building);
    }

    @GetMapping("/building")
    public List<Building> getBuilding() {
        return buildingService.getBuilding();
    }

    @GetMapping("/building/{id}")
    public Building getBuilding(@PathVariable UUID id) {
        return buildingService.getBuilding(id);
    }

    @DeleteMapping("/building/{id}")
    public void deleteBuilding(@PathVariable UUID id) {
        buildingService.deleteBuilding(id);
    }
}
