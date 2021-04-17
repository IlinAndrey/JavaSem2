package ru.mirea.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.models.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    Address findByAddressName(String groupName);
}
