package ru.mirea.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.dto.BuildingToAddressRequest;
import ru.mirea.models.Address;
import ru.mirea.models.Building;
import ru.mirea.repositories.AddressRepository;
import ru.mirea.repositories.BuildingRepository;

import java.util.List;

@Slf4j
@Service
public class BuildingService {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private BuildingRepository buildingRepository;

    public void publish(BuildingToAddressRequest request) {
        String addressName = request.getGroupName();
        Address address = addressRepository.findByAddressName(addressName);
        if (address == null) {
            return;
        }
        Building building = new Building();
        building.setCreationDate(request.getBuildingCreationDate());
        building.setType(request.getBuildingType());
        building.setAddress(address);
        buildingRepository.save(building);

        // Testing Criteria API
        log.info("*****Criteria API*****");
        List<Building> buildingsByAddressName = buildingRepository.findBuildingsByAddressName("sadad");
        log.info("-Students by group name:");
        buildingsByAddressName
                .forEach(st ->
                        log.info(st.getType() + " " + st.getCreationDate() + " -- " + st.getAddress().getAddressName())
                );

        List<Building> buildingsByFirstAndLastName = buildingRepository.findBuildingsByFirstNameAndLastName("Jack", "Dorsey");
        log.info("-Students by first and last name:");
        buildingsByFirstAndLastName
                .forEach(st ->
                        log.info(st.getType() + " " + st.getCreationDate() + " -- " + st.getAddress().getAddressName())
                );
    }

    public void delete(long id) {
        buildingRepository.deleteById(id);
    }
}
