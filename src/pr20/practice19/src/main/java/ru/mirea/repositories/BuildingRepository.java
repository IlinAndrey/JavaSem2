package ru.mirea.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.models.Address;
import ru.mirea.models.Building;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long>, BuildingFilter {
    void deleteAllByAddress(Address group);
}
