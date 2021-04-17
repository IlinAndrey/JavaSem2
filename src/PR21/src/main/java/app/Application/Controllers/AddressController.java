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

    @GetMapping("/addresses")
    public List<Address> getAll() {
        return addressService.getAddress();
    }

    @DeleteMapping("/address/{id}")
    public void delete(@PathVariable UUID id) {
        addressService.deleteAddress(id);
    }

    @GetMapping("/getAddressesByAddressText/{addressText}")
    public List<Address> getFilteredByAddressText(@PathVariable String addressText){
        return addressService.getByAddressText(addressText); }

    @GetMapping("/getByAddress/{address}")
    public List<Address> getFilteredByAddress(@PathVariable String address){
        return addressService.getByAddress(address); }


    @GetMapping(value = "/address/{id}/building")
    public @ResponseBody
    Building getAddress(@PathVariable("id") UUID id) {
        return addressService.getBuildingByAddress(id);
    }
}
