package ru.mirea.dto;

import org.springframework.stereotype.Component;
import ru.mirea.models.Address;
import ru.mirea.models.Building;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DtoConverter {
    public List<BuildingResponse> toBuildingResponseList(List<Building> buildings) {
        return buildings.stream().map(building -> {
            BuildingResponse response = new BuildingResponse();
            response.setId(building.getId());
            response.setCreationDate(building.getCreationDate());
            response.setType(building.getType());
            return response;
        }).collect(Collectors.toList());
    }

    public AddressResponse toAddressResponse(Address address) {
        AddressResponse response = new AddressResponse();
        response.setId(address.getId());
        response.setAddressName(address.getAddressName());
        response.setBuildings(toBuildingResponseList((address.getBuildings())));
        return response;
    }

    public List<AddressResponse> toAddressResponseList(List<Address> addresses) {
        return addresses.stream()
                .map(this::toAddressResponse)
                .collect(Collectors.toList());
    }
}
