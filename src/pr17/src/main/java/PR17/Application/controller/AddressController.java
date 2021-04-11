package PR17.Application.controller;

import PR17.Application.model.Address;
import PR17.Application.service.AddressService;
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

    @GetMapping("/addresses")
    public List<Address> getAddresses() {
        return addressService.getAddress();
    }

    @GetMapping("/addresses/{id}")
    public Address getAddress(@PathVariable UUID id) {
        return addressService.getAddress(id);
    }

    @GetMapping("/getMFilteredByName")
    public List<Address> getFilteredByName(){
        return addressService.getByName();
    }

    @GetMapping("/getMFilteredByAddress")
    public List<Address> getFilteredByAddress(){
        return addressService.getByAddress();
    }

    @DeleteMapping("/addresses/{id}")
    public void deleteManufacture(@PathVariable UUID id) {
        addressService.deleteManufacture(id);
    }
}
