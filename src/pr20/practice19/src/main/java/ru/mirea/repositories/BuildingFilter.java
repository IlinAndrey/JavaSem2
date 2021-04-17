package ru.mirea.repositories;

import ru.mirea.models.Building;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface BuildingFilter {
    List<Building> findBuildingsByAddressName(String groupName);
    List<Building> findBuildingsByFirstNameAndLastName(String cDate, String lName);
}
