package app.Application.Controllers;

import app.Application.Classes.Address;
import app.Application.Classes.Building;
import app.Application.Services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping("/address")
    public void addAddress(@RequestBody Address address) {
        addressService.addAddress(address);
    }

    @GetMapping("/address")
    public List<Address> getAll() {
        return addressService.getAddress();
    }

    @DeleteMapping("/post/{id}")
    public void delete(@PathVariable UUID id) {
        addressService.deleteAddress(id);
    }

    @GetMapping(value = "/post/{id}/building")
    public @ResponseBody
    Building getGame(@PathVariable("id") UUID id) {
        return addressService.getBuildingByAddress(id);
    }
}
