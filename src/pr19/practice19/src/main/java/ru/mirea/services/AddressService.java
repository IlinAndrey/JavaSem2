package ru.mirea.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.dto.BuildingToAddressRequest;
import ru.mirea.models.Address;
import ru.mirea.repositories.AddressRepository;
import ru.mirea.repositories.BuildingRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Slf4j
@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private BuildingRepository buildingRepository;

    public void publish(BuildingToAddressRequest request) {
        String addressName = request.getGroupName();
        Address address = addressRepository.findByAddressName(addressName);
        if (address != null) {
            return;
        }
        address = new Address();
        address.setAddressName(request.getGroupName());
        addressRepository.save(address);
    }

    @Transactional
    public <T> T takeAllAddresses(Function<List<Address>, T> toDto) {
        List<Address> addresses = addressRepository.findAll();
        return toDto.apply(addresses);
    }

    @Transactional
    public <T> T takeAddressById(long id, Function<Address, T> toDto) {
        Optional<Address> address = addressRepository.findById(id);
        if (address.isEmpty()) {
            return null;
        }
        return toDto.apply(address.get());
    }

    @Transactional
    public void delete(long id) {
        Optional<Address> address = addressRepository.findById(id);
        if (address.isEmpty()) {
            return;
        }
        buildingRepository.deleteAllByAddress(address.get());
        addressRepository.deleteById(id);
    }
}
