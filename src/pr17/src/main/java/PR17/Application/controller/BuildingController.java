package PR17.Application.controller;

import PR17.Application.service.BuildingService;
import PR17.Application.model.Building;


import PR17.Application.model.Address;
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

    @GetMapping("/buildings")
    public List<Building> getAll() {
        return buildingService.getBuilding();
    }

    @GetMapping("/getPFilteredByType")
    public List<Building> getFilteredByType(){
        return buildingService.getByType();
    }

    @GetMapping("/getPFilteredByYear")
    public List<Building> getFilteredByDate(){
        return buildingService.getByDate();
    }

    @DeleteMapping("/building/{id}")
    public void deleteBuilding(@PathVariable UUID id) {
        buildingService.deleteBuilding(id);
    }

    @GetMapping(value = "/building/{id}/address")
    public @ResponseBody
    Address getAddress(@PathVariable("id") UUID id){
        return buildingService.getAddress(id);
    }


}
