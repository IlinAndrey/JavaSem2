package app.Application.Services;

import app.Application.Classes.Address;
import app.Application.Classes.Building;
import lombok.extern.slf4j.Slf4j;
import app.Application.Interfaces.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class AddressService {
    @Autowired
    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public void addAddress(Address address) {
        addressRepository.save(address);
    }

    public List<Address> getAddress() {
        return addressRepository.findAll();
    }

    public List<Address> getByAddressText(String zipCode) {
        return addressRepository.findAllByZipCode(zipCode);
    }

    public List<Address> getByAddress(String addressText) {
        return addressRepository.findAllByAddressText(addressText);
    }

    public void deleteAddress(UUID id) {
        addressRepository.deleteById(id);
    }

    public Building getBuildingByAddress(UUID id) {
        return addressRepository.findById(id).getBuilding();
    }
}
