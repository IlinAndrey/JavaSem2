package PR16.Application.controller;

import PR16.Application.model.Address;
import PR16.Application.model.Building;
import PR16.Application.service.BuildingService;
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
    public List<Building> getBuilding() {
        return buildingService.getBuilding();
    }

    @PostMapping("/addressbuilding/{id}")
    public void addBuilding(@PathVariable UUID id, @RequestBody String text) {
        buildingService.addBuilding(id, new Address(text));
    }

    @DeleteMapping("/addressbuilding/{id}")
    public void deleteBuilding(@PathVariable UUID id, Address address) {
        buildingService.removeBuilding(id, address);
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
