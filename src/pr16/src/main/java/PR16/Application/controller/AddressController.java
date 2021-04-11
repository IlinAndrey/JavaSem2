package PR16.Application.controller;

import PR16.Application.model.Address;
import PR16.Application.service.AddressService;
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
        return addressService.getAddresses();
    }

    @GetMapping("/address/{id}")
    public List<Address> getAddress(@PathVariable UUID id) {
        return addressService.getAddress(id);
    }

    @DeleteMapping("/address/{id}")
    public void deleteAddress(@PathVariable UUID id) {
        addressService.deleteAddress(id);
    }
}
