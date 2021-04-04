package com.example.task14.controllers;


import com.example.task14.models.Address;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ItemController {
    ArrayList<Address> addresses = new ArrayList<>();
    @PostMapping("/address/code")
    public String createItem(@RequestBody Address address){
        addresses.add(address);
        address.setId(addresses.size());
        return addresses.toString();
    }

    @GetMapping("/address")
    public String allItems(){
        return addresses.toString();
    }

    @DeleteMapping("/address/{zip_id}")
    public String deleteItem(@PathVariable("zip_id") int zip_id){
        addresses.removeIf(o -> o.getId() == zip_id);
        return addresses.toString();
    }
}
