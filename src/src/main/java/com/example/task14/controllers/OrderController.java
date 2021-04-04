package com.example.task14.controllers;


import com.example.task14.models.Building;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class OrderController {
    ArrayList<Building> buildings = new ArrayList<>();
    @PostMapping("/building/create")
    public String createOrder(@RequestBody Building building){
        buildings.add(building);
        building.setType(buildings.size());
        return buildings.toString();
    }

    @GetMapping("/building")
    public String allOrders(){
        return buildings.toString();
    }

    @DeleteMapping("/orders/{type}")
    public String deleteOrder(@PathVariable("type") int type){
        buildings.removeIf(o -> o.getType() == type);
        return buildings.toString();
    }
}
